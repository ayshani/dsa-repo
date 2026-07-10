package com.greedy;

import java.util.Arrays;

/*
3534. Path Existence Queries in a Graph II

You are given an integer n representing the number of nodes in a graph, labeled from 0 to n - 1.

You are also given an integer array nums of length n and an integer maxDiff.

An undirected edge exists between nodes i and j if the absolute difference between nums[i] and nums[j] is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).

You are also given a 2D integer array queries. For each queries[i] = [ui, vi], find the minimum distance between nodes ui and vi. If no path exists between the two nodes, return -1 for that query.

Return an array answer, where answer[i] is the result of the ith query.

Note: The edges between the nodes are unweighted.



Example 1:

Input: n = 5, nums = [1,8,3,4,2], maxDiff = 3, queries = [[0,3],[2,4]]

Output: [1,1]

Explanation:

The resulting graph is:



Query	Shortest Path	Minimum Distance
[0, 3]	0 → 3	1
[2, 4]	2 → 4	1
Thus, the output is [1, 1].

Time complexity: O((n+q)logn)

Space complexity: O(nlogn)

Approach
Sort nodes by value, recording original indices → newNums.
Map original index to sorted position → getI.
Sliding window on sorted array: for each i, find the farthest r reachable where no consecutive gap and total spread b
    both stay ≤ maxDiff. Store as st[i][0].
Binary lifting: build st[i][j] = farthest index reachable from i in 2^j jumps.
Per query: convert both endpoints to sorted positions, binary lift from smaller to reach just before larger,
    check if one more jump covers it.
 */
public class PathExistenceQueriesInAGraphII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PathExistenceQueriesInAGraphII().pathExistenceQueries(
                5, new int[]{1,8,3,4,2}, 3, new int[][]{{0,3},{2,4}}
        )));
    }
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] newNums = new int[n][2];
        for (int i = 0; i < n; i++) newNums[i] = new int[]{nums[i], i};
        Arrays.sort(newNums, (a, b) -> a[0] - b[0]);

        int[] getI = new int[n];
        for (int i = 0; i < n; i++) getI[newNums[i][1]] = i;

        int[][] st = new int[n][18];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (r < i) r = i;
            while (r + 1 < n &&
                    newNums[r + 1][0] - newNums[r][0] <= maxDiff &&
                    newNums[r + 1][0] - newNums[i][0] <= maxDiff)
                r++;
            st[i][0] = r;
        }

        for (int j = 1; j < 18; j++)
            for (int i = 0; i < n; i++)
                st[i][j] = st[st[i][j - 1]][j - 1];

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = getI[queries[i][0]], b = getI[queries[i][1]];
            if (a > b) { int t = a; a = b; b = t; }
            if (a == b) { ans[i] = 0; continue; }

            int curr = a, steps = 0;
            for (int j = 17; j >= 0; j--)
                if (st[curr][j] < b) { curr = st[curr][j]; steps += (1 << j); }

            ans[i] = (st[curr][0] >= b) ? steps + 1 : -1;
        }
        return ans;
    }
}
