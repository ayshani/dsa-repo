package com.string.manipulation;
/*
1347. Minimum Number of Steps to Make Two Strings Anagram

You are given two strings of the same length s and t. In one step you can choose any character of t and replace
it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.



Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

TC : o(n)
SC: o(1)
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfStepsToMakeTwoStringsAnagram().minSteps("bab","aba"));
    }
    public int minSteps(String s, String t) {
        int[] tcase = new int[26], scase = new int[26];

        for(int i=0;i<s.length();i++){
            tcase[t.charAt(i)-'a']++;
            scase[s.charAt(i)-'a']++;
        }
        //System.out.println(Arrays.toString(t));
        int count =0;
        for(int i=0;i<26;i++){
            if(scase[i]>0 && tcase[i]<scase[i]){
                count += scase[i]-tcase[i];
            }
        }
        return count;
    }
}
