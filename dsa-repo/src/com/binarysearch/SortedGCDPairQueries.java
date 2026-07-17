package com.binarysearch;

import java.util.Arrays;

/*
3312. Sorted GCD Pair Queries

You are given an integer array nums of length n and an integer array queries.

Let gcdPairs denote an array obtained by calculating the GCD of all possible pairs (nums[i], nums[j]),
where 0 <= i < j < n, and then sorting these values in ascending order.

For each query queries[i], you need to find the element at index queries[i] in gcdPairs.

Return an integer array answer, where answer[i] is the value at gcdPairs[queries[i]] for each query.

The term gcd(a, b) denotes the greatest common divisor of a and b.



Example 1:

Input: nums = [2,3,4], queries = [0,2,2]

Output: [1,2,2]

Explanation:

gcdPairs = [gcd(nums[0], nums[1]), gcd(nums[0], nums[2]), gcd(nums[1], nums[2])] = [1, 2, 1].

After sorting in ascending order, gcdPairs = [1, 1, 2].

So, the answer is [gcdPairs[queries[0]], gcdPairs[queries[1]], gcdPairs[queries[2]]] = [1, 2, 2].

TC : O(mlogm+qlogm)
SC: O(m)
 */
public class SortedGCDPairQueries {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortedGCDPairQueries().gcdValues(
                new int[]{2,3,4}, new long[]{0,2,2}
        )));
    }
    public int[] gcdValues(int[] nums, long[] queries) {
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        long[] cnt = new long[m + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = i * 2; j <= m; j += i) {
                cnt[i] += cnt[j];
            }
        }
        for (int i = 1; i <= m; i++) {
            cnt[i] = (cnt[i] * (cnt[i] - 1)) / 2;
        }
        for (int i = m; i >= 1; i--) {
            for (int j = i * 2; j <= m; j += i) {
                cnt[i] -= cnt[j];
            }
        }
        for (int i = 1; i <= m; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            long q = queries[k] + 1;
            int left = 1,
                    right = m;
            while (left < right) {
                int mid = (left + right) / 2;
                if (cnt[mid] >= q) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[k] = left;
        }
        return ans;
    }
}
