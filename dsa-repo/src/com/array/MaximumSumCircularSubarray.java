package com.array;
/*
918. Maximum Sum Circular Subarray

Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally,
the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally,
for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.



Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.

TC : o(n)
SC : o(1)
 */
public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{3,-2,3};
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(nums));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int withoutWrapping = kadane(nums);

        if(withoutWrapping<0)
            return withoutWrapping;

        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[i]=-1*nums[i];
        }

        int x= kadane(nums);

        int withWrapping = x<0? sum : sum+x;

        return Math.max(withWrapping,withoutWrapping);
    }

    private int kadane(int[] nums){
        int maxSum = nums[0], sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxSum=Math.max(maxSum,sum);
            if(sum<0)
                sum=0;
        }

        return maxSum;
    }
}
