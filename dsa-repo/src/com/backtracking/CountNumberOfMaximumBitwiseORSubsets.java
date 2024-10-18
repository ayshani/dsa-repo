package com.backtracking;
/*
2044. Count Number of Maximum Bitwise-OR Subsets

Given an integer array nums, find the maximum possible bitwise OR of a subset of nums
and return the number of different non-empty subsets with the maximum bitwise OR.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
Two subsets are considered different if the indices of the elements chosen are different.

The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).

Example 1:

Input: nums = [3,1]
Output: 2
Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
- [3]
- [3,1]

Example 2:

Input: nums = [3,2,1,5]
Output: 6
Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
- [3,5]
- [3,1,5]
- [3,2,5]
- [3,2,1,5]
- [2,5]
- [2,1,5]

Logic
-----
Accumulate the maximum bitwise value from the array then apply the subset formula
to accumulate all subsets that have that value.

TC : o(2^n)
SC : o(1)
 */
public class CountNumberOfMaximumBitwiseORSubsets {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5};
        System.out.println(new CountNumberOfMaximumBitwiseORSubsets().countMaxOrSubsets(nums));
    }
    public int countMaxOrSubsets(int[] nums) {
        int maximumOr = 0;

        for(int num : nums){
            maximumOr |=num;
        }
        return backtrack(nums, 0,0, maximumOr);

    }

    private int backtrack(int[] nums, int start, int currentOr, int maximumOr){
        if(start==nums.length)
        {
            return currentOr == maximumOr ? 1 : 0;
        }
        return backtrack(nums, start+1, currentOr, maximumOr)
                + backtrack(nums, start+1, currentOr|nums[start], maximumOr);
    }
}
