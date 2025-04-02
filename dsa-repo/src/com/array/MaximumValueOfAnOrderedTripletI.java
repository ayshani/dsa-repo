package com.array;
/*
2873. Maximum Value of an Ordered Triplet I


You are given a 0-indexed integer array nums.

Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.

The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].



Example 1:

Input: nums = [12,6,1,2,7]
Output: 77
Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
It can be shown that there are no ordered triplets of indices with a value greater than 77.

TC : o(n^3)
SC: o(1)
 */
public class MaximumValueOfAnOrderedTripletI {

    public static void main(String[] args) {
        System.out.println(new MaximumValueOfAnOrderedTripletI().maximumTripletValue(new int[]{12,6,1,2,7}));
    }
    public long maximumTripletValue(int[] nums) {
        long maxValue =Long.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){

                    long sum = (nums[i]*1l - nums[j]) * nums[k]*1l;
                    maxValue = Math.max(maxValue, sum);
                    //System.out.println(maxValue);
                }
            }
        }
        //System.out.println(maxValue);
        return maxValue < 0 ? 0 : maxValue;
    }
}
