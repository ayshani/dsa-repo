package com.binarysearch;

import java.util.ArrayList;
import java.util.List;

/*
1793. Maximum Score of a Good Subarray

You are given an array of integers nums (0-indexed) and an integer k.

The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1).
A good subarray is a subarray where i <= k <= j.

Return the maximum possible score of a good subarray.



Example 1:

Input: nums = [1,4,3,7,4,5], k = 3
Output: 15
Explanation: The optimal subarray is (1, 5) with a score of min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15.

TC: o(nlogn)
SC: o(n)
 */
public class MaximumScoreOfAGoodSubarray {

    public static void main(String[] args) {
        int[] num = new int[]{1,4,3,7,4,5};
        System.out.println(new MaximumScoreOfAGoodSubarray().maximumScore(num,3));
    }
    public int maximumScore(int[] nums, int k) {
        int ans = solve(nums, k);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        return Math.max(ans, solve(nums, nums.length - k - 1));
    }

    public int solve(int[] nums, int k) {
        int n = nums.length;
        int left[] = new int[k];
        int currMin = Integer.MAX_VALUE;
        for (int i = k - 1; i >= 0; i--) {
            currMin = Math.min(currMin, nums[i]);
            left[i] = currMin;
        }

        List<Integer> right = new ArrayList();
        currMin = Integer.MAX_VALUE;
        for (int i = k; i < n; i++) {
            currMin = Math.min(currMin, nums[i]);
            right.add(currMin);
        }

        int ans = 0;
        for (int j = 0; j < right.size(); j++) {
            currMin = right.get(j);
            int i = binarySearch(left, currMin);
            int size = (k + j) - i + 1;
            ans = Math.max(ans, currMin * size);
        }

        return ans;
    }

    public int binarySearch(int[] nums, int num) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
