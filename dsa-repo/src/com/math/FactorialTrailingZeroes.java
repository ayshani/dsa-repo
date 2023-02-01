package com.math;
/*
172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Explanation
---------------
all trailing 0 is from factors 5 * 2.
So, if we can figure out the lesser of how many 5s and how many 2s are hiding within the sequence
of numbers being multiplied together in the calculation for n!, we will know how many 10s are hiding there
- and we will have our answer.

Now, for making a factorial, 2 comes first then 4 then 5. so, in 5!, we will have multiple 2s.
i.e. every other number (i.e. every even number) in the calculation for n! will have at least one factor of 2,
so the number of factors of 2 will far exceed the number of factors of 5.
Because we're looking for the lesser of the two, we can just focus on finding the number of factors of 5.

But we're not done yet. We need to be sure to count the additional 5s hiding in numbers like 25, 625, 5^4, 5^5, etc.
These numbers are multiples of 5, so they've already been counted once, but they contain additional factors
of 5 that need to be counted again. 25 has one more factor of 5. 625 has two more. 5^4 has three more, etc.
So, all multiples of 5 have at least one factor of 5.
Powers of 5, as in 5^2 or 5^3, have more than one factor of 5, so those needs to be counted more than once.

so basically the formula becomes :

count = (n/5) + (n/25) + (n/125)+ .......


TC : o(log(base 5)n)
SC: o(1)
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(20));
    }
    public int trailingZeroes(int n) {
        int count =0;

        while(n>0){
            int temp  = n/5;
            count+=temp;
            n=temp;
        }

        return count;
    }
}
