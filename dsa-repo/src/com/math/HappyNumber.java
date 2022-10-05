package com.math;
/*
202. Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

TC : o(logn)
SC : o(1)
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }

    public boolean isHappy(int n) {

        int slowRunner =n , fastRunner = getNext(n);

        // check if final digit sum becomes 1 or
        //slow and fast doesnt become same. Incase if both becomes same
        // that means there is a cycle exist . If cycle exists
        // then there is no way we can get 1 .
        while(fastRunner!=1 && slowRunner!=fastRunner){
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }

        return fastRunner==1;
    }

    /*
    Get total sum by adding square of digits
     */
    private int getNext(int n){
        int totalSum=0;
        while(n>0){
            int d = n%10;
            n/=10;
            totalSum+= d*d;
        }

        return totalSum;
    }
}
