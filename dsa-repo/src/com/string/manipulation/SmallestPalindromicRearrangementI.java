package com.string.manipulation;
/*
3517. Smallest Palindromic Rearrangement I

You are given a palindromic string s.

Return the lexicographically smallest palindromic permutation of s.



Example 1:

Input: s = "z"

Output: "z"

Explanation:

A string of only one character is already the lexicographically smallest palindrome.

Example 2:

Input: s = "babab"

Output: "abbba"

Explanation:

Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.

TC : o(n)
SC: o(1)
 */
public class SmallestPalindromicRearrangementI {

    public static void main(String[] args) {
        System.out.println(new SmallestPalindromicRearrangementI().smallestPalindrome("babab"));
    }
    public String smallestPalindrome(String s) {
        int partition = s.length() / 2;
        int[] bucket = new int[26];

        for (int i = 0; i < partition; i++) {
            bucket[s.charAt(i) - 'a'] += 1;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (bucket[i] > 0) {
                left.append(String.valueOf((char) (i + 'a')).repeat(bucket[i]));
            }
        }
        System.out.println(left);
        String mid =
                s.length() % 2 != 0 ? String.valueOf(s.charAt(partition)) : "";
        System.out.println(mid);
        String right = new StringBuilder(left).reverse().toString();
        System.out.println(right);
        return left.toString() + mid + right;
    }
}
