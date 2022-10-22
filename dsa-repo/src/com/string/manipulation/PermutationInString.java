package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Algorithm
------------
one string will be a permutation of another string only if both of them contain the same characters with
the same frequency. We can consider every possible substring in the long string s2s2 of the same length as
that of s1s1 and check the frequency of occurence of the characters appearing in the two. If the frequencies
of every letter match exactly, then only s1s1's permutation can be a substring of s2s2.

In order to implement this approach, instead of sorting and then comparing the elements for equality,
we make use of a hashmap s1maps1map which stores the frequency of occurence of all the characters in
the short string s1s1. We consider every possible substring of s2s2 of the same length as that of s1s1,
find its corresponding hashmap as well, namely s2maps2map. Thus, the substrings considered can be viewed
as a window of length as that of s1s1 iterating over s2s2. If the two hashmaps obtained are identical for
any such window, we can conclude that s1s1's permutation is a substring of s2s2, otherwise not.

Complexity Analysis

Let l_1 be the length of string s_1 and l_2 be the length of string s_2.

Time complexity: O(l_1+26l_1(l_2-l_1)). The hashmap contains atmost 26 keys.

Space complexity: O(1). Hashmap contains at most 26 key-value pairs.
 */
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab","eidboaoo"));
    }
    public boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length(), s2len = s2.length();
        if(s1len > s2len)
            return false;

        Map<Character,Integer> s1map = new HashMap<>();

        for(int i=0;i<s1len;i++){
            char c = s1.charAt(i);
            s1map.put(c, s1map.getOrDefault(c,0)+1);
        }

        for(int i=0; i<= s2len - s1len;i++){
            Map<Character,Integer> s2map = new HashMap<>();

            for(int j=0;j<s1len;j++){
                char c = s2.charAt(i+j);
                s2map.put(c, s2map.getOrDefault(c,0)+1);
            }

            if(matches(s1map,s2map))
                return true;
        }

        return false;
    }

    private boolean matches(Map<Character,Integer> s1map, Map<Character,Integer> s2map){

        for(char c : s1map.keySet()){
            if(s1map.get(c) - s2map.getOrDefault(c,-1) !=0)
                return false;
        }

        return true;
    }
}
