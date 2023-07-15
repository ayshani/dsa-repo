package com.dp;

import java.util.Arrays;

/*
1751. Maximum Number of Events That Can Be Attended II

You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi
and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer
k which represents the maximum number of events you can attend.

You can only attend one event at a time. If you choose to attend an event, you must attend the entire event.
Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other
ends on the same day.

Return the maximum sum of values that you can receive by attending events.

Example 1:
Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
Output: 7
Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.

Algorithm----
Let dfs(cur_index) represent the maximum value obtained by attending events optimally in the range
events[cur_index ~ n - 1]

For event cur_index, we have two options:

attend the current event and gain a value of events[cur_index][2]. Then we need to find the nearest event
that we can attend after event cur_index. Recall that we have sorted events by start time. We can apply binary
search to find the index where we should insert the end time of the current event cur_index in the sorted list
of start times. Let's say the nearest one is event next_index. Thus dfs(cur_index) is the larger value between
the two options:

attend the current event and obtain a value of events[cur_index][2] + dfs(next_index).

skip the current event, move on to the next event, and gain a value of dfs(cur_index + 1).

which is denoted as dfs(cur_index) = max(dfs(cur_index + 1), dfs(next_index) + events[cur_index][2]).

Complexity Analysis
Let n be the length of the input string s.

Time complexity: nO(n⋅k⋅logn)

Sorting events takes nO(nlogn) time.
We build dp, a 2D array of size O(n×k) as memory, equal to the number of possible states. Each state is
computed with a binary search over all start times, which takes O(logn).
Space complexity: O(n⋅k)

We build a 2D array of size O(n×k) as memory.
In the Python solution, we also create an array with length n, which takes O(n) space.
The space complexity of a recursive call depends on the maximum depth of the recursive call stack, which is
n+k. As each recursive call either increments cur_index by 1 and/or decrements count by 1. Therefore, at most
O(n+k) levels of recursion will be created, and each level consumes a constant amount of space.
 */
public class MaximumNumberOfEventsThatCanBeAttendedII {

    public static void main(String[] args) {
        int[][] events = new int[][]{
                {1,2,4},{3,4,3},{2,3,1}
        };
        System.out.println(new MaximumNumberOfEventsThatCanBeAttendedII().maxValue(events,2));
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a, b)-> a[0]-b[0]);
        int n = events.length;
        Integer[][] dp = new Integer[k+1][n];
        return dfs(0,k,events,dp);
    }

    private int dfs(int cur, int k, int[][] events, Integer[][] dp){
        if(k==0 || cur == events.length)
            return 0;
        if(dp[k][cur]!=null)
            return dp[k][cur];

        int nextIndex = getNextIndex(events, events[cur][1]);
        dp[k][cur] = Math.max(dfs(cur+1,k,events,dp),
                events[cur][2] + dfs(nextIndex, k-1,events,dp));
        return dp[k][cur];
    }

    private int getNextIndex(int[][] events, int target){
        int start =0, end = events.length;
        while(start<end){
            int mid = start +(end-start)/2;
            if(events[mid][0]<=target){
                start = mid +1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
