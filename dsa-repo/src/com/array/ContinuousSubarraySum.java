package com.array;

import java.util.HashMap;
import java.util.Map;

/*
523. Continuous Subarray Sum

Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two
whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

TC : o(n)
SC : o(n)s
 */
public class ContinuousSubarraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{23,2,6,4,7};
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(nums,6));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(k!=0){
                sum%=k;
            }

            Integer prev = map.get(sum);
            if(prev!=null){
                // this checks if there is more than one element in subarray
                if(i-prev>1)
                    return true;
            }  else
                map.put(sum,i);
        }

        return false;
    }
}
