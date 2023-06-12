package com.twopointer;
/*
395. Longest Substring with At Least K Repeating Characters

Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each
character in this substring is greater than or equal to k.



Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

TC : o(n^2)
SC: o(1)
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("ababbc",2));
    }
    public int longestSubstring(String s, int k) {
        if(s== null || s.length()==0 || s.length()<k)
            return 0;

        int[] count = new int[26];
        // record the frequency of each character
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        boolean flag = true;
        for(int i=0;i<26;i++){
            if(count[i] < k && count[i]>0)
                flag = false;
        }
        // return the length of string if this string is a valid string
        if(flag == true)
            return s.length();

        int longestLength=0;
        int start =0, end =0;
        // otherwise we use all the infrequent elements as splits
        while(end<s.length()){
            if(count[s.charAt(end)-'a']<k){
                longestLength = Math.max(longestLength, longestSubstring(s.substring(start, end),k));
                start = end+1;
            }
            end++;
        }
        longestLength = Math.max(longestLength, longestSubstring(s.substring(start),k));
        return longestLength;
    }
}
