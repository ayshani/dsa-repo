package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
57. Insert Interval

You are given an array of non-overlapping intervals intervals where
intervals[i] = [starti, endi] represent the start and the end of the ith interval and
intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending
order by starti and intervals still does not have any overlapping intervals
(merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

TC : o(n)
SC : o(n)

 */
public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1,2},{3,5},{6,7},{8,10},{12,16}
        };

        int[] newInterval = new int[]{4,8};

        int[][] result = new InsertInterval().insert(intervals,newInterval);
        Arrays.stream(result).forEach(interval -> {Arrays.stream(interval).forEach(e -> System.out.print(e+" "));
            System.out.println();});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i=0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // merge all overlapping intervals to one considering newInterval
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);

            i++;
        }

        // add the union of intervals we got
        result.add(newInterval);

        // add all the rest
        while(i<intervals.length){
            result.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
