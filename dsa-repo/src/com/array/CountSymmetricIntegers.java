package com.array;
/*
2843. Count Symmetric Integers

You are given two positive integers low and high.

An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.

Return the number of symmetric integers in the range [low, high].



Example 1:

Input: low = 1, high = 100
Output: 9
Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.

TC : o(n)
sc: o(1)
 */
public class CountSymmetricIntegers {
    public static void main(String[] args) {
        System.out.println(new CountSymmetricIntegers().countSymmetricIntegers(
                1,100
        ));
    }
    public int countSymmetricIntegers(int low, int high) {
        int sum1=0, sum2 =0, count =0;
        for(int num= low; num<= high;num++){
            String s = String.valueOf(num);
            int len = s.length();
            if(len%2!=0)
                continue;
            int half = len/2;
            String s1 = s.substring(0,half);
            String s2 = s.substring(half, len);
            sum1=0;
            sum2 =0;
            for(int i=0;i<half;i++){
                int num1 = s1.charAt(i)-'0';
                sum1+= num1;
                int num2 = s2.charAt(i)-'0';
                sum2+= num2;
            }
            if(sum1==sum2)
                count++;
        }
        return count;
    }
}
