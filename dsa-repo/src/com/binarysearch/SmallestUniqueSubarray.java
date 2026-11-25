package com.binarysearch;

import java.util.HashMap;
import java.util.Map;

/*
3934. Smallest Unique Subarray

You are given an integer array nums.

Find the minimum length of a subarray that is not identical to any other subarray in nums.

Return an integer denoting the minimum possible length of such a subarray.

Two subarrays are considered identical if they have the same length and the same elements in corresponding positions.



Example 1:

Input: nums = [3,3,3]

Output: 3

Explanation:

Subarrays of length 1: [3] → appears 3 times
Subarrays of length 2: [3, 3] → appears 2 times
Subarrays of length 3: [3, 3, 3] → appears once
The subarray [3, 3, 3] is unique, so the smallest unique subarray length is 3.

TC : o(nlogn)
SC: o(n)
 */
public class SmallestUniqueSubarray {

    public static void main(String[] args) {
        System.out.println(new SmallestUniqueSubarray().smallestUniqueSubarray(new int[]{3,3,3}));
    }
    public int smallestUniqueSubarray(int[] nums) {
        final long MOD = 1000000007L;
        final long BASE = 911382323L;

        int n = nums.length;
        long[] h = new long[n + 1];
        long[] p = new long[n + 1];
        p[0] = 1;

        // Compute prefix hashes and powers of BASE
        for (int i = 0; i < n; ++i) {
            h[i + 1] = (h[i] * BASE + nums[i]) % MOD;
            p[i + 1] = (p[i] * BASE) % MOD;
        }

        int lo = 1,
                hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(mid, n, h, p, MOD)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean check(int len, int n, long[] h, long[] p, long MOD) {
        Map<Long, Integer> cnt = new HashMap<>();

        for (int l = 0; l + len <= n; ++l) {
            int r = l + len;
            long key = (h[r] - ((h[l] * p[len]) % MOD) + MOD) % MOD;
            cnt.merge(key, 1, Integer::sum);
        }

        for (int times : cnt.values()) {
            if (times == 1) {
                return true;
            }
        }
        return false;
    }
}
