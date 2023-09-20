package com.slidingwindow;
/*
1658. Minimum Operations to Reduce X to Zero

You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or
the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for
future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

TC : o(n)
SC: o(1)
 */
public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,4,2,3};
        System.out.println(new MinimumOperationsToReduceXToZero().minOperations(nums,5));
    }
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int n : nums) total += n;
        // result is the maximum number of contiguous elements that can be removed to make the ends sum to x
        int i = 0, j = 0, currSum = 0, target = total - x, result = -1;
        if (target < 0) return -1;
        if (target == 0) return nums.length;
        while (j < nums.length) {
            currSum += nums[j];
            while (currSum >= target) {
                if (currSum == target) result = Math.max(result, j - i + 1);
                currSum -= nums[i];
                i++;
            }
            j++;
        }
        return result > 0 ? nums.length - result : -1;
    }
}
