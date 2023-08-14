package com.heap.min;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k =2;
        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums,k));

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }
}
