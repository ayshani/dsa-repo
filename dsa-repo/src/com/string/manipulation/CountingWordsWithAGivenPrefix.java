package com.string.manipulation;
/*
2185. Counting Words With a Given Prefix

You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.



Example 1:

Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".

TC : o(m*n)
SC : o(1)
 */
public class CountingWordsWithAGivenPrefix {

    public static void main(String[] args) {
        System.out.println(new CountingWordsWithAGivenPrefix().prefixCount(
                new String[]{"pay","attention","practice","attend"}, "at"
        ));
    }
    public int prefixCount(String[] words, String pref) {
        int count =0;
        for(int i=0;i<words.length;i++){
            count += words[i].startsWith(pref) ? 1 : 0;
        }
        return count;
    }
}
