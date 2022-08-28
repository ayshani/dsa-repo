package com.string.manipulation;
/*
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

TC : o(n)
SC : o(1)

 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
    public boolean isPalindrome(String s) {
        if(s==null)
            return true;

        s=s.replaceAll("[^A-Za-z0-9]","");
        if(s.length()==0)
            return true;

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        //System.out.println(s +" ------ "+sb);
        if(s.equalsIgnoreCase(sb.toString()))
            return true;

        return false;
    }
}
