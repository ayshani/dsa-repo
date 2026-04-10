package com.array;
/*
3740. Minimum Distance Between Three Equal Elements I

You are given an integer array nums.

A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].

The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.

Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.



Example 1:

Input: nums = [1,2,1,1,3]

Output: 6

Explanation:

The minimum distance is achieved by the good tuple (0, 2, 3).

(0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1. Its distance is
abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.

TC  o(n^3)
SC: o(1)
 */
public class MinimumDistanceBetweenThreeEqualElementsI {

    public static void main(String[] args) {
        System.out.println(new MinimumDistanceBetweenThreeEqualElementsI().minimumDistance(new int[]{1,2,1,1,3}));
    }
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = n + 1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] != nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] == nums[k]) {
                        ans = Math.min(ans, k - i);
                        break;
                    }
                }
            }
        }

        return ans == n + 1 ? -1 : ans * 2;
    }
}
