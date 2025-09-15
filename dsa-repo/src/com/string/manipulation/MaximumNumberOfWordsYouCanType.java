package com.string.manipulation;

import java.util.HashSet;
import java.util.Set;

/*
1935. Maximum Number of Words You Can Type

There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.



Example 1:

Input: text = "hello world", brokenLetters = "ad"
Output: 1
Explanation: We cannot type "world" because the 'd' key is broken.

TC : o(n*m)
SC: o(len(brokenLetters))
 */
public class MaximumNumberOfWordsYouCanType {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfWordsYouCanType().canBeTypedWords("hello world", "ad"));
    }
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for(char c : brokenLetters.toCharArray()){
            set.add(c);
        }
        int count =0;
        String[] words = text.split(" ");
        for(String word : words){
            boolean flag = false;
            for(char c : word.toCharArray()){
                if(set.contains(c)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                count++;
            }
        }
        return count;
    }
}
