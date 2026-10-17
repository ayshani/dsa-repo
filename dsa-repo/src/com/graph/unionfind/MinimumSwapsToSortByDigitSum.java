package com.graph.unionfind;

import java.util.Arrays;

/*
3551. Minimum Swaps to Sort by Digit Sum

You are given an array nums of distinct positive integers. You need to sort the array in increasing order based on the sum of the digits of each number. If two numbers have the same digit sum, the smaller number appears first in the sorted order.

Return the minimum number of swaps required to rearrange nums into this sorted order.

A swap is defined as exchanging the values at two distinct positions in the array.



Example 1:

Input: nums = [37,100]

Output: 1

Explanation:

Compute the digit sum for each integer: [3 + 7 = 10, 1 + 0 + 0 = 1] → [10, 1]
Sort the integers based on digit sum: [100, 37]. Swap 37 with 100 to obtain the sorted order.
Thus, the minimum number of swaps required to rearrange nums is 1.

TC : O(nlogn+nlogM).
SC: o(n)
 */
public class MinimumSwapsToSortByDigitSum {

    public static void main(String[] args) {
        System.out.println(new MinimumSwapsToSortByDigitSum().minSwaps(new int[]{37,100}));
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] digitSum = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i],
                    sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            digitSum[i] = sum;
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> {
            if (digitSum[a] != digitSum[b]) {
                return Integer.compare(digitSum[a], digitSum[b]);
            }
            return Integer.compare(nums[a], nums[b]);
        });

        int[] targetPos = new int[n];
        for (int pos = 0; pos < n; pos++) {
            targetPos[indices[pos]] = pos;
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int components = n;

        for (int i = 0; i < n; i++) {
            int ri = find(parent, i);
            int rj = find(parent, targetPos[i]);
            if (ri != rj) {
                parent[ri] = rj;
                components--;
            }
        }

        return n - components;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
