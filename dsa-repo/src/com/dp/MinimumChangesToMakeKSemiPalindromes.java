package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2911. Minimum Changes to Make K Semi-palindromes

Given a string s and an integer k, partition s into k substrings such that the letter changes needed to make each
substring a semi-palindrome are minimized.

Return the minimum number of letter changes required.

A semi-palindrome is a special type of string that can be divided into palindromes based on a repeating pattern.
To check if a string is a semi-palindrome:​

Choose a positive divisor d of the string's length. d can range from 1 up to, but not including, the string's length.
For a string of length 1, it does not have a valid divisor as per this definition, since the only divisor is its
length, which is not allowed.
For a given divisor d, divide the string into groups where each group contains characters from the string that follow
a repeating pattern of length d. Specifically, the first group consists of characters at positions 1, 1 + d, 1 + 2d,
and so on; the second group includes characters at positions 2, 2 + d, 2 + 2d, etc.
The string is considered a semi-palindrome if each of these groups forms a palindrome.
Consider the string "abcabc":

The length of "abcabc" is 6. Valid divisors are 1, 2, and 3.
For d = 1: The entire string "abcabc" forms one group. Not a palindrome.
For d = 2:
Group 1 (positions 1, 3, 5): "acb"
Group 2 (positions 2, 4, 6): "bac"
Neither group forms a palindrome.
For d = 3:
Group 1 (positions 1, 4): "aa"
Group 2 (positions 2, 5): "bb"
Group 3 (positions 3, 6): "cc"
All groups form palindromes. Therefore, "abcabc" is a semi-palindrome.


Example 1:

Input: s = "abcac", k = 2

Output: 1

Explanation: Divide s into "ab" and "cac". "cac" is already semi-palindrome. Change "ab" to "aa", it becomes
semi-palindrome with d = 1.

TC : o(n^3 * logn)
SC: : o(n^2)

 */
public class MinimumChangesToMakeKSemiPalindromes {

    public static void main(String[] args) {
        System.out.println(new MinimumChangesToMakeKSemiPalindromes().minimumChanges("abcac", 2));
    }
    private int segmentCost(char[] s, int l, int m, List<Integer>[] factors) {
        int best = m;
        for (int d : factors[m]) {
            int groups = m / d; // Each group contains groups characters
            int changes = 0;
            for (int offset = 0; offset < d; offset++) {
                for (int t = 0; t < groups / 2; t++) {
                    // Pair characters from opposite ends of the group
                    if (
                            s[l + offset + t * d] !=
                                    s[l + offset + (groups - 1 - t) * d]
                    ) {
                        changes++;
                    }
                }
            }
            best = Math.min(best, changes);
        }
        return best;
    }

    private int solve(int seg, int start, int n, int[][] cost, int[][] memo) {
        if (seg == 1) {
            // Only one segment remains
            return cost[start][n - 1];
        }
        if (memo[seg][start] != -1) {
            // Already computed
            return memo[seg][start];
        }
        int best = n;
        int limit = n - 1 - 2 * (seg - 1); // Leave room for seg-1 segments after the first segment
        for (int e = start + 1; e <= limit; e++) {
            best = Math.min(
                    best,
                    cost[start][e] + solve(seg - 1, e + 1, n, cost, memo)
            );
        }
        memo[seg][start] = best;
        return best;
    }

    public int minimumChanges(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        List<Integer>[] factors = new ArrayList[n + 1];
        Arrays.setAll(factors, x -> new ArrayList<>());
        // Precompute the proper divisors of each number
        for (int d = 1; d <= n / 2; d++) {
            for (int m = d * 2; m <= n; m += d) {
                factors[m].add(d);
            }
        }
        int[][] cost = new int[n][n];
        for (int l = 0; l + 1 < n; l++) {
            for (int r = l + 1; r < n; r++) {
                // Each substring must have length at least 2
                cost[l][r] = segmentCost(ch, l, r - l + 1, factors);
            }
        }
        int[][] memo = new int[k + 1][n];
        for (int seg = 0; seg <= k; seg++) {
            Arrays.fill(memo[seg], -1);
        }
        return solve(k, 0, n, cost, memo);
    }
}
