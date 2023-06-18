package com.string.manipulation;
/*
1768. Merge Strings Alternately

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

TC : o(n)
SC: o(1)
 */
public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(new MergeStringsAlternately().mergeAlternately("abc","pqr"));
    }
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;
        while(i<word1.length() && j<word2.length()){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        if(i<word1.length()){
            sb.append(word1.substring(i));
        }

        if(j<word2.length()){
            sb.append(word2.substring(j));
        }

        return sb.toString();
    }
}
