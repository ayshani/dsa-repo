package com.design;
/*
1032. Stream of Characters

Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of
a given array of strings words.

For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z',
your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.

Implement the StreamChecker class:

StreamChecker(String[] words) Initializes the object with the strings array words.
boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from
the stream forms a word that is in words.


Example 1:

Input
["StreamChecker",
"query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
[[["cd", "f", "kl"]],
["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]

Output
[null, false, false, false, true, false, true, false, false, false, false, false, true]

TC : o(logn)
SC : o(n)
 */
public class StreamOfCharacters {
    public static void main(String[] args) {
        String[] words = new String[]{"cd", "f", "kl"};
        StreamChecker streamChecker = new StreamChecker(words);
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println(streamChecker.query('l'));
    }
}

class StreamChecker {

    private NodeTrie root = new NodeTrie('/');
    private StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for(String word : words){
            insertWord(word);
        }
    }

    public boolean query(char letter) {
        return searchWord(letter);
    }

    private void insertWord(String word){
        NodeTrie cur = root;
        for(int i=word.length()-1;i>=0;i--){
            int curIndex = word.charAt(i)-'a';
            if(cur.children[curIndex]==null){
                cur.children[curIndex] = new NodeTrie(word.charAt(i));
            }
            cur = cur.children[curIndex];
        }
        cur.isEnd = true;
    }

    private boolean searchWord(char letter){
        sb.append(letter);
        NodeTrie cur = this.root;
        for(int i= sb.length()-1; i>=0 && cur!=null;i--){
            int curIndex = sb.charAt(i)-'a';
            cur = cur.children[curIndex];
            if(cur!=null && cur.isEnd)
                return true;
        }
        return false;
    }
}

class NodeTrie{
    public char data;
    public boolean isEnd;
    public NodeTrie[] children;

    public NodeTrie(char data){
        this.data = data;
        isEnd = false;
        children = new NodeTrie[26];
    }
}
