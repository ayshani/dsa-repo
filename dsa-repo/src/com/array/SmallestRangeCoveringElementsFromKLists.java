package com.array;

import java.util.Arrays;
import java.util.List;

/*
632. Smallest Range Covering Elements from K Lists

You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one
number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.



Example 1:

Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation:
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].

TC : o(nk)
SC: o(n)
 */
public class SmallestRangeCoveringElementsFromKLists {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SmallestRangeCoveringElementsFromKLists().smallestRange(
                List.of(List.of(4,10,15,24,26), List.of(0,9,12,20), List.of(5,18,22,30))
        )));
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        // Stores the current index of each list
        int[] indices = new int[k];
        // To track the smallest range
        int[] range = new int[] { 0, Integer.MAX_VALUE };

        while (true) {
            int curMin = Integer.MAX_VALUE, curMax =
                    Integer.MIN_VALUE, minListIndex = 0;

            // Find the current minimum and maximum values across the lists
            for (int i = 0; i < k; i++) {
                int currentElement = nums.get(i).get(indices[i]);

                // Update the current minimum
                if (currentElement < curMin) {
                    curMin = currentElement;
                    minListIndex = i;
                }

                // Update the current maximum
                if (currentElement > curMax) {
                    curMax = currentElement;
                }
            }

            // Update the range if a smaller one is found
            if (curMax - curMin < range[1] - range[0]) {
                range[0] = curMin;
                range[1] = curMax;
            }

            // Move to the next element in the list that had the minimum value
            if (++indices[minListIndex] == nums.get(minListIndex).size()) break;
        }

        return range;
    }
}
