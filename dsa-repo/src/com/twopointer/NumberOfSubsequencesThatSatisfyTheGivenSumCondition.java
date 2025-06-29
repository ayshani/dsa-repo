package com.twopointer;

import java.util.Arrays;

/*
1498. Number of Subsequences That Satisfy the Given Sum Condition

You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element
on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

Example 1:

Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)

TC : o(nlogn)
SC: o(n)
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,6,7};
        System.out.println(new NumberOfSubsequencesThatSatisfyTheGivenSumCondition().numSubseq(nums,9));
    }
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, mod = 1000000007;
        int[] pow = new int[n];
        int l =0, r = n-1, res =0;
        pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i] = pow[i-1]*2%mod;
        }
        while(l<=r){
            if(nums[l]+ nums[r]>target){
                r--;
            } else{
                res = (res + pow[r-l])%mod;
                l++;
            }
        }

        return res;
    }
}
