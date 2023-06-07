package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

TC: o(n)
SC: o(n)
 */
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab","eidbaooo"));
    }
    public boolean checkInclusion(String s1, String s2) {
        int start =0, end = 0;
        if(s2.length()<s1.length() || s2.length()==0)
            return false;
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        while(end<s2.length()){
            char cur = s2.charAt(end);

            if(map.containsKey(cur)){
                map.put(cur, map.getOrDefault(cur,0)-1);
                if(map.get(cur)==0){
                    count--;
                }
            }

            end++;

            while(count==0){
                if(end-start== s1.length()){
                    return true;
                }
                char startC = s2.charAt(start);
                if(map.containsKey(startC)){
                    int charCount = map.get(startC);
                    charCount++;
                    map.put(startC, charCount);
                    if(map.get(startC)==1){
                        count++;
                    }
                }
                start++;
            }
        }
        return false;
    }
}
