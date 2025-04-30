package com.string.manipulation;
/*
1295. Find Numbers with Even Number of Digits

Given an array nums of integers, return how many of them contain an even number of digits.



Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.

TC : o(n)
SC: o(1)
 */
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        System.out.println(new FindNumbersWithEvenNumberOfDigits().findNumbers(
                new int[]{12,345,2,6,7896}
        ));
    }
    public int findNumbers(int[] nums) {
        int sum =0;
        for(int i=0;i<nums.length;i++){
            String s = String.valueOf(nums[i]);
            if(s.length()%2 == 0)
                sum++;
        }

        return sum;
    }
}
