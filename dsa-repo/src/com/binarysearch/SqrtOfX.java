package com.binarysearch;
/*
69. Sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
 */
public class SqrtOfX {

    public static void main(String[] args) {
        System.out.println(new SqrtOfX().mySqrt(63));
    }
    public int mySqrt(int x) {
        long low =0, high =x, ans =0;

        while(low<=high){
            long mid = low +(high-low)/2;
            long square = mid*mid;
            if(square == x)
                return (int)mid;
            else if(square> x){
                high = mid-1;
            } else{
                ans = mid;
                low = mid +1;
            }
        }
        return (int)ans;
    }
}
