package com.slidingwindow;

import java.util.Arrays;

/*
2747. Count Zero Request Servers

You are given an integer n denoting the total number of servers and a 2D 0-indexed integer array logs, where
logs[i] = [server_id, time] denotes that the server with id server_id received a request at time time.

You are also given an integer x and a 0-indexed integer array queries.

Return a 0-indexed integer array arr of length queries.length where arr[i] represents the number of servers that did
not receive any requests during the time interval [queries[i] - x, queries[i]].

Note that the time intervals are inclusive.



Example 1:

Input: n = 3, logs = [[1,3],[2,6],[1,5]], x = 5, queries = [10,11]
Output: [1,2]
Explanation:
For queries[0]: The servers with ids 1 and 2 get requests in the duration of [5, 10]. Hence, only server 3 gets
zero requests.
For queries[1]: Only the server with id 2 gets a request in duration of [6,11]. Hence, the servers with ids 1 and 3
are the only servers that do not receive any requests during that time period.

TC : O(mlogm+klogk)
SC: O(n+k+logm+logk)
 */
public class CountZeroRequestServers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountZeroRequestServers().countServers(
                3, new int[][]{{1, 3}, {2, 6}, {1, 5}}, 5, new int[]{10, 11}
        )));
    }

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int m = queries.length;
        Integer[] ids = new Integer[m];
        for (int i = 0; i < m; i++) ids[i] = i;
        Arrays.sort(ids, (i, j) -> Integer.compare(queries[i], queries[j]));

        int[] ans = new int[m];
        int[] cnt = new int[n + 1];
        int left = 0,
                right = 0,
                active = 0;

        for (int i : ids) {
            int q = queries[i];
            while (right < logs.length && logs[right][1] <= q) {
                int id = logs[right++][0];
                if (cnt[id]++ == 0) {
                    ++active;
                }
            }
            while (left < right && logs[left][1] < q - x) {
                int id = logs[left++][0];
                if (--cnt[id] == 0) {
                    --active;
                }
            }
            ans[i] = n - active;
        }
        return ans;
    }
}
