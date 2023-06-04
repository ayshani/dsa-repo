package com.binarysearch;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
436. Find Right Interval

You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i,
then put -1 at index i.

Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.

TC : o(nlogn)
SC: o(n)
 */
public class FindRightInterval {


    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {3,4},{2,3},{1,2}
        };
        System.out.println(Arrays.toString(new FindRightInterval().findRightInterval(intervals)));
    }
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i=0;i<intervals.length;i++){
            map.put(intervals[i][0],i);
        }

        for(int i=0;i<intervals.length;i++){
            Map.Entry<Integer,Integer> entry = map.ceilingEntry(intervals[i][1]);
            res[i] = entry==null ? -1 : entry.getValue();
        }

        return res;
    }
}
