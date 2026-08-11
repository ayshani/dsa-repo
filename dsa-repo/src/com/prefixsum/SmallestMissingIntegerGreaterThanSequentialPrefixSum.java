package com.prefixsum;

import java.util.HashSet;
import java.util.Set;

/*
2996. Smallest Missing Integer Greater Than Sequential Prefix Sum

You are given a 0-indexed array of integers nums.

A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular, the
prefix consisting only of nums[0] is sequential.

Return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest
sequential prefix.



Example 1:

Input: nums = [1,2,3,2,5]
Output: 6
Explanation: The longest sequential prefix of nums is [1,2,3] with a sum of 6. 6 is not in the array, therefore 6
is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.

TC : o(n)
SC: o(n)
 */
public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {

    public static void main(String[] args) {
        System.out.println(new SmallestMissingIntegerGreaterThanSequentialPrefixSum()
                .missingInteger(new int[]{1,2,3,2,5}));
    }
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> numSet = new HashSet<>(n);
        for (int num : nums) {
            numSet.add(num);
        }
        int total = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                total += nums[i];
            } else {
                break;
            }
        }

        while (numSet.contains(total)) {
            total += 1;
        }

        return total;

    }
}
