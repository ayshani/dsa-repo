package com.heap.min;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
3264. Final Array State After K Multiplication Operations I

You are given an integer array nums, an integer k, and an integer multiplier.

You need to perform k operations on nums. In each operation:

Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
Replace the selected minimum value x with x * multiplier.
Return an integer array denoting the final state of nums after performing all k operations.



Example 1:

Input: nums = [2,1,3,5,6], k = 5, multiplier = 2

Output: [8,4,6,5,6]

Explanation:

Operation	Result
After operation 1	[2, 2, 3, 5, 6]
After operation 2	[4, 2, 3, 5, 6]
After operation 3	[4, 4, 3, 5, 6]
After operation 4	[4, 4, 6, 5, 6]
After operation 5	[8, 4, 6, 5, 6]

TC : o(n*klogn)
SC: o(n)
 */
public class FinalArrayStateAfterKMultiplicationOperationsI {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FinalArrayStateAfterKMultiplicationOperationsI().getFinalState(
                new int[]{2,1,3,5,6},5,2
        )));
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int valueComparison = Integer.compare(a[0], b[0]);
            if (valueComparison == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return valueComparison;
        });

        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] { nums[i], i });
        }

        while (k-- > 0) {
            int[] smallest = heap.poll();
            int index = smallest[1];

            nums[index] *= multiplier;
            heap.offer(new int[] { nums[index], index });
        }

        return nums;
    }
}
