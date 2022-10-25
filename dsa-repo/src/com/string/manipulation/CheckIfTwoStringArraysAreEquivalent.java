package com.string.manipulation;
/*
1662. Check If Two String Arrays are Equivalent

Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.

TC : o(m+n)
SC : o(1)
 */
public class CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {
        String[] word1 = new String[]{"abc", "d", "defg"}, word2 = new String[]{"abcddefg"};

        System.out.println(new CheckIfTwoStringArraysAreEquivalent().arrayStringsAreEqual(word1,word2));
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for(String s : word1){
            sb.append(s);
        }

        StringBuilder se = new StringBuilder();
        for(String s : word2){
            se.append(s);
        }

        if(sb.toString().equals(se.toString()))
            return true;

        return false;
    }
}
