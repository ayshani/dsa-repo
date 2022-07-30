package com.string.manipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
890. Find and Replace Pattern

Given a list of strings words and a string pattern, return a list of words[i] that match pattern.
You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing
every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter
maps to another letter, and no two letters map to the same letter.



Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.

Logic
----------
have If say, the first letter of the pattern is "a", and the first letter of the word is "x",
then in the permutation, "a" must map to "x".

We can write this bijection using two maps: a forward map m1 and a backwards map m2.

m1:"a"→"x" m2:"x"→"a"

Then, if there is a contradiction later, we can catch it via one of the two maps.
For example, if the (word, pattern) is ("aa", "xy"), we will catch the mistake in m1
(namely, m1("a")="x"="y").
Similarly, with (word, pattern) = ("ab", "xx"), we will catch the mistake in }m2.

TC : o(nk)
SC : o(nk)
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";

        System.out.println(new FindAndReplacePattern().findAndReplacePattern(words,pattern));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for(String word : words){
            if(match(word,pattern))
                result.add(word);
        }

        return result;
    }

    private boolean match(String word, String pattern){
        Map<Character,Character> pMap = new HashMap<>();
        Map<Character,Character> wMap = new HashMap<>();

        for(int i=0;i<word.length();i++){
            char p = pattern.charAt(i);
            char w = word.charAt(i);
            if(!pMap.containsKey(p))
                pMap.put(p,w);
            if(!wMap.containsKey(w))
                wMap.put(w,p);
            if(pMap.get(p)!=w || wMap.get(w)!=p)
                return false;
        }

        return true;
    }
}
