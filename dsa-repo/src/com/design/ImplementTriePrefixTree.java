package com.design;
/*
208. Implement Trie (Prefix Tree)

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store
and retrieve keys in a dataset of strings. There are various applications of this data structure,
such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has
the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

https://leetcode.com/problems/implement-trie-prefix-tree/

TC :
 */
public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "apple";
        obj.insert(word);
        System.out.println(obj.search(word));
        System.out.println(obj.startsWith("app"));
    }
}

class Trie {

    private TrieNode root;
    public Trie() {
        root = new TrieNode();;
    }

    //Time complexity : O(m), where m is the key length.
    //Space complexity : O(m).
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char currentCharacter = word.charAt(i);
            if(!node.containsKey(currentCharacter)){
                node.put(currentCharacter, new TrieNode());
            }
            node = node.get(currentCharacter);
        }
        node.setEnd();
    }

    /*
    Time complexity : O(m) In each step of the algorithm we search for the next key character.
    In the worst case the algorithm performs mm operations.
    Space complexity : O(1)
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }

    /*
    Time complexity : O(m)
    Space complexity : O(1)
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char currentCharacter = word.charAt(i);
            if(node.containsKey(currentCharacter)){
                node = node.get(currentCharacter);
            } else
                return null;
        }

        return node;
    }
}

class TrieNode{
    private TrieNode[] links;
    private boolean isEnd;
    public TrieNode(){
        links = new TrieNode[26];
    }

    public boolean  containsKey(char ch){
        return links[ch - 'a']!=null;
    }

    public TrieNode get(char c){
        return links[c-'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }

    public void setEnd()
    {
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
