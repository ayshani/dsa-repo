package com.greedy;

import java.util.Arrays;

/*
1647. Minimum Deletions to Make Character Frequencies Unique

A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example,
in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.



Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.

TC : o(n)
SC: o(26)
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
        System.out.println(new MinimumDeletionsToMakeCharacterFrequenciesUnique().minDeletions("aaabbbcc"));
    }
    public int minDeletions(String s) {
        int[] frequency = new int[26];
        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i)-'a']++;
        }

        Arrays.sort(frequency);

        int count =0, maxFrequency = s.length();

        for(int i=25; i>=0 && frequency[i]>0;i--){
            if(frequency[i]>maxFrequency){
                count += frequency[i] - maxFrequency;
                frequency[i]  = maxFrequency;
            }
            maxFrequency = Math.max(0,frequency[i]-1 );
        }
        return count;
    }
}
