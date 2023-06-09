package com.twopointer;

import java.util.Arrays;

/*
16. 3Sum Closest

Given an integer array nums of length n and an integer target, find three integers in nums such that the
sum is closest to target.

Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

TC : o(n^2)
SC : o(1)
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums,1));
    }
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3)
            return 0;
        int closest = nums[0]+nums[1]+nums[2];

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int l = i+1;
            int r = nums.length-1;

            while(l<r){
                int temp = nums[i]+ nums[l]+ nums[r];
                if(temp==target)
                    return temp;
                if(temp <target)
                    l++;
                else
                    r--;
                if(Math.abs(temp-target)< Math.abs(closest-target))
                    closest = temp;
            }
        }

        return closest;
    }
}
