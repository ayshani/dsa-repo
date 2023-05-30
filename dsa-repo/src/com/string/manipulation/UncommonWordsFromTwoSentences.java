package com.string.manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
884. Uncommon Words from Two Sentences

A sentence is a string of single-space separated words where each word consists only of lowercase letters.
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]

TC : o(nUmber of total words)
SC: o(nUmber of total words)
 */
public class UncommonWordsFromTwoSentences {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new UncommonWordsFromTwoSentences().uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> map = new HashMap<>();

        for(String word : (A+ " "+ B).split(" ")){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        ArrayList<String> list = new ArrayList<>();
        for(String s: map.keySet()){
            if(map.get(s)==1){
                list.add(s);
            }
        }

        return list.toArray(new String[0]);

    }
}
