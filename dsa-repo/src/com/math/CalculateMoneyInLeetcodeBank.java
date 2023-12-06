package com.math;
/*
1716. Calculate Money in Leetcode Bank

Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than
the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.



Example 1:

Input: n = 4
Output: 10
Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.

Explanation--
totalSum = K*(F+L)/2
last term = F +(k-1)*difference

TC : o(n)
SC: o(1)
 */
public class CalculateMoneyInLeetcodeBank {

    public static void main(String[] args) {
        System.out.println(new CalculateMoneyInLeetcodeBank().totalMoney(5));
    }
    public int totalMoney(int n) {
        int numberOfFullWeeks = n/7;
        int first = 28;
        int last = first + (numberOfFullWeeks-1)*7;
        int sumForFullWeeks = numberOfFullWeeks * (first +last)/2;

        int lastMonday = 1+numberOfFullWeeks;
        int lastDay = lastMonday + (n%7 -1);
        int lastWeekSum = (n%7) * (lastMonday + lastDay)/2;
        return sumForFullWeeks + lastWeekSum;
    }
}
