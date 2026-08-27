package com.greedy;

import java.util.Arrays;

/*
3720. Lexicographically Smallest Permutation Greater Than Target

You are given two strings s and target, both having length n, consisting of lowercase English letters.

Return the lexicographically smallest permutation of s that is strictly greater than target. If no permutation of
s is lexicographically strictly greater than target, return an empty string.

A string a is lexicographically strictly greater than a string b (of the same length) if in the first position where
a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b.



Example 1:

Input: s = "abc", target = "bba"

Output: "bca"

Explanation:

The permutations of s (in lexicographical order) are "abc", "acb", "bac", "bca", "cab", and "cba".
The lexicographically smallest permutation that is strictly greater than target is "bca".

TC : o(n*sum)
SC: o(sum)
 */
public class LexicographicallySmallestPermutationGreaterThanTarget {

    public static void main(String[] args) {
        System.out.println(new LexicographicallySmallestPermutationGreaterThanTarget().lexGreaterPermutation(
              "abc", "bba"
        ));
    }

    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[target.charAt(i) - 'a']--;
        }

        // Try from right to left
        char[] t = target.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            int b = t[i] - 'a';
            cnt[b]++; // Reversal of consumption
            // Check if the prefix can fully match
            if (Arrays.stream(cnt).min().getAsInt() < 0) {
                continue;
            }
            // Find the smallest available character larger than b.
            for (int j = b + 1; j < 26; j++) {
                if (cnt[j] > 0) {
                    cnt[j]--;
                    t[i] = (char) ('a' + j);
                    return new String(t, 0, i + 1) + getMinString(cnt);
                }
            }
        }
        return "";
    }

    // Get the lexicographically smallest string (in ascending order)
    private String getMinString(int[] cnt) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            res.append(String.valueOf((char) ('a' + i)).repeat(cnt[i]));
        }
        return res.toString();
    }
}
