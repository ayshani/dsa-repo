package com.prefixsum;

import java.util.Arrays;

/*
3756. Concatenate Non-Zero Digits and Multiply by Sum II

You are given a string s of length m consisting of digits. You are also given a 2D integer array queries, where queries[i] = [li, ri].

For each queries[i], extract the substring s[li..ri]. Then, perform the following:

Form a new integer x by concatenating all the non-zero digits from the substring in their original order. If there are no non-zero digits, x = 0.
Let sum be the sum of digits in x. The answer is x * sum.
Return an array of integers answer where answer[i] is the answer to the ith query.

Since the answers may be very large, return them modulo 109 + 7.



Example 1:

Input: s = "10203004", queries = [[0,7],[1,3],[4,6]]

Output: [12340, 4, 9]

Explanation:

s[0..7] = "10203004"
x = 1234
sum = 1 + 2 + 3 + 4 = 10
Therefore, answer is 1234 * 10 = 12340.
s[1..3] = "020"
x = 2
sum = 2
Therefore, the answer is 2 * 2 = 4.
s[4..6] = "300"
x = 3
sum = 3
Therefore, the answer is 3 * 3 = 9.

TC : o(n)
SC: o(n)

 */
public class ConcatenateNonZeroDigitsAndMultiplyBySumII {

    private static final int MOD = 1000000007;
    private static final int MAX_N = 100001;
    private static final long[] pow10 = new long[MAX_N];

    static {
        pow10[0] = 1;
        for (int i = 1; i < MAX_N; ++i) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConcatenateNonZeroDigitsAndMultiplyBySumII().sumAndMultiply(
                "10203004", new int[][]{{0,7},{1,3},{4,6}}
        )));
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n + 1];
        long[] x = new long[n + 1];
        int[] cnt = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            int d = s.charAt(i) - '0';
            sum[i + 1] = sum[i] + d;
            x[i + 1] = d > 0 ? (x[i] * 10 + d) % MOD : x[i];
            cnt[i + 1] = cnt[i] + (d > 0 ? 1 : 0);
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            int length = cnt[r] - cnt[l];
            long val_x = (x[r] - ((x[l] * pow10[length]) % MOD) + MOD) % MOD;
            long val_sum = sum[r] - sum[l];
            res[i] = (int) ((val_x * val_sum) % MOD);
        }
        return res;
    }
}
