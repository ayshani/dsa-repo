package com.twopointer;
/*
287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2

TC : o(n)
SC: o(1)
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int slow =0, fast =0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow =0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
