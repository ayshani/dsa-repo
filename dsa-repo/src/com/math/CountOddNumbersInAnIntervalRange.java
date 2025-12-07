package com.math;
/*
1523. Count Odd Numbers in an Interval Range

Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).



Example 1:

Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].

TC : o(1)
SC: o(1)
 */
public class CountOddNumbersInAnIntervalRange {

    public static void main(String[] args) {
        System.out.println(new CountOddNumbersInAnIntervalRange().countOdds(3,7));
    }
    public int countOdds(int low, int high) {
        if(low%2==0)
            low++;

        if(high%2==0)
            high--;
        return (high-low)/2+1;
    }
}
