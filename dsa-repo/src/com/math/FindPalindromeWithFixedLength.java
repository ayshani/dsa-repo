package com.math;

import java.util.Arrays;

/*
2217. Find Palindrome With Fixed Length

Given an integer array queries and a positive integer intLength,
return an array answer where answer[i] is either the queries[i]th smallest positive palindrome of length
intLength or -1 if no such palindrome exists.

A palindrome is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.

Example 1:

Input: queries = [1,2,3,4,5,90], intLength = 3
Output: [101,111,121,131,141,999]
Explanation:
The first few palindromes of length 3 are:
101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...
The 90th palindrome of length 3 is 999.

Logic
-------
First Palindrome of length 4 = "10"+"01"
First Palindrome of length 3 = "10"+"_1" (without first character 0)
First half can range from 10 (which is 10^1) to 99 (which is 10^2-1)

So idea is to have first half then reverse it and append both to get the quer[i] th palindrome number
of fixed length.

TC : o(n)
SC : o(n)
 */
public class FindPalindromeWithFixedLength {

    public static void main(String[] args) {
        int[] queries = new int[]{1,2,3,4,5,90};
        int len = 3;
        long[] res = new FindPalindromeWithFixedLength().kthPalindrome(queries,len);
        Arrays.stream(res).forEach(element -> System.out.print(element+" "));
    }
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] answer = new long[n];
        int i=0;
        //half for 3 =2, half for 4 = 2
        long half = (intLength+1)/2;
        long start = (long) Math.pow(10,half-1);
        long end = (long)Math.pow(10,half)-1;
        for(int num : queries){
            if(num<= (end-start+1)){
                //check if query is within range
                String firstHalfPalindrome = ((start) + (num-1)) +"";
                String secondHalfPalindrome = (new StringBuilder(firstHalfPalindrome)).reverse().toString();
                // since half is calculated as 1 extra for odd numbers,
                // remove the first char for odd length in substring - 1001 vs 10+(0)1
                answer[i++] = Long.parseLong(firstHalfPalindrome + secondHalfPalindrome.substring(intLength%2));
            } else
                answer[i++] = -1;

        }
        return answer;
    }
}
