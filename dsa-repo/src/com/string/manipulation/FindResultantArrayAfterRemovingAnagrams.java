package com.string.manipulation;

import java.util.ArrayList;
import java.util.List;

/*
2273. Find Resultant Array After Removing Anagrams

You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.

In one operation, select any index i such that 0 < i < words.length and words[i - 1] and words[i] are anagrams,
and delete words[i] from words. Keep performing this operation as long as you can select an index that satisfies
the conditions.

Return words after performing all operations. It can be shown that selecting the indices for each operation in
any arbitrary order will lead to the same result.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all
the original letters exactly once. For example, "dacb" is an anagram of "abdc".



Example 1:

Input: words = ["abba","baba","bbaa","cd","cd"]
Output: ["abba","cd"]
Explanation:
One of the ways we can obtain the resultant array is by using the following operations:
- Since words[2] = "bbaa" and words[1] = "baba" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","baba","cd","cd"].
- Since words[1] = "baba" and words[0] = "abba" are anagrams, we choose index 1 and delete words[1].
  Now words = ["abba","cd","cd"].
- Since words[2] = "cd" and words[1] = "cd" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","cd"].
We can no longer perform any operations, so ["abba","cd"] is the final answer.

Logic
---------------
have one prev String = ""
loop over words[]
    check isAnagram(prev,current)
        if not anagram,
            add current to list
            assign prev to current

TC : O(n^2)
SC : O(1)
 */
public class FindResultantArrayAfterRemovingAnagrams {

    public static void main(String[] args) {
        String[] words = new String[]{"abba","baba","bbaa","cd","cd"};

        System.out.println(new FindResultantArrayAfterRemovingAnagrams().removeAnagrams(words));
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";
        for(int i=0;i<words.length;i++){
            String current = words[i];
            if(!isAnagram(prev,current)){
                result.add(current);
                prev = current;
            }
        }
        return result;

    }

    public boolean isAnagram(String s, String t) {
        if(t.length()!=s.length())
            return false;
        int[] aux = new int[26];
        for(int i=0;i<s.length();i++){
            aux[s.charAt(i)-'a']++;
            aux[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(aux[i]!=0)
                return false;
        }

        return true;
    }
}
