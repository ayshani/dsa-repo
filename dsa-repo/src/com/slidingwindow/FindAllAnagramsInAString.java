package com.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
438. Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

TC : o(n)
SC: o(n)
 */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString().findAnagrams("cbaebabacd","abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0)+1);
        }

        int start =0, end = 0, count =map.size();
        if(s.length()<p.length() || s.length()==0)
            return result;
        while(end<s.length()){
            char cur = s.charAt(end);
            if(map.containsKey(cur)){
                map.put(cur,map.getOrDefault(cur,0)-1);
                if(map.get(cur)==0)
                    count--;
            }

            end++;
            while(count==0){
                if(end-start == p.length()){
                    result.add(start);
                }
                char startC = s.charAt(start);

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
        return result;
    }
}
