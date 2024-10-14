package com.heap.max;

import java.util.Collections;
import java.util.PriorityQueue;

/*
2530. Maximal Score After Applying K Operations

You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

In one operation:

choose an index i such that 0 <= i < nums.length,
increase your score by nums[i], and
replace nums[i] with ceil(nums[i] / 3).
Return the maximum possible score you can attain after applying exactly k operations.

The ceiling function ceil(val) is the least integer greater than or equal to val.



Example 1:

Input: nums = [10,10,10,10,10], k = 5
Output: 50
Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.

TC : o(nlogn)
SC: o(n)
 */
public class MaximalScoreAfterApplyingKOperations {

    public static void main(String[] args) {
        System.out.println(new MaximalScoreAfterApplyingKOperations().maxKelements(
                new int[]{10,10,10,10,10}, 5
        ));
    }
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        // Create a max-heap to store the elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        for (int i : nums) {
            pq.add(i);
        }

        while (k-- > 0) {
            // Add the maxElement in ans and push its one-third value in the
            // priority queue
            int maxElement = pq.poll();
            ans += maxElement;
            pq.add((int) Math.ceil(maxElement / 3.0));
        }
        return ans;
    }
}
