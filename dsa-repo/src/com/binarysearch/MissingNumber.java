package com.binarysearch;
/*
268. Missing Number

Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number
in the range since it does not appear in nums.

TC: o(n)
SC: o(1)
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1};
        System.out.println(new MissingNumber().missingNumber(nums));
    }
    public int missingNumber(int[] nums) {
        int missingNumber = -1, actualMissingNumber =-1;

        int i = nums.length;

        while(i>=0){
            missingNumber ^=i;
            i--;
        }

        for(i=0;i<nums.length;i++){
            actualMissingNumber ^=nums[i];
        }

        actualMissingNumber = actualMissingNumber ^ missingNumber;
        if(actualMissingNumber==-1)
                return nums.length;

        return actualMissingNumber;
    }
}
