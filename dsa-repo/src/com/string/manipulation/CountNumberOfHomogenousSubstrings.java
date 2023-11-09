package com.string.manipulation;
/*
1759. Count Number of Homogenous Substrings

Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.

A string is homogenous if all the characters of the string are the same.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: s = "abbcccaa"
Output: 13
Explanation: The homogenous substrings are listed as below:
"a"   appears 3 times.
"aa"  appears 1 time.
"b"   appears 2 times.
"bb"  appears 1 time.
"c"   appears 3 times.
"cc"  appears 2 times.
"ccc" appears 1 time.
3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.

TC : o(n)
SC: o(1)
 */
public class CountNumberOfHomogenousSubstrings {

    public static void main(String[] args) {
        System.out.println(new CountNumberOfHomogenousSubstrings().countHomogenous("abbcccaa"));
    }
    public int countHomogenous(String s) {

        int mod = (int)1e9 + 7;
        int sum =0, curStreak =0;
        for(int i=0;i<s.length();i++){
            if(i==0 || s.charAt(i)== s.charAt(i-1)){
                curStreak++;
            } else{
                curStreak =1;
            }
            sum = (sum+ curStreak)%mod;
        }
        return sum;
    }
}
