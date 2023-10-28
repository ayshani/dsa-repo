package com.dp;
/*
1220. Count Vowels Permutation

Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

Example 2:

Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".

Logic
-------
https://leetcode.com/problems/count-vowels-permutation/discuss/398222/Detailed-Explanation-using-Graphs-With-Pictures-O(n)

create a graph of in-out degrees as descrbed in problem statement.
consider the indegrees only i.e which can be followed by .

a -> e i u
e -> a i
i -> e o
o -> i
u -> i o

Now have one dp and calculate previous row's values.

TC : o(n)
SC : o(n*5)
 */
public class CountVowelsPermutation {

    public static void main(String[] args) {
        System.out.println(new CountVowelsPermutation().countVowelPermutation(144));
    }

    public int countVowelPermutation(int n) {
        int MOD = 1000000007;

        long[][] dp = new long[n+1][5];

        for(int i=0;i<5;i++){
            dp[1][i]=1;
        }
        for(int i=1;i<n;i++){
            dp[i+1][0] = (dp[i][1] + dp[i][2] + dp[i][4])%MOD;
            dp[i+1][1] = (dp[i][0]+dp[i][2])%MOD;
            dp[i+1][2] = (dp[i][1] + dp[i][3]) % MOD;
            dp[i+1][3] = (dp[i][2])% MOD;
            dp[i+1][4] = (dp[i][2] + dp[i][3]) % MOD;
        }
        long sum =0;

        for(int i=0;i<5;i++){
            sum = (sum+ dp[n][i]) % MOD;
        }

        return (int)sum;
    }
}
