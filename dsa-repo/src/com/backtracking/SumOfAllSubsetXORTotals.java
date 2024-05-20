package com.backtracking;
/*
1863. Sum of All Subset XOR Totals

The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
Given an array nums, return the sum of all XOR totals for every subset of nums.

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.



Example 1:

Input: nums = [1,3]
Output: 6
Explanation: The 4 subsets of [1,3] are:
- The empty subset has an XOR total of 0.
- [1] has an XOR total of 1.
- [3] has an XOR total of 3.
- [1,3] has an XOR total of 1 XOR 3 = 2.
0 + 1 + 3 + 2 = 6

TC : o(2^N)
SC: O(N)
 */
public class SumOfAllSubsetXORTotals {

    public static void main(String[] args) {
        System.out.println(new SumOfAllSubsetXORTotals().subsetXORSum(new int[]{1,3}));
    }
    public int subsetXORSum(int[] nums) {
        return util(nums, 0,0);
    }

    private int util(int[] nums, int index, int currentXor){
        if(index== nums.length){
            return currentXor;
        }

        int withElement = util(nums, index+1, nums[index]^currentXor);
        int withoutElement = util(nums, index+1, currentXor);
        return withElement + withoutElement;
    }
}
