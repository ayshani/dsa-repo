package com.sort;

import java.util.Arrays;
import java.util.LinkedList;

/*
56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all
the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Logic
------
Sort he array in ascending order of start of the interval.
iterate over whole array
    incase the last added interval is overlapping with current one,
    update the last interval's end time to the greatest one.

TC : o(nlogn)
SC : o(n)
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,3}, {2,6},{8,10},{15,18}
        };

        int[][] result = new MergeIntervals().merge(intervals);

        Arrays.stream(result).forEach(interval -> {Arrays.stream(interval).forEach(e -> System.out.print(e+" "));
                                                    System.out.println();});
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0],b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1]<interval[0])
                merged.add(interval);
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1],interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
