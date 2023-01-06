package com.string.manipulation;

import java.util.*;

/*
819. Most Common Word

Given a string paragraph and a string array of the banned words banned,
return the most frequent word that is not banned.
It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.



Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.

TC : o(n)
SC : o(n)
 */
public class MostCommonWord {

    public static void main(String[] args) {
        String[] banned = new String[]{"hit"};
        System.out.println(new MostCommonWord().
                mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",banned));
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-z0-9]"," ").toLowerCase();

        String[] words = paragraph.split("\\s+");

        Set<String> bannedWords = new HashSet<>();
        for(String w : banned){
            bannedWords.add(w);
        }
        Map<String,Integer> map = new HashMap<>();

        for(String w : words){
            if(!bannedWords.contains(w)){
                map.put(w, map.getOrDefault(w,0)+1);
            }
        }

        return Collections.max(map.entrySet(),Map.Entry.comparingByValue()).getKey();
    }

}
