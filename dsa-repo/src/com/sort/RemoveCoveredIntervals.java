package com.sort;

import java.util.Arrays;

/*
1288. Remove Covered Intervals

Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that
are covered by another interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.



Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

TC : o(nlogn)
SC: o(1)
 */
public class RemoveCoveredIntervals {

    public static void main(String[] args) {
        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(
                new int[][]{{1,4},{3,6},{2,8}}
        ));
    }
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
                a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);

        int count=0, maxEnd =0;

        for(int[] interval : intervals){
            if(interval[1]>maxEnd){
                count++;
                maxEnd = interval[1];
            }
        }
        return count;
    }
}
