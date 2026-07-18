package com.array;
/*
1979. Find Greatest Common Divisor of Array

Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.



Example 1:

Input: nums = [2,5,6,9,10]
Output: 2
Explanation:
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.

TC : o(n  logm)
SC: o(1)
 */
public class FindGreatestCommonDivisorOfArray {

    public static void main(String[] args) {
        System.out.println(new FindGreatestCommonDivisorOfArray().findGCD(new int[]{2,5,6,9,10}));
    }
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        return gcd(max, min);
    }

    private int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
