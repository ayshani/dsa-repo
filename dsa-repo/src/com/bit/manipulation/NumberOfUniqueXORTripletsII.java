package com.bit.manipulation;
/*
3514. Number of Unique XOR Triplets II

You are given an integer array nums.

A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.

Return the number of unique XOR triplet values from all possible triplets (i, j, k).



Example 1:

Input: nums = [1,3]

Output: 2

Explanation:

The possible XOR triplet values are:

(0, 0, 0) → 1 XOR 1 XOR 1 = 1
(0, 0, 1) → 1 XOR 1 XOR 3 = 3
(0, 1, 1) → 1 XOR 3 XOR 3 = 1
(1, 1, 1) → 3 XOR 3 XOR 3 = 3
The unique XOR values are {1, 3}. Thus, the output is 2.


TC : o(mn)
SC: o(n)

 */
public class NumberOfUniqueXORTripletsII {

    public static void main(String[] args) {
        System.out.println(new NumberOfUniqueXORTripletsII().uniqueXorTriplets(new int[]{1,3}));
    }
    public int uniqueXorTriplets(int[] nums) {
        int m = 0;
        for (int v : nums) {
            m = Math.max(m, v);
        }
        int u = 1;
        while (u <= m) {
            u <<= 1;
        }
        boolean[] one = new boolean[u];
        boolean[] two = new boolean[u];
        boolean[] three = new boolean[u];
        for (int v : nums) {
            one[v] = true;
            for (int x = 0; x < u; x++) {
                if (one[x]) {
                    two[x ^ v] = true;
                }
            }
        }
        for (int v : nums) {
            for (int x = 0; x < u; x++) {
                if (two[x]) {
                    three[x ^ v] = true;
                }
            }
        }
        int ans = 0;
        for (boolean b : three) {
            if (b) {
                ans++;
            }
        }
        return ans;
    }
}
