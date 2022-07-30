package com.string.manipulation;

import java.util.ArrayList;
import java.util.List;

/*
916. Word Subsets

You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.



Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]

Logic
-------
Merge the words2 string into one count array bmax[].
    If in a string there are multiple occurrence of same character, consider the occurrence
        e.g. : words = {wrr,wa,or}
            merged one will be wrrao
            rr is counted twice cause it is the maximum occurrence in among all strings
            w is counted once for the same reason.
Iterate over strings in words1
    count the occurrence of string and check if any character count is less than that charcater
    count in bmax.
        If not, add in result
        else ignore

TC : o(words1+words2)
SC : o(26)
 */
public class WordSubsets {
    public static void main(String[] args) {

    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bmax = count("");

        for(String b : words2){
            int[] bCount = count(b);
            for(int i=0;i<26;i++){
                bmax[i] =  Math.max(bmax[i],bCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for(String s : words1){
            int[] aCount = count(s);
            int i=0;
            for(i=0;i<26;i++){
                if(aCount[i]<bmax[i])
                    break;
            }

            if(i==26)
                result.add(s);
        }

        return result;

    }

    private int[] count(String s){
        int[] cn = new int[26];
        for(char c: s.toCharArray()){
            cn[c-'a']++;
        }
        return cn;
    }
}
