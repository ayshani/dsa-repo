package com.dp;
/*
3699. Number of ZigZag Arrays I

You are given three integers n, l, and r.

A ZigZag array of length n is defined as follows:

Each element lies in the range [l, r].
No two adjacent elements are equal.
No three consecutive elements form a strictly increasing or strictly decreasing sequence.
Return the total number of valid ZigZag arrays.

Since the answer may be large, return it modulo 109 + 7.

A sequence is said to be strictly increasing if each element is strictly greater than its previous one (if exists).

A sequence is said to be strictly decreasing if each element is strictly smaller than its previous one (if exists).



Example 1:

Input: n = 3, l = 4, r = 5

Output: 2

Explanation:

There are only 2 valid ZigZag arrays of length n = 3 using values in the range [4, 5]:

[4, 5, 4]
[5, 4, 5]
Example 2:

Input: n = 3, l = 1, r = 3

Output: 10

Explanation:

There are 10 valid ZigZag arrays of length n = 3 using values in the range [1, 3]:

[1, 2, 1], [1, 3, 1], [1, 3, 2]
[2, 1, 2], [2, 1, 3], [2, 3, 1], [2, 3, 2]
[3, 1, 2], [3, 1, 3], [3, 2, 3]
All arrays meet the ZigZag conditions.

TC : o(mn)
SC: o(m )

 */
public class NumberOfZigZagArraysI {

    public static void main(String[] args) {
        System.out.println(new NumberOfZigZagArraysI().zigZagArrays(3,1,3));
    }
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int[] dp0 = new int[r + 1];
        int[] dp1 = new int[r + 1];
        int[] sum0 = new int[r + 2];
        int[] sum1 = new int[r + 2];

        for (int i = l; i <= r; i++) {
            dp0[i] = 1;
            dp1[i] = 1;
            sum0[i] = i - l + 1;
            sum1[i] = i - l + 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = l; j <= r; j++) {
                dp0[j] = (sum1[r] - sum1[j] + MOD) % MOD;
                dp1[j] = sum0[j - 1];
            }

            sum0[l] = dp0[l];
            sum1[l] = dp1[l];
            for (int j = l + 1; j <= r; j++) {
                sum0[j] = (sum0[j - 1] + dp0[j]) % MOD;
                sum1[j] = (sum1[j - 1] + dp1[j]) % MOD;
            }
        }

        return (sum0[r] + sum1[r]) % MOD;
    }
}
