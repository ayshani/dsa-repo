package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
76. Minimum Window Substring

Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every character in t (including duplicates) is
included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

TC : o(n)
SC : o(t)
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC" , t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s,t));
    }
    public String minWindow(String s, String t) {
        if(s.length()==0 || s.length()<t.length())
            return "";
        String ans ="";
        Map<Character,Integer> countMap = new HashMap<>();
        for(char c : t.toCharArray()){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        int start =0, end =0, lengthOfWord = Integer.MAX_VALUE, counter = countMap.size();

        while(end<s.length()){

            char endCharacter = s.charAt(end);
            if(countMap.containsKey(endCharacter)){
                countMap.put(endCharacter, countMap.getOrDefault(endCharacter,0)-1);
                if(countMap.get(endCharacter) == 0)
                    counter--;
            }
            end++;

            while(counter == 0){
                if(end-start < lengthOfWord){
                    lengthOfWord = end -start;
                    ans = s.substring(start,end);
                }

                char startCharacter = s.charAt(start);

                if(countMap.containsKey(startCharacter)){
                    countMap.put(startCharacter, countMap.getOrDefault(startCharacter,0)+1);
                    if(countMap.get(startCharacter)==1)
                        counter++;

                }
                start++;
            }
        }


        return ans;
    }
}
