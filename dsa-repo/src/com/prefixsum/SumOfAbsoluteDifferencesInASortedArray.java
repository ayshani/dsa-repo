package com.prefixsum;

import java.util.Arrays;

/*
1685. Sum of Absolute Differences in a Sorted Array

You are given an integer array nums sorted in non-decreasing order.

Build and return an integer array result with the same length as nums such that result[i]
is equal to the summation of absolute differences between nums[i] and all the other elements in the array.

In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).



Example 1:

Input: nums = [2,3,5]
Output: [4,3,5]
Explanation: Assuming the arrays are 0-indexed, then
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.

Logic
------
Absolute difference between two ints = the bigger - the smaller. Therefore,
         absolute difference of nums[i] with first i numbers
res[i] = (nums[i] - nums[0]) + (nums[i] - nums[1]) + ... + (nums[i] - nums[i - 1])
         absolute difference of nums[i] with last n - i numbers
+ (nums[i] - nums[i]) + (nums[i + 1] - nums[i]) + (nums[i + 2] - nums[i]) + ... + (nums[n - 1] - nums[i])

after simplification:
absolute difference of nums[i] with first i numbers
res[i] = i * nums[i] - (nums[0] + ... + nums[i - 1])
absolute difference of nums[i] with last n - i numbers
 + (nums[i + 1] + ... + nums[n]) - (n - i) * nums[i]

That is

res[i] = i * nums[i] - prefixSum[i] + (prefixSum[n] - prefixSum[i] - (n - i) * nums[i])
 */
public class SumOfAbsoluteDifferencesInASortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,6,8,10};
        SumOfAbsoluteDifferencesInASortedArray obj = new SumOfAbsoluteDifferencesInASortedArray();
        int[] res = obj.getSumAbsoluteDifferences(nums);

        Arrays.stream(res).forEach(value -> System.out.print(value + " "));
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        for(int i=0;i<n;i++){
            res[i] = nums[i]*i - prefixSum[i] +(prefixSum[n]-prefixSum[i]-nums[i]*(n-i));
        }

        return res;
    }
}
