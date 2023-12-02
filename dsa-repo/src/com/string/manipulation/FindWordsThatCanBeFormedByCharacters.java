package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
1160. Find Words That Can Be Formed by Characters

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.



Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

TC : o(n)
SC: o(n)
 */
public class FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
        System.out.println(new FindWordsThatCanBeFormedByCharacters().countCharacters(
                new String[]{"cat","bt","hat","tree"}, "atach"
        ));
    }
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> counts = new HashMap();
        for (Character c : chars.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        for (String word : words) {
            Map<Character, Integer> wordCount = new HashMap();
            for (Character c : word.toCharArray()) {
                wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
            }

            boolean good = true;
            for (Character c : wordCount.keySet()) {
                if (counts.getOrDefault(c, 0) < wordCount.get(c)) {
                    good = false;
                    break;
                }
            }

            if (good) {
                ans += word.length();
            }
        }

        return ans;
    }
}
