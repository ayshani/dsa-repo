package com.trie;

import java.util.Arrays;
import java.util.List;

/*
648. Replace Words

In English, we have a concept called root, which can be followed by some other word to form another longer word -
let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a
derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all
the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root,
replace it with the root that has the shortest length.

Return the sentence after the replacement.



Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"


 */
public class ReplaceWords {

    public static void main(String[] args) {
        System.out.println(new ReplaceWords().
                replaceWords(List.of("cat","bat","rat"), "the cattle was rattled by the battery"));
    }
    // C : o(d*w + s*w)
    public String replaceWords(List<String> dictionary, String sentence) {
        // create Trie
        TrieReplaceWord trie = new TrieReplaceWord();
        for(String s: dictionary){
            trie.insert(s);
        }

        // get the shortest word from Trie
        String[] splitStr = sentence.split(" ");
        for(int word =0; word<splitStr.length; word++){
            splitStr[word] = trie.getShortestRoot(splitStr[word]);
        }
        return String.join(" ", splitStr);

    }

    // tie Limit Exceeded for Long sentences
    public String replaceWordsV2(List<String> dictionary, String sentence) {
        StringBuilder res = new StringBuilder();
        String[] splitStr = sentence.split(" ");
        for(String s : splitStr){
            boolean flag = false;
            for(int i=1;i<s.length()+1;i++){
                String subStr = s.substring(0,i);
                if(dictionary.contains(subStr)){
                    res.append(subStr +" ");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                res.append(s +" ");
            }
        }
        return String.valueOf(res).trim();
    }
}

class TrieNodeReplaceWord{
    boolean isEnd;
    TrieNodeReplaceWord[] next;

    public TrieNodeReplaceWord(){
        next = new TrieNodeReplaceWord[26];
        isEnd  = false;
    }
}

class TrieReplaceWord{
    private TrieNodeReplaceWord root;
    public TrieReplaceWord(){
        root = new TrieNodeReplaceWord();
    }

    public void insert(String word){
        TrieNodeReplaceWord cur = root;
        for(char c: word.toCharArray()){
            if(cur.next[c-'a']== null){
                cur.next[c-'a'] = new TrieNodeReplaceWord();
            }
            cur = cur.next[c-'a'];
        }
        cur.isEnd = true;
    }

    public String getShortestRoot(String word){
        TrieNodeReplaceWord cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next[c-'a']== null){
                return word;
            }
            cur = cur.next[c-'a'];
            if(cur.isEnd){
                return word.substring(0,i+1);
            }
        }
        return word;
    }
}
