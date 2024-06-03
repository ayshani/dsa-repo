package com.string.manipulation;
/*
2486. Append Characters to String to Make Subsequence

You are given two strings s and t consisting of only lowercase English letters.

Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence
of s.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing
the order of the remaining characters.



Example 1:

Input: s = "coaching", t = "coding"
Output: 4
Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
Now, t is a subsequence of s ("coachingding").
It can be shown that appending any 3 characters to the end of s will never make t a subsequence.

TC : o(n)
SC: o(1)
 */
public class AppendCharactersToStringToMakeSubsequence {

    public static void main(String[] args) {
        System.out.println(new AppendCharactersToStringToMakeSubsequence()
                .appendCharacters("coaching", "coding"));
    }
    public int appendCharacters(String s, String t) {
        int first =0, longestPrefix =0;
        while(first < s.length() && longestPrefix< t.length()){
            if(s.charAt(first)  == t.charAt(longestPrefix)){
                longestPrefix++;
            }
            first++;
        }
        return t.length() - longestPrefix;
    }
}
