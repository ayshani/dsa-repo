package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
2958. Length of Longest Subarray With at Most K Frequency

You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,2,3,1,2,3,1,2], k = 2
Output: 6
Explanation: The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3 occur at most
twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
It can be shown that there are no good subarrays with length more than 6.

TC : o(n)
SC: o(n)
 */
public class LengthOfLongestSubarrayWithAtMostKFrequency {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubarrayWithAtMostKFrequency()
                .maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2},2));
    }
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int maxLength = 0;
        for(int start=0, end =0; end <n;end++){
            int num = nums[end];
            map.put(num, map.getOrDefault(num,0)+1);

            if(map.get(num)>k){
                while(nums[start]!= num){
                    map.put(nums[start], map.get(nums[start])-1);
                    start++;
                }
                map.put(num, map.get(num)-1);
                start++;
            }
            maxLength= Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}
