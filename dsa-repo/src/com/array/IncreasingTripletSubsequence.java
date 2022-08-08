package com.array;
/*
334. Increasing Triplet Subsequence

Given an integer array nums,
return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
If no such indices exists, return false.


Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(nums));
    }
    public boolean increasingTriplet(int[] nums) {
        int i=Integer.MAX_VALUE, j=i;
        if(nums.length<3)
            return false;
        for(int k : nums){
            if(k<i)
                i=k;
            if(k>i && j>k)
                j=k;
            if(k>i && k>j)
                return true;
        }

        return false;
    }
}
