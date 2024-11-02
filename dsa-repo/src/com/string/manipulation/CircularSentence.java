package com.string.manipulation;
/*
2490. Circular Sentence

A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.

A sentence is circular if:

The last character of a word is equal to the first character of the next word.
The last character of the last word is equal to the first character of the first word.
For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul" are all circular sentences. However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.

Given a string sentence, return true if it is circular. Otherwise, return false.



Example 1:

Input: sentence = "leetcode exercises sound delightful"
Output: true
Explanation: The words in sentence are ["leetcode", "exercises", "sound", "delightful"].
- leetcode's last character is equal to exercises's first character.
- exercises's last character is equal to sound's first character.
- sound's last character is equal to delightful's first character.
- delightful's last character is equal to leetcode's first character.
The sentence is circular.

TC : o(n)
SC : o(n)
 */
public class CircularSentence {

    public static void main(String[] args) {
        System.out.println(new CircularSentence().isCircularSentence("leetcode exercises sound delightful"));
    }
    public boolean isCircularSentence(String sentence) {
        // Use the split function to store the words in an array.
        String words[] = sentence.split(" ");
        int n = words.length;

        // Start comparing from the last character of the last word.
        char last = words[n - 1].charAt(words[n - 1].length() - 1);

        for (int i = 0; i < n; i++) {
            // If this character is not equal to the first character of current word, return
            // false.
            if (words[i].charAt(0) != last) return false;
            last = words[i].charAt(words[i].length() - 1);
        }

        return true;
    }

}
