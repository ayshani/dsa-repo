package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]


TC : o(n*w)
SC : o(n)
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] s = new String[]{"eat","tea","tan","ate","nat","bat"};

        System.out.println(new GroupAnagrams().groupAnagrams(s));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long,List<String>> hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            long h = hash(strs[i]);
            hm.computeIfAbsent(h, value -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList(hm.values());

    }

    long hash(String s){

        long h =0L;
        for(char c : s.toCharArray()){
            h+= c*c*c*c;
        }

        return h;
    }
}
