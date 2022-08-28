package com.math;
/*
1780. Check if Number is a Sum of Powers of Three

Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three.
Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3x.

Example 1:

Input: n = 12
Output: true
Explanation: 12 = 3^1 + 3^2

Method 1:

Intuition
n can be divided by 3, if it does not have term 30. In short:n % 3 == 0 or (n - 1) % 3 == 0, which is n % 3 != 2.

Explanation
Since n = 3a + 3b + ..., where a, b, ... are all distinct, there is at most one 30.

Therefore, we can either divide n by 3 or minus by 1, repeat till it decreases to 1; otherwise return false.

TC : o(logn)
SC : o(1)
 */
public class CheckIfNumberIsASumOfPowersOfThree {

    public static void main(String[] args) {
        System.out.println(new CheckIfNumberIsASumOfPowersOfThree().checkPowersOfThree(91));
    }
    public boolean checkPowersOfThree(int n) {
        while(n>0){
            if(n%3==2)
                return false;
            else
                n/=3;
        }

        return true;
    }
}
