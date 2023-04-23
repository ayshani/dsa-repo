package com.dp;
/*
1416. Restore The Array


A program was supposed to print an array of integers. The program forgot to print whitespaces and the array is
printed as a string of digits s and all we know is that all integers in the array were in the range [1, k] and
there are no leading zeros in the array.

Given the string s and the integer k, return the number of the possible arrays that can be printed as s using the
mentioned program. Since the answer may be very large, return it modulo 109 + 7.

Example 1:

Input: s = "1000", k = 10000
Output: 1
Explanation: The only possible array is [1000]

TC: o(n^2)
SC: o(n)
 */
public class RestoreTheArray {

    public static void main(String[] args) {
        System.out.println(new RestoreTheArray().numberOfArrays("10000",10000));
    }
    public int numberOfArrays(String s, int k) {
        // dp[i] is number of ways to print valid arrays from string s start at i
        Integer[] dp = new Integer[s.length()];
        return recur(dp,k,0,s);
    }

    private int recur(Integer[] dp, int k, int i, String s){
        // base case -> Found a valid way
        if(i==s.length())
            return 1;
        // all numbers are in range [1, k] and there are no leading zeros
        // -> So numbers starting with 0 mean invalid!
        if(s.charAt(i)=='0')
            return 0;
        if(dp[i]!=null)
            return dp[i];
        int ans =0;
        long num =0;
        for(int j=i;j<s.length();j++){
            // num is the value of the substring s[i..j]
            num = num*10 + s.charAt(j)-'0';
            // num must be in range [1, k]
            if(num>k)
                break;
            ans += recur(dp,k,j+1,s);
            ans %=1000000007;
        }
        return dp[i] =ans;
    }
}
