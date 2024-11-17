package com.heap.min;

import java.util.PriorityQueue;

/*
862. Shortest Subarray with Sum at Least K

Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [1], k = 1
Output: 1

TC : o(nlogn)
SC: o(n)
 */
public class ShortestSubarrayWithSumAtLeastK {

    public static void main(String[] args) {
        System.out.println(new ShortestSubarrayWithSumAtLeastK().shortestSubarray(new int[]{1},1));
    }
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Initialize result to the maximum possible integer value
        int shortestSubarrayLength = Integer.MAX_VALUE;

        long cumulativeSum = 0;

        // Min-heap to store cumulative sum and its corresponding index
        PriorityQueue<PPair> prefixSumHeap = new PriorityQueue<>(
                (a, b) -> Long.compare(a.getKey(), b.getKey())
        );

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Update cumulative sum
            cumulativeSum += nums[i];

            // If cumulative sum is already >= k, update shortest length
            if (cumulativeSum >= k) {
                shortestSubarrayLength = Math.min(
                        shortestSubarrayLength,
                        i + 1
                );
            }

            // Remove subarrays from heap that can form a valid subarray
            while (
                    !prefixSumHeap.isEmpty() &&
                            cumulativeSum - prefixSumHeap.peek().getKey() >= k
            ) {
                // Update shortest subarray length
                shortestSubarrayLength = (int) Math.min(
                        shortestSubarrayLength,
                        i - prefixSumHeap.poll().getValue()
                );
            }

            // Add current cumulative sum and index to heap
            prefixSumHeap.offer(new PPair((int) cumulativeSum, i));
        }

        // Return -1 if no valid subarray found
        return shortestSubarrayLength == Integer.MAX_VALUE
                ? -1
                : shortestSubarrayLength;
    }
}

class PPair{
    int sum;
    int i;
    public PPair(int sum, int i){
        this.sum = sum;
        this.i = i;
    }

    public long getKey() {
        return sum;
    }

    public long getValue() {
        return i;
    }
}
