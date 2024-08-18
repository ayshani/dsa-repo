package com.dp;
/*
264. Ugly Number II

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

Logic
--------
The idea of this solution is from this page:http://www.geeksforgeeks.org/ugly-numbers/

The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split
the sequence to three groups as below:

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.

Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.
Every step we choose the smallest one, and move one step after,including nums with same value.

TC : o(n)
SC : o(n)

 */
public class UglyNumberII {

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(10));
    }
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int fac2=2, fac3=3,fac5=5, index2 =0,index3=0, index5=0;

        dp[0]=1;
        for(int i=1;i<n;i++){
            int min = Math.min(fac2, Math.min(fac3,fac5));

            dp[i] = min;
            if(min ==fac2){
                fac2 = 2*dp[++index2];
            }
            if(min ==fac3){
                fac3 = 3*dp[++index3];
            }
            if(min ==fac5){
                fac5 = 5*dp[++index5];
            }
        }

        return dp[n-1];
    }
}
