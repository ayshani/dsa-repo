package com.string.manipulation;
/*
409. Longest Palindrome

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
Intuition

A palindrome consists of letters with equal partners, plus possibly a unique center (without a partner).
The letter i from the left has its partner i from the right. For example in 'abcba', 'aa' and 'bb' are partners,
and 'c' is a unique center.

Imagine we built our palindrome. It consists of as many partnered letters as possible, plus a unique center if possible.
This motivates a greedy approach.

Algorithm

For each letter, say it occurs v times. We know we have v // 2 * 2 letters that can be partnered for sure. For example,
if we have 'aaaaa', then we could have 'aaaa' partnered, which is 5 // 2 * 2 = 4 letters partnered.

At the end, if there was any v % 2 == 1, then that letter could have been a unique center. Otherwise, every letter
was partnered. To perform this check, we will check for v % 2 == 1 and ans % 2 == 0, the latter meaning we haven't
yet added a unique center to the answer.

Complexity Analysis

Time Complexity: O(N), where N is the length of s. We need to count each letter.

Space Complexity: O(1), the space for our count, as the alphabet size of s is fixed. We should also consider
that in a bit complexity model, technically we need O(logN) bits to store the count values.

 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for(char c: s.toCharArray()){
            count[c]++;
        }
        int ans =0;
        for(int v : count){
            ans+=v/2*2;
            if(ans%2==0 && v%2==1)
                ans++;
        }
        return ans;
    }

}
