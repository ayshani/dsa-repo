package com.array;
/*
169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority
element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3

TC : o(n)
SC: o(1)
 */
public class MajorityElement {

    public static void main(String[] args) {
        //int[] nums = new int[]{2,2,1,1,1,2,2};
        int[] nums = new int[]{9,5,5,1,1};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int major = nums[0], count =1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                major = nums[i];
                count++;
            } else if(major == nums[i]){
                count++;
            } else{
                count--;
            }
        }

        return major;
    }
}
