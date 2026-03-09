package com.dp;
/*
3129. Find All Possible Stable Binary Arrays I

You are given 3 positive integers zero, one, and limit.

A binary array arr is called stable if:

The number of occurrences of 0 in arr is exactly zero.
The number of occurrences of 1 in arr is exactly one.
Each subarray of arr with a size greater than limit must contain both 0 and 1.
Return the total number of stable binary arrays.

Since the answer may be very large, return it modulo 109 + 7.



Example 1:

Input: zero = 1, one = 1, limit = 2

Output: 2

Explanation:

The two possible stable binary arrays are [1,0] and [0,1], as both arrays have a single 0 and a single 1, and no
subarray has a length greater than 2.

TC : o(zero*one)
SC: o(zero*one)
Explanation : https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/editorial/?envType=daily-question&envId=2026-03-09
 */
public class FindAllPossibleStableBinaryArraysI {

    public static void main(String[] args) {
        System.out.println(new FindAllPossibleStableBinaryArraysI().numberOfStableArrays(3,3,2));
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        final long MOD = 1000000007;
        long[][][] dp = new long[zero+1][one+1][2];
        for(int i=0;i<=Math.min(zero, limit); i++){
            dp[i][0][0] = 1;
        }
        for(int j=0;j<= Math.min(one, limit); j++){
            dp[0][j][1] = 1;
        }

        for(int i=1;i<= zero;i++){
            for(int j=1;j<= one; j++){
                if (i > limit) {
                    dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1] - dp[i-limit-1][j][1];
                } else{
                    dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1];
                }

                dp[i][j][0] = ((dp[i][j][0] % MOD) + MOD) %MOD;

                if (j > limit) {
                    dp[i][j][1] =
                            dp[i][j - 1][1] +
                                    dp[i][j - 1][0] -
                                    dp[i][j - limit - 1][0];
                } else {
                    dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0];
                }
                dp[i][j][1] = ((dp[i][j][1] % MOD) + MOD) % MOD;
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
