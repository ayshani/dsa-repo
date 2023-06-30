package com.array;

import com.slidingwindow.MaxConsecutiveOnesIII;

/*
485. Max Consecutive Ones

Given a binary array nums, return the maximum number of consecutive 1's in the array.



Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
The maximum number of consecutive 1s is 3.

TC : o(n)
SC: o(1)
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount =0, count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) {
                count++;
            }else{
                count=0;
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}
