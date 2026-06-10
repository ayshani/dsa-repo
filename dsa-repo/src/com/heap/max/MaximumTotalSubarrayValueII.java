package com.heap.max;

import java.util.PriorityQueue;

/*
3691. Maximum Total Subarray Value II

You are given an integer array nums of length n and an integer k.

You must select exactly k distinct non-empty subarrays nums[l..r] of nums. Subarrays may overlap, but the exact
same subarray (same l and r) cannot be chosen more than once.

The value of a subarray nums[l..r] is defined as: max(nums[l..r]) - min(nums[l..r]).

The total value is the sum of the values of all chosen subarrays.

Return the maximum possible total value you can achieve.



Example 1:

Input: nums = [1,3,2], k = 2

Output: 4

Explanation:

One optimal approach is:

Choose nums[0..1] = [1, 3]. The maximum is 3 and the minimum is 1, giving a value of 3 - 1 = 2.
Choose nums[0..2] = [1, 3, 2]. The maximum is still 3 and the minimum is still 1, so the value is also 3 - 1 = 2.
Adding these gives 2 + 2 = 4.

TC : o(nlogn + klogn)
SC: o(nlogn)
 */
public class MaximumTotalSubarrayValueII {

    public static void main(String[] args) {
        System.out.println(new MaximumTotalSubarrayValueII().maxTotalValue(new int[]{1,3,2}, 2));
    }
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int logn = 32 - Integer.numberOfLeadingZeros(n);
        int[][] stMax = new int[n][logn];
        int[][] stMin = new int[n][logn];
        for (int i = 0; i < n; i++) {
            stMax[i][0] = stMin[i][0] = nums[i];
        }

        for (int j = 1; j < logn; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(
                        stMax[i][j - 1],
                        stMax[i + (1 << (j - 1))][j - 1]
                );
                stMin[i][j] = Math.min(
                        stMin[i][j - 1],
                        stMin[i + (1 << (j - 1))][j - 1]
                );
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int l = 0; l < n; l++) {
            int j = 31 - Integer.numberOfLeadingZeros(n - 1 - l + 1);
            int mx = Math.max(stMax[l][j], stMax[n - 1 - (1 << j) + 1][j]);
            int mn = Math.min(stMin[l][j], stMin[n - 1 - (1 << j) + 1][j]);
            pq.offer(new int[] { mx - mn, l, n - 1 });
        }

        long ans = 0;
        while (k-- > 0) {
            int[] top = pq.poll();
            ans += top[0];
            int l = top[1];
            int r = top[2];
            if (r > l) {
                int j = 31 - Integer.numberOfLeadingZeros(r - 1 - l + 1);
                int mx = Math.max(stMax[l][j], stMax[r - 1 - (1 << j) + 1][j]);
                int mn = Math.min(stMin[l][j], stMin[r - 1 - (1 << j) + 1][j]);
                pq.offer(new int[] { mx - mn, l, r - 1 });
            }
        }
        return ans;
    }
}
