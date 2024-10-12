package com.heap.max;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
2406. Divide Intervals Into Minimum Number of Groups

You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval
[lefti, righti].

You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no
two intervals that are in the same group intersect each other.

Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and
[5, 8] intersect.



Example 1:

Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
Output: 3
Explanation: We can divide the intervals into the following groups:
- Group 1: [1, 5], [6, 8].
- Group 2: [2, 3], [5, 10].
- Group 3: [1, 10].
It can be proven that it is not possible to divide the intervals into fewer than 3 groups.

TC : o(nlogn)
SC: o(n)
 */
public class DivideIntervalsIntoMinimumNumberOfGroups {

    public static void main(String[] args) {
        System.out.println(new DivideIntervalsIntoMinimumNumberOfGroups().minGroups(
                new int[][]{
                        {5,10},{6,8},{1,5},{2,3},{1,10}
                }
        ));
    }
    public int minGroups(int[][] intervals) {
        // Convert the intervals to two events
        // start as {start, 1} and end as {end + 1, -1}
        List<int[]> events = new ArrayList<>();

        for (int[] interval : intervals) {
            events.add(new int[] { interval[0], 1 }); // Start event
            events.add(new int[] { interval[1] + 1, -1 }); // End event (interval[1] + 1)
        }

        // Sort the events first by time, and then by type (1 for start, -1 for end).
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // Sort by type (1 before -1)
            } else {
                return Integer.compare(a[0], b[0]); // Sort by time
            }
        });

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;

        // Sweep through the events
        for (int[] event : events) {
            concurrentIntervals += event[1]; // Track currently active intervals
            maxConcurrentIntervals = Math.max(
                    maxConcurrentIntervals,
                    concurrentIntervals
            ); // Update max
        }

        return maxConcurrentIntervals;
    }
}
