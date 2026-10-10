package com.greedy;

import java.util.Arrays;

/*
2333. Minimum Sum of Squared Difference

You are given two positive 0-indexed integer arrays nums1 and nums2, both of length n.

The sum of squared difference of arrays nums1 and nums2 is defined as the sum of (nums1[i] - nums2[i])2 for each 0 <= i < n.

You are also given two positive integers k1 and k2. You can modify any of the elements of nums1 by +1 or -1 at most k1 times. Similarly, you can modify any of the elements of nums2 by +1 or -1 at most k2 times.

Return the minimum sum of squared difference after modifying array nums1 at most k1 times and modifying array nums2 at most k2 times.

Note: You are allowed to modify the array elements to become negative integers.



Example 1:

Input: nums1 = [1,2,3,4], nums2 = [2,10,20,19], k1 = 0, k2 = 0
Output: 579
Explanation: The elements in nums1 and nums2 cannot be modified because k1 = 0 and k2 = 0.
The sum of square difference will be: (1 - 2)2 + (2 - 10)2 + (3 - 20)2 + (4 - 19)2 = 579.


TC : o(nlogn)
SC : o(n)
 */
public class MinimumSumOfSquaredDifference {

    public static void main(String[] args) {
        System.out.println(new MinimumSumOfSquaredDifference().minSumSquareDiff(
                new int[]{1,2,3,4}, new int[]{2,10,20,19}, 0,0
        ));
    }
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums1[i] = Math.abs(nums1[i] - nums2[i]);
            sum += nums1[i];
        }
        if (sum <= k) {
            return 0;
        }

        Arrays.sort(nums1);
        int[] d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            d[i] = nums1[n - 1 - i];
        }

        for (int i = 1; i <= n; i++) {
            long cost = (long) (d[i - 1] - d[i]) * i;
            if (cost > k) {
                long q = k / i,
                        r = k % i,
                        hi = d[i - 1] - q;
                long ans = hi * hi * (i - r) + (hi - 1) * (hi - 1) * r;
                for (int j = i; j < n; j++) {
                    ans += (long) d[j] * d[j];
                }
                return ans;
            }
            k -= cost;
        }
        return 0;
    }

}
