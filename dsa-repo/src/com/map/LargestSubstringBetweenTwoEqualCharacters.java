package com.map;

import java.util.HashMap;
import java.util.Map;

/*
1624. Largest Substring Between Two Equal Characters

Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.

TC : o(n)
SC: o(n)
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    public static void main(String[] args) {
        System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters(
                "aa"
        ));
    }
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> firstIndex = new HashMap();
        int ans = -1;

        for (int i = 0; i < s.length(); i++) {
            if (firstIndex.containsKey(s.charAt(i))) {
                ans = Math.max(ans, i - firstIndex.get(s.charAt(i)) - 1);
            } else {
                firstIndex.put(s.charAt(i), i);
            }
        }

        return ans;
    }
}
