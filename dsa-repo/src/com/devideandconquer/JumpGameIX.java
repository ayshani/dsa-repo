package com.devideandconquer;

import java.util.Arrays;

/*
3660. Jump Game IX

You are given an integer array nums.

From any index i, you can jump to another index j under the following rules:

Jump to index j where j > i is allowed only if nums[j] < nums[i].
Jump to index j where j < i is allowed only if nums[j] > nums[i].
For each index i, find the maximum value in nums that can be reached by following any sequence of valid jumps starting at i.

Return an array ans where ans[i] is the maximum value reachable starting from index i.



Example 1:

Input: nums = [2,1,3]

Output: [2,2,3]

Explanation:

For i = 0: No jump increases the value.
For i = 1: Jump to j = 0 as nums[j] = 2 is greater than nums[i].
For i = 2: Since nums[2] = 3 is the maximum value in nums, no jump increases the value.
Thus, ans = [2, 2, 3].

explanation : https://leetcode.com/problems/jump-game-ix/editorial/?envType=daily-question&envId=2026-05-07
TC : o(n)
SC: o(n)

 */
public class JumpGameIX {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new JumpGameIX().maxValue(new int[]{2, 1, 3})));
    }
    record Item(int value, int index) {}

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Item[] prevMax = new Item[n];

        Item prev = new Item(Integer.MIN_VALUE, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] > prev.value()) {
                prev = new Item(nums[i], i);
            }
            prevMax[i] = prev;
        }

        process(n - 1, Integer.MAX_VALUE, 0, prevMax, ans, nums);
        return ans;
    }

    private void process(
            int r,
            int rightMin,
            int rightMax,
            Item[] prevMax,
            int[] ans,
            int[] nums
    ) {
        int pMax = prevMax[r].value();
        int pivotIndex = prevMax[r].index();

        int currMax = pMax <= rightMin ? pMax : rightMax;

        int nextRightMin = Math.min(pMax, rightMin);
        for (int i = pivotIndex; i <= r; i++) {
            ans[i] = currMax;
            nextRightMin = Math.min(nextRightMin, nums[i]);
        }

        if (pivotIndex == 0) {
            return;
        }

        process(pivotIndex - 1, nextRightMin, currMax, prevMax, ans, nums);
    }
}
