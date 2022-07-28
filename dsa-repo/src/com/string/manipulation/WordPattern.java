package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
290. Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Logic
------
split String s in array of Strings
have one map of(char,String) which map pattern to words
check if pattern is present or not
    - Yes : check if it's value is same word
            No : return false
    - No :  Check if the word exists in map
            Yes : Return false
If none of the above cases fall, then ti is true

TC : O(n)
SC : o(n)
 */
public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(new WordPattern().wordPattern(pattern,s));
    }

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if(pattern.length() != words.length)
            return false;
        Map<Character,String> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            char c = pattern.charAt(i);

            if(map.containsKey(c)){
                if(!map.get(c).equals(words[i])){
                    return false;
                }
            }else{
                if(map.containsValue(words[i])){
                    return false;
                }
                map.put(c,words[i]);
            }
        }

        return true;
    }
}
