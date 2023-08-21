package com.string.manipulation;
/*
459. Repeated Substring Pattern

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies
of the substring together.



Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

TC : o(n)
SC: o(1)
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
    }
    public boolean repeatedSubstringPattern(String s) {
        // this will cover all its rotation as string s
        String t = s+s;
        // once we get s+s as t, we can take the substring as 1-(end-1), so that
        // we can check if s is there in t.
        // the reason behind this is :
        // s = aba , t = abaaba , substring(t) : baab ,  here,we can see that
        // we cant get aba hence it is not true.
        // for e.g. s = abab , t = abababab , substring(t) : bababa , here, we cn see
        // that abab is present in substring as the frequency is more than 1. hence it returns true.
        if(t.substring(1,t.length()-1).contains(s))
            return true;
        return false;
    }
}
