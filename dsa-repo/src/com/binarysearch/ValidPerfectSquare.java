package com.binarysearch;
/*
367. Valid Perfect Square

Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of
some integer with itself.

You must not use any built-in library function, such as sqrt.



Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
TC: o(logn)
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
    }
    public boolean isPerfectSquare(int num) {
        if(num==1)
            return true;
        long l=1, r = num;
        while(l<=r){
            /*
            One thing to note is that we have to use long for mid to avoid mid*mid from overflow.
            Also, you can use long type for low and high to avoid type casting for mid from long to int.
             */
            long mid = l+(r-l)/2;
            long sq = mid*mid;
            if(sq==num)
                return true;
            else if(sq<num){
                l  = mid+1;
            } else{
                r = mid-1;
            }
        }
        return false;
    }
}
