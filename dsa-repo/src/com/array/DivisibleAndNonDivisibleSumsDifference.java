package com.array;
/*
2894. Divisible and Non-divisible Sums Difference

You are given positive integers n and m.

Define two integers as follows:

num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
Return the integer num1 - num2.



Example 1:

Input: n = 10, m = 3
Output: 19
Explanation: In the given example:
- Integers in the range [1, 10] that are not divisible by 3 are [1,2,4,5,7,8,10], num1 is the sum of those integers = 37.
- Integers in the range [1, 10] that are divisible by 3 are [3,6,9], num2 is the sum of those integers = 18.
We return 37 - 18 = 19 as the answer.

TC : o(n)
SC: o(1)
 */
public class DivisibleAndNonDivisibleSumsDifference {

    public static void main(String[] args) {
        System.out.println(new DivisibleAndNonDivisibleSumsDifference().differenceOfSums(10,3));
    }
    public int differenceOfSums(int n, int m) {
        int num1 =0, num2 =0;
        for(int i=1;i<=n;i++){
            if(i%m!=0)
                num1 += i;
            else
                num2 += i;
        }
        return num1-num2;
    }
}
