package com.string.manipulation;
/*
151. Reverse Words in a String

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words.
The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
TC : o(n)
SC : o(1)
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("a good   example"));
    }
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i] +" ");
        }

        return sb.toString().trim();
    }
}
