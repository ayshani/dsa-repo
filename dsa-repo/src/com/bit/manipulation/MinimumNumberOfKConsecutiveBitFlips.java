package com.bit.manipulation;

import java.util.Deque;
import java.util.LinkedList;

/*
995. Minimum Number of K Consecutive Bit Flips

You are given a binary array nums and an integer k.

A k-bit flip is choosing a subarray of length k from nums and simultaneously changing every 0 in the subarray to 1,
and every 1 in the subarray to 0.

Return the minimum number of k-bit flips required so that there is no 0 in the array. If it is not possible,
return -1.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [0,1,0], k = 1
Output: 2
Explanation: Flip nums[0], then flip nums[2].

TC : o(n)
SC: o(k)
 */
public class MinimumNumberOfKConsecutiveBitFlips {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[]{0,1,0}, 1));
    }
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length; // Length of the input array
        Deque<Integer> flipQueue = new LinkedList<>(); // Queue to keep track of flips
        int flipped = 0; // Current flip state
        int result = 0; // Total number of flips

        for (int i = 0; i < n; i++) {
            // Remove the effect of the oldest flip if it's out of the current window
            if (i >= k) {
                flipped ^= flipQueue.poll();
            }

            // If the current bit is 0 (i.e., it needs to be flipped)
            if (flipped == nums[i]) {
                // If we cannot flip a subarray starting at index i
                if (i + k > n) {
                    return -1;
                }
                // Add a flip at this position
                flipQueue.offer(1);
                flipped ^= 1; // Toggle the flipped state
                result += 1; // Increment the flip count
            } else {
                flipQueue.offer(0);
            }
        }

        return result;
    }
}
