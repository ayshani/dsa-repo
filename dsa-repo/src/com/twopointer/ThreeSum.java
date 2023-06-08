package com.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such
that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

TC: o(n^2)
SC: o(1)
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(new ThreeSum().threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<nums.length-2;i++){
            if(i==0 || nums[i]!= nums[i-1]) {
                int j =i+1, k = nums.length-1;
                while(j<k){
                    long sum = nums[i] + nums[j] + nums[k];
                    if(sum==0){
                        res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                        while(j<k && nums[j]== nums[j-1])
                            j++;
                        while(j<k && nums[k]== nums[k+1])
                            k--;

                    } else if(sum<0){
                        j++;
                    } else{
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
