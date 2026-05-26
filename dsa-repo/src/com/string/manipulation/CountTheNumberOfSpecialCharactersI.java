package com.string.manipulation;
/*
3120. Count the Number of Special Characters I

You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.



Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters in word are 'a', 'b', and 'c'.


 */
public class CountTheNumberOfSpecialCharactersI {

    public static void main(String[] args) {
        System.out.println(new CountTheNumberOfSpecialCharactersI().numberOfSpecialChars("aaAbcBC"));
    }
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] small = new int[26], upper = new int[26];

        int count =0;
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                small[ch-'a'] =1;
            } else{
                upper[ch-'A'] =1;
            }
        }
        for(int i=0;i<26;i++){
            if(small[i] == 1 && upper[i] == 1)
                count++;
        }
        return count;
    }
}
