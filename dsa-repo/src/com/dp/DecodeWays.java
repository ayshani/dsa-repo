package com.dp;
/*
91. Decode Ways

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of
the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

TC : o(n)
SC: o(n)
 */
public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));
    }
    public int numDecodingsV1(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2;i<=n;i++){
            if(s.charAt(i-1)!='0'){
                dp[i] = dp[i-1];
            }
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            if(twoDigit>=10 && twoDigit <=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--)
            if(s.charAt(i)!='0') {
                dp[i]=dp[i+1];
                if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
                    dp[i]+=dp[i+2];
            }
        return dp[0];
    }
}
