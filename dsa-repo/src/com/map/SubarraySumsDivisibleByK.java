package com.map;

import java.util.HashMap;
import java.util.Map;

/*
974. Subarray Sums Divisible by K

Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

TC : o(n)
SC: o(unique sums)
 */
public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,0,-2,-3,1};
        System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(nums,5));
    }
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum =0, count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum = (sum+nums[i])%k;
            if(sum<0)
                sum+=k;
            int countOfCurrentSum = map.getOrDefault(sum,0);
            count+=countOfCurrentSum;
            map.put(sum, countOfCurrentSum+1);
        }

        return count;
    }
}
