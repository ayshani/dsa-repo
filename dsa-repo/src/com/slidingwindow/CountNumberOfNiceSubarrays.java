package com.slidingwindow;

import java.util.HashMap;

/*
1248. Count Number of Nice Subarrays

Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd
numbers on it.

Return the number of nice sub-arrays.

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

TC: o(n)
SC: o(n)
 */
public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,1,1};
        System.out.println(new CountNumberOfNiceSubarrays().numberOfSubarrays(nums,3));
    }
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int count =0, prefixSum=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0)
                nums[i] = 1;
            else
                nums[i] =0;
        }

        for(int i=0;i<nums.length;i++){
            prefixSum+= nums[i];

            if(prefixSum==k)
                count++;

            if(map.containsKey(prefixSum-k))
                count+= map.get(prefixSum-k);

            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}
