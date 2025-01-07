package com.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1408. String Matching in an Array

Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

A substring is a contiguous sequence of characters within a string



Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

TC : o(m^2 * n)
SC: o(m^2 * n)
 */
public class StringMatchingInAnArray {

    public static void main(String[] args) {
        System.out.println(new StringMatchingInAnArray().stringMatching(new String[]{"mass","as","hero","superhero"}));
    }
    public List<String> stringMatching(String[] words) {
        SubTrie trie = new SubTrie();
        List<String> matchingWords = new ArrayList<>();
        for (String word : words) {
            for (int startIndex = 0; startIndex < word.length(); startIndex++) {
                // Insert each suffix starting from index startIndex.
                trie.insert(word.substring(startIndex));
            }
        }
        // Check each word to see if it exists as a substring in the Trie.
        for (String word : words) {
            if (trie.isSubstring(word)) {
                matchingWords.add(word);
            }
        }

        return matchingWords;
    }
}

class SubTrieNode {
    int freq;
    Map<Character, SubTrieNode> child;

    public SubTrieNode(){
        freq =0;
        child = new HashMap<>();
    }
}

class SubTrie {
    SubTrieNode root;

    public SubTrie(){
        root = new SubTrieNode();
    }

    public void insert(String word){
        SubTrieNode cur = root;
        for(char c : word.toCharArray()){
            cur.child.putIfAbsent(c, new SubTrieNode());
            cur = cur.child.get(c);
            cur.freq++;
        }
    }

    public boolean isSubstring(String word){
        SubTrieNode cur = root;
        for(char c : word.toCharArray()){
            cur = cur.child.get(c);
        }
        return cur.freq >1;
    }
}
