package com.string.manipulation;
/*
383. Ransom Note

Given two strings ransomNote and magazine,
return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

TC : o(m+n)
SC : o(26) = o(1)
 */
public class RansomNote {

    public static void main(String[] args) {
        String magazine = "aab", ransomNote = "aa";
        System.out.println(new RansomNote().canConstruct(ransomNote,magazine));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for(int i=0;i<magazine.length();i++){
            arr[magazine.charAt(i)-'a']++;
        }

        for(int i=0;i<ransomNote.length();i++){
            if(--arr[ransomNote.charAt(i)-'a'] <0)
                return false;
        }

        return true;
    }
}
