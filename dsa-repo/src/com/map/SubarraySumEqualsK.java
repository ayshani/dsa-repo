package com.map;

import java.util.HashMap;
import java.util.Map;

/*
560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

TC : o(n)
SC: o(n)
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new SubarraySumEqualsK().subarraySum(nums,3));
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int prefixSum =0, count =0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            if(map.containsKey(prefixSum-k)){
                count += map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}
