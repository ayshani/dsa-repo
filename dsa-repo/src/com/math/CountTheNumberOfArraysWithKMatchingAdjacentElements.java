package com.math;
/*
3405. Count the Number of Arrays with K Matching Adjacent Elements

You are given three integers n, m, k. A good array arr of size n is defined as follows:

Each element in arr is in the inclusive range [1, m].
Exactly k indices i (where 1 <= i < n) satisfy the condition arr[i - 1] == arr[i].
Return the number of good arrays that can be formed.

Since the answer may be very large, return it modulo 109 + 7.



Example 1:

Input: n = 3, m = 2, k = 1

Output: 4

Explanation:

There are 4 good arrays. They are [1, 1, 2], [1, 2, 2], [2, 1, 1] and [2, 2, 1].
Hence, the answer is 4.

Time complexity: O(log(n−k)).
Space complexity: O(1).
 */
public class CountTheNumberOfArraysWithKMatchingAdjacentElements {

    public static void main(String[] args) {
        System.out.println(new CountTheNumberOfArraysWithKMatchingAdjacentElements().countGoodArrays(
                3,2,1
        ));
    }
    static final int MOD = (int) 1e9 + 7;
    static final int MX = 100000;
    static long[] fact = new long[MX];
    static long[] invFact = new long[MX];

    static long qpow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }

    static {
        fact[0] = 1;
        for (int i = 1; i < MX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MX - 1] = qpow(fact[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }
    }

    long comb(int n, int m) {
        return (((fact[n] * invFact[m]) % MOD) * invFact[n - m]) % MOD;
    }

    public int countGoodArrays(int n, int m, int k) {
        return (int) ((((comb(n - 1, k) * m) % MOD) * qpow(m - 1, n - k - 1)) %
                MOD);
    }
}
