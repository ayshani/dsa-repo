package com.prefixsum;
/*
1991. Find the Middle Index in Array

Given a 0-indexed integer array nums, find the leftmost middleIndex
(i.e., the smallest amongst all the possible ones).

A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] ==
nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].

If middleIndex == 0, the left side sum is considered to be 0. Similarly,
if middleIndex == nums.length - 1, the right side sum is considered to be 0.

Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.

Example 1:

Input: nums = [2,3,-1,8,4]
Output: 3
Explanation: The sum of the numbers before index 3 is: 2 + 3 + -1 = 4
The sum of the numbers after index 3 is: 4 = 4
 */
public class FindTheMiddleIndexInArray {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-1,8,4};
        System.out.println(new FindTheMiddleIndexInArray().findMiddleIndex(nums));
    }
    public int findMiddleIndex(int[] nums) {
        int leftSum=0, sum =0;
        for(int num: nums)
            sum+=num;

        for(int i=0;i<nums.length;leftSum+=nums[i++]){
            if(leftSum*2  == sum - nums[i])
                return i;
        }

        return -1;
    }
}
