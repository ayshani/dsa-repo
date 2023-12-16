package com.string.manipulation;
/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

Logic
------------
taking int array of 26 letters.
for each char in S, add the occurence in array and
for every char in T decrease the occurence

if both are anagram, then resultant in the array will be  0

TC : o(n)
SC : o(26)
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s= "anagram", t="nagaram";
        ValidAnagram obj = new ValidAnagram();
        System.out.println(obj.isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        if(t.length()!=s.length())
            return false;
        int[] aux = new int[26];
        for(int i=0;i<s.length();i++){
            aux[s.charAt(i)-'a']++;
            aux[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(aux[i]!=0)
                return false;
        }

        return true;
    }
}
