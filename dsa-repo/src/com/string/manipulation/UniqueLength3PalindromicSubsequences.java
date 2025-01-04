package com.string.manipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
1930. Unique Length-3 Palindromic Subsequences

Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none)
deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".


Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")

TC : o(n)
SC : o(1)
 */
public class UniqueLength3PalindromicSubsequences {

    public static void main(String[] args) {
        System.out.println(new UniqueLength3PalindromicSubsequences().countPalindromicSubsequence("aabca"));
    }
    public int countPalindromicSubsequence(String s) {
        // add first and last index of a character
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        int n = s.length();
        for(int i=0;i<n;i++){
            int index = s.charAt(i)-'a';
            if(first[index]==-1){
                first[index] = i;
            }
            last[index] = i;
        }
        int ans =0;
        for(int i=0;i<26;i++){
            if(first[i]==-1 )
                continue;

            Set<Character> between = new HashSet();
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }
            ans += between.size();
        }

        return ans;
    }
}
