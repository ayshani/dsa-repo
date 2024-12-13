package com.heap.min;

import java.util.PriorityQueue;

/*
2593. Find Score of an Array After Marking All Elements

You are given an array nums consisting of positive integers.

Starting with score = 0, apply the following algorithm:

Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
Add the value of the chosen integer to score.
Mark the chosen element and its two adjacent elements if they exist.
Repeat until all the array elements are marked.
Return the score you get after applying the above algorithm.



Example 1:

Input: nums = [2,1,3,4,5,2]
Output: 7
Explanation: We mark the elements as follows:
- 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
- 2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
- 4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
Our score is 1 + 2 + 4 = 7.

TC : o(nlogn)
SC: o(n)
 */
public class FindScoreOfAnArrayAfterMarkingAllElements {

    public static void main(String[] args) {
        System.out.println(new FindScoreOfAnArrayAfterMarkingAllElements().findScore(
                new int[]{2,1,3,4,5,2}
        ));
    }
    public long findScore(int[] nums) {
        long ans = 0;
        boolean[] marked = new boolean[nums.length];

        PriorityQueue<int[]> heap = new PriorityQueue<>((arr1, arr2) -> {
            if (arr1[0] != arr2[0]) return arr1[0] - arr2[0];
            return arr1[1] - arr2[1];
        });

        for (int i = 0; i < nums.length; i++) {
            heap.add(new int[] { nums[i], i });
        }

        while (!heap.isEmpty()) {
            int[] element = heap.remove();
            int number = element[0];
            int index = element[1];
            if (!marked[index]) {
                ans += number;
                marked[index] = true;
                // mark adjacent elements if they exist
                if (index - 1 >= 0) {
                    marked[index - 1] = true;
                }
                if (index + 1 < nums.length) {
                    marked[index + 1] = true;
                }
            }
        }

        return ans;
    }
}
