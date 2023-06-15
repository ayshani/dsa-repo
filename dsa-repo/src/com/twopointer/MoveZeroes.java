package com.twopointer;

import java.util.Arrays;

/*
283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

TC : o(n)
SC: o(1)
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    // this doesnt guareente relative ordering
    public void moveZeroesV1(int[] nums) {
        int start =0, end = nums.length-1;
        while(start<end){
            if(nums[start]==0){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                end--;
            } else{
                start++;
            }
        }
    }

    // this implements relative ordering of non-zero elements
    public void moveZeroes(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index++] =nums[i];
            }
        }

        for(int i= index;i<nums.length;i++){
            nums[i] =0;
        }
    }
}
