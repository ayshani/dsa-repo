package com.array;

import java.util.Arrays;

/*
1929. Concatenation of Array

Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i]
and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.



Example 1:

Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]

TC : o(n)
SC: o(n)
 */
public class ConcatenationOfArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConcatenationOfArray().getConcatenation(new int[]{1,2,3,1})));
    }
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2*n];
        for(int i=0;i<n;i++){
            res[i]= nums[i];
            res[n+i] = nums[i];
        }
        return res;
    }
}
