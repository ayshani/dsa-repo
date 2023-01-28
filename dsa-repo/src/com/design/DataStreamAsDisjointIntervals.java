package com.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
352. Data Stream as Disjoint Intervals

Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.

Implement the SummaryRanges class:

SummaryRanges() Initializes the object with an empty stream.
void addNum(int value) Adds the integer value to the stream.
int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.


Example 1:

Input
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
Output
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

Explanation
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 */
public class DataStreamAsDisjointIntervals {


    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);

    }
}

class SummaryRanges {
    private Set<Integer> values;

    public SummaryRanges() {
        values = new TreeSet<>();
    }

    public void addNum(int value) {
        values.add(value);
    }

    public int[][] getIntervals() {
        if (values.isEmpty()) {
            return new int[0][2];
        }
        List<int[]> intervals = new ArrayList<>();
        int left = -1, right = -1;
        for (Integer value : values) {
            if (left < 0) {
                left = right = value;
            } else if (value == right + 1) {
                right = value;
            } else {
                intervals.add(new int[] {left, right});
                left = right = value;
            }
        }
        intervals.add(new int[] {left, right});
        return intervals.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
