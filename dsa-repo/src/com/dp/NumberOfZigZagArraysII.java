package com.dp;
/*
3700. Number of ZigZag Arrays II

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

TC : o(m^3 * logn)
SC: o(m^3)
 */
public class NumberOfZigZagArraysII {


    public static void main(String[] args) {
        System.out.println(new NumberOfZigZagArraysII().zigZagArrays(3,4,5));
    }
    private static final long MOD = 1_000_000_007L;

    static class Matrix {

        int n, m;
        long[] data;

        Matrix(int n, int m) {
            this.n = n;
            this.m = m;
            this.data = new long[n * m];
        }

        long get(int i, int j) {
            return data[i * m + j];
        }

        void set(int i, int j, long val) {
            data[i * m + j] = val;
        }

        Matrix mul(Matrix b) {
            Matrix res = new Matrix(n, b.m);
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    long r = this.get(i, k);
                    if (r == 0) {
                        continue;
                    }

                    for (int j = 0; j < b.m; j++) {
                        res.set(i, j, (res.get(i, j) + r * b.get(k, j)) % MOD);
                    }
                }
            }
            return res;
        }

        Matrix pow(long exp, Matrix res) {
            Matrix base = new Matrix(n, m);
            System.arraycopy(this.data, 0, base.data, 0, this.data.length);

            while (exp > 0) {
                if ((exp & 1L) == 1L) {
                    res = res.mul(base);
                }
                base = base.mul(base);
                exp >>= 1L;
            }
            return res;
        }
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if (n == 1) {
            return m;
        }

        Matrix u = new Matrix(2 * m, 2 * m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                u.set(i, j + m, 1L);
            }
            for (int j = i + 1; j < m; j++) {
                u.set(i + m, j, 1L);
            }
        }

        Matrix dp = new Matrix(1, 2 * m);
        for (int i = 0; i < 2 * m; i++) {
            dp.set(0, i, 1L);
        }

        dp = u.pow(n - 1, dp);

        long ans = 0;
        for (int i = 0; i < 2 * m; i++) {
            ans = (ans + dp.get(0, i)) % MOD;
        }

        return (int) ans;
    }
}
