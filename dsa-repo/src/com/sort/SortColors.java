package com.sort;

import java.util.Arrays;

/*
75. Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

TC : o(n)
SC: o(1)
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums= new int[]{2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        int left = 0, mid =0, right = nums.length-1;

        while(mid<=right){

            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;
                left++;
                mid++;
            } else if(nums[mid]==1)
                mid++;
            else{
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }
}
