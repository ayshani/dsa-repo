package com.string.manipulation;
/*
1736. Latest Time by Replacing Hidden Digits

You are given a string time in the form of hh:mm, where some of the digits in the string are hidden (represented by ?).
The valid times are those inclusively between 00:00 and 23:59.
Return the latest valid time you can get from time by replacing the hidden digits.

Example 1:

Input: time = "2?:?0"
Output: "23:50"
Explanation: The latest hour beginning with the digit '2' is 23 and the latest minute ending with the digit '0' is 50.
Example 2:

Input: time = "0?:3?"
Output: "09:39"
Example 3:

Input: time = "1?:22"
Output: "19:22"

TC : o(1)
SC : o(n)
 */
public class LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        System.out.println(new LatestTimeByReplacingHiddenDigits().maximumTime("1?:22"));
    }
    public String maximumTime(String time) {
        char[] st = time.toCharArray();
        if(st[0]=='?'){
            st[0] = st[1]<='3' || st[1] == '?' ? '2' : '1';
        }

        if(st[1]=='?'){
            st[1] = st[0] =='2'? '3' : '9';
        }

        if(st[3]=='?'){
            st[3]='5';
        }

        if(st[4]=='?'){
            st[4]='9';
        }

        return new String(st);
    }
}
