package com.dp;
/*
509. Fibonacci Number

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each
number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

TC : o(n)
SC: o(n)
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib(4));
    }
    public int fib(int n) {
        int[] fin = new int[n+1];
        if(n<2)
            return n;
        fin[0] =0;
        fin[1]=1;
        for(int i=2;i<=n;i++){
            fin[i] = fin[i-1]+fin[i-2];
        }
        return fin[n];
    }
}
