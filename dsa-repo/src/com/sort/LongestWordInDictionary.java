package com.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
720. Longest Word in Dictionary

Given an array of strings words representing an English Dictionary, return the longest word in words that can be
built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being
added to the end of a previous word.

Example 1:

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Time complexity : O(∑w_i^2 ), where w_i is the length of words[i]. Checking whether all prefixes of words[i] are in the
set is O(∑w_i2).

Space complexity : O(∑w_i^2) to create the substrings.

 */
public class LongestWordInDictionary {
    public static void main(String[] args) {
        String[] words = new String[]{
                "a","banana","app","appl","ap","apply","apple"
        };

        System.out.println(new LongestWordInDictionary().longestWord(words));
    }
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) ->
                a.length()==b.length() ? a.compareTo(b) : b.length()-a.length()
        );

        Set<String> set = new HashSet<>();
        for(String word : words)
            set.add(word);

        for(String word: words){
            boolean isGood = true;
            for(int i=1;i<word.length();i++){
                if(!set.contains(word.substring(0,i)))
                {
                    isGood = false;
                    break;
                }
            }
            if(isGood)
                return word;
        }

        return "";

    }

}
