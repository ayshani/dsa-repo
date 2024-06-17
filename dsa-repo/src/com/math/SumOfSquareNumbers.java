package com.math;
/*
633. Sum of Square Numbers

Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.



Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

TC : o(root(c) * logc)
SC: o(1)
 */
public class SumOfSquareNumbers {

    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(5));
    }
    public boolean judgeSquareSum(int c) {
        for( long a =0; a*a<=c; a++){
            double b = Math.sqrt(c- a*a);
            if(b == (int)b){
                return true;
            }
        }
        return false;
    }
}
