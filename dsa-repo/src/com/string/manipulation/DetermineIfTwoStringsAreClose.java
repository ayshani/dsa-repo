package com.string.manipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
1657. Determine if Two Strings Are Close

Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character,
and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

TC : o(nlogn)
SC : o(n)
 */
public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        System.out.println(new DetermineIfTwoStringsAreClose().closeStrings("abc","bca"));
    }
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length(),n = word2.length();
        if(m!=n)
            return false;
        Set<Character> set1 = new HashSet<>(), set2 = new HashSet<>();

        int[] freq1 = new int[26], freq2 = new int[26];

        for(int i=0;i<m;i++){
            set1.add(word1.charAt(i));
            set2.add(word2.charAt(i));
            freq1[word1.charAt(i)-'a']++;
            freq2[word2.charAt(i)-'a']++;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);
        if(!set1.equals(set2))
            return false;
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i])
                return false;
        }
        return true;
    }
}
