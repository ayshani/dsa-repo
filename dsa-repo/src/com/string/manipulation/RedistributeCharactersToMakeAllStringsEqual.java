package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
1897. Redistribute Characters to Make All Strings Equal

You are given an array of strings words (0-indexed).

In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character
from words[i] to any position in words[j].

Return true if you can make every string in words equal using any number of operations, and false otherwise.



Example 1:

Input: words = ["abc","aabc","bc"]
Output: true
Explanation: Move the first 'a' in words[1] to the front of words[2],
to make words[1] = "abc" and words[2] = "abc".
All the strings are now equal to "abc", so return true.


TC : o(n)
SC: o(1)
 */
public class RedistributeCharactersToMakeAllStringsEqual {

    public static void main(String[] args) {
        System.out.println(new RedistributeCharactersToMakeAllStringsEqual().makeEqual(
                new String[]{"abc","aabc","bc"}
        ));
    }
    public boolean makeEqual(String[] words) {
        int n = words.length;
        Map<Character, Integer> map = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                map.put(c, map.getOrDefault(c,0)+1);
            }
        }

        for(char c : map.keySet()){
            if((map.get(c) %n) !=0)
                return false;
        }

        return true;
    }
}
