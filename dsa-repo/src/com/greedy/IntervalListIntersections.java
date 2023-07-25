package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
986. Interval List Intersections

You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and
secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed
interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

In an interval [a, b], call b the "endpoint".

Among the given intervals, consider the interval A[0] with the smallest endpoint. (Without loss of generality,
this interval occurs in array A.)

Then, among the intervals in array B, A[0] can only intersect one such interval in array B. (If two intervals in
B intersect A[0], then they both share the endpoint of A[0] -- but intervals in B are disjoint, which is a
contradiction.)

Algorithm

If A[0] has the smallest endpoint, it can only intersect B[0]. After, we can discard A[0] since it cannot intersect
anything else.

Similarly, if B[0] has the smallest endpoint, it can only intersect A[0], and we can discard B[0] after since it
cannot intersect anything else.

We use two pointers, i and j, to virtually manage "discarding" A[0] or B[0] repeatedly.

Complexity Analysis

Time Complexity: O(M+N), where M,Nare the lengths of A and B respectively.

Space Complexity: O(M+N), the maximum size of the answer.
 */
public class IntervalListIntersections {

    public static void main(String[] args) {
        int[][] f = new int[][]{{0,2},{5,10},{13,23},{24,25}}, s = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][] res = new IntervalListIntersections().intervalIntersection(f,s);
        Arrays.stream(res).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i=0, j=0;

        while(i<firstList.length && j< secondList.length){
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int low = Math.max(firstList[i][0],secondList[j][0]);
            int high = Math.min(firstList[i][1],secondList[j][1]);

            if(low<=high)
                res.add(new int[]{low,high});

            if(firstList[i][1]<secondList[j][1])
                i++;
            else
                j++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
