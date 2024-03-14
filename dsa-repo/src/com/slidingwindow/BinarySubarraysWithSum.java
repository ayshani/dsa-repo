package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
930. Binary Subarrays With Sum

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
 */
public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSumV1(
                new int[]{1,0,1,0,1}, 2
        ));

        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSumV2(
                new int[]{1,0,1,0,1}, 2
        ));
    }

    /*
    TC : o(n)
    SC: o(n)
     */
    public int numSubarraysWithSumV1(int[] nums, int goal) {
        int prefixSum=0, totalCount=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            prefixSum+= num;
            if(prefixSum==goal){
                totalCount++;
            }

            if(map.containsKey(prefixSum - goal)){
                totalCount += map.get(prefixSum-goal);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return totalCount;
    }

    /*
    TC : o(n)
    SC: o(1)
     */
    public int numSubarraysWithSumV2(int[] nums, int goal) {
        return getAtMostCount(nums,goal) - getAtMostCount(nums,goal-1);
    }

    private int getAtMostCount(int[] nums,int goal){
        int n = nums.length;
        int start=0, prefixSum =0, totalCount =0;
        for(int end =0; end<n;end++){
            prefixSum += nums[end];

            while(start<=end && prefixSum>goal){
                prefixSum -= nums[start++];
            }

            totalCount += (end-start+1);
        }
        return totalCount;
    }
}
