package com.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1674. Minimum Moves to Make Array Complementary

You are given an integer array nums of even length n and an integer limit. In one move, you can replace any integer from nums with another integer between 1 and limit, inclusive.

The array nums is complementary if for all indices i (0-indexed), nums[i] + nums[n - 1 - i] equals the same number. For example, the array [1,2,3,4] is complementary because for all indices i, nums[i] + nums[n - 1 - i] = 5.

Return the minimum number of moves required to make nums complementary.



Example 1:

Input: nums = [1,2,4,3], limit = 4
Output: 1
Explanation: In 1 move, you can change nums to [1,2,2,3] (underlined elements are changed).
nums[0] + nums[3] = 1 + 3 = 4.
nums[1] + nums[2] = 2 + 2 = 4.
nums[2] + nums[1] = 2 + 2 = 4.
nums[3] + nums[0] = 3 + 1 = 4.
Therefore, nums[i] + nums[n-1-i] = 4 for every i, so nums is complementary.

TC : OO(nlogn+Llogn)
SC: O(N)
 */
public class MinimumMovesToMakeArrayComplementary {

    public static void main(String[] args) {
        System.out.println(new MinimumMovesToMakeArrayComplementary().minMoves(
                new int[]{1,2,3,4}, 4
        ));
    }
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        Map<Integer, Integer> sumCount = new HashMap<>();
        int[] minArr = new int[n / 2];
        int[] maxArr = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            sumCount.merge(a + b, 1, Integer::sum);
            minArr[i] = a;
            maxArr[i] = b;
        }

        Arrays.sort(minArr);
        Arrays.sort(maxArr);

        int minOps = n;

        for (int c = 2; c <= 2 * limit; c++) {
            int addLeft = n / 2 - lowerBound(minArr, c);
            int addRight = lowerBound(maxArr, c - limit);

            int currentOps =
                    n / 2 + addLeft + addRight - sumCount.getOrDefault(c, 0);
            minOps = Math.min(minOps, currentOps);
        }

        return minOps;
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
