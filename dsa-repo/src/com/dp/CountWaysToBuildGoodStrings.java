package com.dp;
/*
2466. Count Ways To Build Good Strings

Given the integers zero, one, low, and high, we can construct a string by starting with an empty string,
and then at each step perform either of the following:

Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.

A good string is a string constructed by the above process having a length between low and high (inclusive).

Return the number of different good strings that can be constructed satisfying these properties. Since the
answer can be large, return it modulo 109 + 7.



Example 1:

Input: low = 3, high = 3, zero = 1, one = 1
Output: 8
Explanation:
One possible valid good string is "011".
It can be constructed as follows: "" -> "0" -> "01" -> "011".
All binary strings from "000" to "111" are good strings in this example.

TC : o(n)
SC: o(n)
 */
public class CountWaysToBuildGoodStrings {

    public static void main(String[] args) {
        System.out.println(new CountWaysToBuildGoodStrings().countGoodStrings(2,3,1,2));
    }
    int mod = (int)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        Integer[] dp = new Integer[high+1];
        return util(0, low, high, zero, one, dp);
    }

    private int util(int length, int low, int high, int one, int zero, Integer[] dp){
        if(length>high)
            return 0;
        if(null!= dp[length])
            return dp[length];
        int count =0;
        if(length>=low && length<=high)
            count++;

        count+= util(length+zero, low, high, zero, one, dp)%mod;
        count+= util(length+one, low, high, zero, one, dp)%mod;

        return dp[length]= count%mod;
    }
}
