package com.array;

import java.util.Collections;
import java.util.PriorityQueue;

/*
628. Maximum Product of Three Numbers

Given an integer array nums, find three numbers whose product is maximum and return the maximum product.



Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24

TC : o(n)
SC: o(1)
 */
public class MaximumProductOfThreeNumbers {

    public static void main(String[] args) {
        //int[] nums = new int[]{3,2,1,4};
        int[] nums = new int[]{-3,-2,-1,-4};
        System.out.println(new MaximumProductOfThreeNumbers().maximumProduct(nums));
    }
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();


        for(int num : nums){
            minHeap.offer(num);
            maxHeap.offer(num);
            if(maxHeap.size()>3){
                maxHeap.poll();
            }
            if(minHeap.size()>2){
                minHeap.poll();
            }
        }

        int mult =1, max =0;
        while(!maxHeap.isEmpty()){
            max = maxHeap.poll();
            mult*=max;
        }
        while(!minHeap.isEmpty()){
            max *= minHeap.poll();
        }
        return Math.max(mult,max);
    }
}
