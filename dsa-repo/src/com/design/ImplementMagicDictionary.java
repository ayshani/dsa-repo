package com.design;
/*
676. Implement Magic Dictionary

Design a data structure that is initialized with a list of different words. Provided a string,
you should determine if you can change exactly one character in this string to
match any word in the data structure.

Implement the MagicDictionary class:

MagicDictionary() Initializes the object.
void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
bool search(String searchWord) Returns true if you can change exactly one character in searchWord to
match any string in the data structure, otherwise returns false.


Example 1:

Input
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
Output
[null, null, false, true, false, false]

Explanation
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // return False
magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
magicDictionary.search("hell"); // return False
magicDictionary.search("leetcoded"); // return False

Logic
-----
First build a trie tree, and in search(String word) function,
we just edit every character from 'a' to 'z' and search the new string.
(This process is like "word ladder")
 */
public class ImplementMagicDictionary {

    public static void main(String[] args) {
        MagicDictionary obj = new MagicDictionary();
        String[] dict = new String[]{"hello", "leetcode"};
        obj.buildDict(dict);
        System.out.println(obj.search("hello"));
        System.out.println(obj.search("hhllo"));
        System.out.println(obj.search("hell"));
        System.out.println(obj.search("leetcoded"));
    }
}

class MagicDictionary {

    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {

        for(String word : dictionary){
            TrieNode node = root;
            for(int i=0;i<word.length();i++){
                if(!node.containsKey(word.charAt(i))){
                    node.put(word.charAt(i), new TrieNode());
                }
                node = node.get(word.charAt(i));
            }
            node.setEnd();
        }
    }
    /*
    TC : o(n*26*n)
    SC : o(n)
     */
    public boolean search(String searchWord) {
        char[] searchWordArray = searchWord.toCharArray();

        for(int i=0;i<searchWordArray.length;i++){
            for(char c ='a';c<='z';c++){
                if(c==searchWordArray[i])
                    continue;

                char originalCurrentChar  = searchWordArray[i];
                searchWordArray[i] = c;
                if(searchPrefix(searchWordArray,root))
                    return true;
                searchWordArray[i] = originalCurrentChar;
            }
        }

        return false;
    }

    private boolean searchPrefix(char[] searchWordArray, TrieNode root){
        TrieNode node = root;
        for(int i=0;i<searchWordArray.length;i++){
            if(node.containsKey(searchWordArray[i]))
                node = node.get(searchWordArray[i]);
            else
                return false;
        }

        return node.isEnd();
    }
}
