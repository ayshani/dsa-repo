package com.greedy;

import java.util.Arrays;

/*
435. Non-overlapping Intervals

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
you need to remove to make the rest of the intervals non-overlapping.



Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

Intuition

Finding the minimum number of intervals to remove is equivalent to finding the maximum number of non-overlapping
intervals. This is the famous interval scheduling problem.

Let's start by considering the intervals according to their end times. Consider the two intervals with the earliest
end times. Let's say the earlier end time is x and the later one is y. We have x < y.

If we can only choose to keep one interval, should we choose the one ending at x or ending at y? To avoid overlap,
We should always greedily choose the interval with an earlier end time x. The intuition behind this can be summarized
as follows:

We choose either x or y. Let's call our choice k.
To avoid overlap, the next interval we choose must have a start time greater than or equal to k.
We want to maximize the intervals we take (without overlap), so we want to maximize our choices for the next interval.
Because the next interval must have a start time greater than or equal to k, a larger value of k can never give us
more choices than a smaller value of k.
As such, we should try to minimize k. Therefore, we should always greedily choose x, since x < y.
In general, k is equal to the end time of the most recent interval we kept.

Start by sorting intervals according to the end times so that we can process the intervals in order.
We'll keep the variable k described above.

Because we sorted the end times, y must be greater than k. This gives us two cases:

Case 1, x >= k: we can safely take this interval because it won't cause an overlap. We should update k = y since
this interval is now the most recent interval we are keeping.
Case 2, x < k: taking this interval would cause an overlap. As we established earlier, we should always take
intervals with earlier end times. Because y > k, we must delete the current interval (don't update k).

Algorithm

Sort intervals according to the end times.
Initialize an answer variable ans = 0 and an integer k to represent the most recent end time.
    k should be initialized to a small value like INT_MIN.
Iterate over the intervals. For each interval:
If the start time is greater than or equal to k, update k to the end time of the current interval.
Otherwise, increment ans.
Return ans.


TC : o(nlogn)
SC: o(logn)
In Java, Arrays.sort() is implemented using a variant of the Quick Sort algorithm, which has a space complexity
of O(logn)
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,2},{2,3},{3,4},{1,3}
        };
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
        int ans =0, k = Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            int x = intervals[i][0], y = intervals[i][1];
            if(x>=k){
                //case1
                k=y;
            } else{
                ans++;
            }
        }
        return ans;
    }
}
