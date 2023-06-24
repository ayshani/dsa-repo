package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

TC : o(n)
SC: o(n)
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        int n = s.length();
        if(n<=1)
            return n;
        int left =0, right =0;
        Map<Character,Integer> map = new HashMap<>();
        while(right<n){
            char cur = s.charAt(right);
            if(map.containsKey(cur)){
                left = Math.max(left, map.get(cur)+1);
            }
            map.put(cur, right);
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
}
