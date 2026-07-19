package com.greedy;
/*
081. Smallest Subsequence of Distinct Characters

Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters
of s exactly once.



Example 1:

Input: s = "bcabc"
Output: "abc"

TC : o(n)
SC: o(sum)
 */
public class SmallestSubsequenceOfDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(new SmallestSubsequenceOfDistinctCharacters().smallestSubsequence("bcabc"));
    }
    public String smallestSubsequence(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
