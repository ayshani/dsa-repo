package com.math;
/*
263. Ugly Number

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

Example 1:

Input: n = 6
Output: true
Explanation: 6 = 2 × 3

TC : o(n)
SC : o(1)
 */
public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(51));
    }
    public boolean isUgly(int n) {
        if(n<1)
            return false;
        while(n%2==0)
            n/=2;
        while(n%3==0)
            n/=3;
        while(n%5==0)
            n/=5;

        return n==1;

    }

}
