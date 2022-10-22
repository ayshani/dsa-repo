package com.string.manipulation;
/*
1816. Truncate Sentence

A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
Each of the words consists of only uppercase and lowercase English letters (no punctuation).

For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
You are given a sentence s and an integer k. You want to truncate s such that
it contains only the first k words. Return s after truncating it.

Example 1:

Input: s = "Hello how are you Contestant", k = 4
Output: "Hello how are you"
Explanation:
The words in s are ["Hello", "how" "are", "you", "Contestant"].
The first 4 words are ["Hello", "how", "are", "you"].
Hence, you should return "Hello how are you".
 */
public class TruncateSentence {

    public static void main(String[] args) {
        System.out.println(new TruncateSentence().truncateSentence("What is the solution to this problem",4));
    }
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        if(s==null)
            return "";
        String[] words = s.split(" ");
        if(words.length< k)
            return s;
        for(int i=0;i<k;i++){
            sb.append(words[i] );
            sb.append(" ");
        }

        return sb.toString().trim();
    }

}
