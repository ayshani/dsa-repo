package com.dp;

import java.util.Arrays;

/*
3524. Find X Value of Array I

You are given an array of positive integers nums, and a positive integer k.

You are allowed to perform an operation once on nums, where in each operation you can remove any non-overlapping prefix and suffix from nums such that nums remains non-empty.

You need to find the x-value of nums, which is the number of ways to perform this operation so that the product of the remaining elements leaves a remainder of x when divided by k.

Return an array result of size k where result[x] is the x-value of nums for 0 <= x <= k - 1.

A prefix of an array is a subarray that starts from the beginning of the array and extends to any point within it.

A suffix of an array is a subarray that starts at any point within the array and extends to the end of the array.

Note that the prefix and suffix to be chosen for the operation can be empty.



Example 1:

Input: nums = [1,2,3,4,5], k = 3

Output: [9,2,4]

Explanation:

For x = 0, the possible operations include all possible ways to remove non-overlapping prefix/suffix that do not remove nums[2] == 3.
For x = 1, the possible operations are:
Remove the empty prefix and the suffix [2, 3, 4, 5]. nums becomes [1].
Remove the prefix [1, 2, 3] and the suffix [5]. nums becomes [4].
For x = 2, the possible operations are:
Remove the empty prefix and the suffix [3, 4, 5]. nums becomes [1, 2].
Remove the prefix [1] and the suffix [3, 4, 5]. nums becomes [2].
Remove the prefix [1, 2, 3] and the empty suffix. nums becomes [4, 5].
Remove the prefix [1, 2, 3, 4] and the empty suffix. nums becomes [5].

TC : o(nk)
SC: o(k)
 */
public class FindXValueOfArrayI {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindXValueOfArrayI().resultArray(new int[]{1,2,3,4,5}, 3)));
    }
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];
        long[] dp = new long[k]; // Initial state: no elements have been processed, so no non-empty subarray exists.

        for (int i = 0; i < n; i++) {
            long[] ndp = new long[k]; // Current-layer state (rolling array).
            ndp[nums[i] % k]++;
            for (int r = 0; r < k; r++) {
                ndp[(int) (((long) r * nums[i]) % k)] += dp[r];
            }
            dp = ndp; // Update the state.
            // Accumulate the answer.
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}
