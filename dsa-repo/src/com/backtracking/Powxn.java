package com.backtracking;
/*
50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
 */
public class Powxn {

    public static void main(String[] args) {
        System.out.println(new Powxn().myPow(2.00,3));
        System.out.println(new Powxn().myPow(2.00,2));
        System.out.println(new Powxn().myPow(2.00,-2));
    }
    public double myPow(double x, int n) {
        if(n<0)
            return 1/pow(x,Math.abs(n));
        return pow(x,n);
    }

    private double pow(double x, int n){
        if(n==0)
            return 1;
        if(n==1)
            return x;
        if(n%2==0)
            return pow(x*x,n/2);
        return x* pow(x*x, n/2);
    }
}
