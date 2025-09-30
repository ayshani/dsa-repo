package com.dp;
/*
2221. Find Triangular Sum of an Array

You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).

The triangular sum of nums is the value of the only element present in nums after the following process terminates:

Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
Replace the array nums with newNums.
Repeat the entire process starting from step 1.
Return the triangular sum of nums.



Example 1:
Input: nums = [1,2,3,4,5]
Output: 8
Explanation:
The above diagram depicts the process from which we obtain the triangular sum of the array.

TC : o(n^2)
SC: o(1)

Explanation :
1  2  3  4  5
  3  5  7  9
    8  2  6
      0  8
        8

ans - 8
 */
public class FindTriangularSumOfAnArray {

    public static void main(String[] args) {
        System.out.println(new FindTriangularSumOfAnArray().triangularSum(new int[]{1,2,3,4,5}));
    }
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        for(int i=n;i>0;--i){
            for(int j=1;j<i;++j){
                nums[j-1]+=nums[j];
                nums[j-1]%=10;
            }
        }

        return nums[0];
    }
}
