package com.greedy;
/*
3190. Find Minimum Operations to Make All Elements Divisible by Three

You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.

Return the minimum number of operations to make all elements of nums divisible by 3.



Example 1:

Input: nums = [1,2,3,4]

Output: 3

Explanation:

All array elements can be made divisible by 3 using 3 operations:

Subtract 1 from 1.
Add 1 to 2.
Subtract 1 from 4.


 */
public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {

    public static void main(String[] args) {
        System.out.println(new FindMinimumOperationsToMakeAllElementsDivisibleByThree().minimumOperations(
                new int[]{1,2,3,4}
        ));
    }
    public int minimumOperations(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            int rem = x % 3;
            sum += Math.min(rem, 3 - rem);
        }
        return sum;
    }
}
