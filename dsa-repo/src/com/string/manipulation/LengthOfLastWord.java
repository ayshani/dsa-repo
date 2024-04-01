package com.string.manipulation;
/*
58. Length of Last Word

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
 consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

TC : o(n)
SC: o(1)
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  "));
    }
    public int lengthOfLastWord(String s) {
        int i =0;
        s = s.trim();
        for(i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' ')
                break;
        }
        i++;
        return s.length()-i;

    }
}
