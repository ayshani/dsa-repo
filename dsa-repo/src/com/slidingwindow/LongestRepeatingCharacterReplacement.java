package com.slidingwindow;
/*
424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it
to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing
the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

TC: o(n)
SC: o(1)
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABCC";
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s,2));
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n<k){
            return n;
        }

        int[] count = new int[26];
        int maxFrequency =0, maxLength=0;

        for(int right =0, left =0; right<n;right++){
            char cur = s.charAt(right);
            // count the frequency
            count[cur-'A']++;
            maxFrequency = Math.max(maxFrequency, count[cur-'A']);

            //We will need to know how many letters in our substring that we need to replace.
            int lettersToReplace = (right-left+1) - maxFrequency;
            // if number of letters to be replaced is greater than k,
            // that means we need to decrease our window size
            if(lettersToReplace>k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, (right-left+1));
        }
        return maxLength;
    }
}
