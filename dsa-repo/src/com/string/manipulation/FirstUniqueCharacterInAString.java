package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
387. First Unique Character in a String

Given a string s, find the first non-repeating character in it and return its index.
If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1

TC : o(n)
SC : o(n)
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar(s));
    }
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=s.length()-1;i>=0;i--){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }

        return -1;
    }
}
