package com.array;

import java.util.Arrays;

/*
976. Largest Perimeter Triangle

Given an integer array nums, return the largest perimeter of a triangle with a non-zero area,
formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

Example 1:

Input: nums = [2,1,2]
Output: 5

TC : o(n)
SC : o(1)
 */
public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2};
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(nums));
    }
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i= nums.length-3; i>=0;--i){
            if(nums[i]+ nums[i+1] > nums[i+2]){
                return nums[i]+ nums[i+1] + nums[i+2];
            }
        }
        return 0;
    }
}
