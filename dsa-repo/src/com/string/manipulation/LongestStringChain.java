package com.string.manipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1048. Longest String Chain

You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.



Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].

TC : o(nlogn + n*m)
SC: o(n)
 */
public class LongestStringChain {

    public static void main(String[] args) {
        String[] words = new String[]{"a","b","ba","bca","bda","bdca"};
        System.out.println(new LongestStringChain().longestStrChain(words));
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length()-b.length());

        Map<String, Integer> map = new HashMap<>();
        int maxLength=0;
        for(String word : words){
            map.put(word,1);

            for(int i=0;i<word.length();i++){
                StringBuilder sb = new StringBuilder(word);
                String prev = sb.deleteCharAt(i).toString();
                if(map.containsKey(prev) && map.get(prev)+1> map.get(word)){
                    map.put(word,map.get(prev)+1);
                }
            }
            maxLength = Math.max(maxLength, map.get(word));
        }
        return maxLength;
    }
}
