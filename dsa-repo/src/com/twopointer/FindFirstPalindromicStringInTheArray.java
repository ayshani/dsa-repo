package com.twopointer;
/*
2108. Find First Palindromic String in the Array

Given an array of strings words, return the first palindromic string in the array.
If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.

Example 1:

Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.

TC : o(n*L)
SC : o(L)
 */
public class FindFirstPalindromicStringInTheArray {

    public static void main(String[] args) {
        String[] words = new String[]{"abc","car","ada","racecar","cool"};
        System.out.println(new FindFirstPalindromicStringInTheArray().firstPalindrome(words));
    }
    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPlaindrome(word))
                return word;
        }

        return "";
    }

    private boolean isPlaindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}
