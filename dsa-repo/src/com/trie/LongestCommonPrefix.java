package com.trie;
/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

TC : o(s)
SC: o(n*s)
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] s = new String[]{"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(s));
    }
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String word : strs){
            trie.insert(word);
        }

        return trie.search(strs[0], strs.length);
    }
}

class Trie{
    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.links[c-'a']== null){
                node.links[c-'a'] = new TrieNode();
            }
            node.links[c-'a'].size++;
            node = node.links[c-'a'];
        }
        node.isEnd = true;
    }

    public String search(String word, int n){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.links[c-'a']!= null && node.links[c-'a'].size==n){
                node = node.links[c-'a'];
            } else{
                return word.substring(0,i);
            }
        }
        return word;
    }
}

class TrieNode{
    TrieNode[] links;
    boolean isEnd;
    int size;

    public TrieNode(){
        links = new TrieNode[26];
        isEnd = false;
        size =0;
    }
}
