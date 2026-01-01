package com.array;

import java.util.Arrays;

/*
66. Plus One

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of
 the integer. The digits are ordered from most significant to least significant in left-to-right order. The large
 integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

TC: o(n)
SC: o(n)
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,1};
        System.out.println(Arrays.toString(new PlusOne().plusOne(nums)));
    }
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i= n-1;i>=0;i--){
            digits[i] = digits[i]+1;
            if(digits[i]==10){
                if(i==0){
                    int[] total = new int[n+1];
                    total[0]=1;
                    for(int j=1;j<n;j++){
                        total[j] = digits[j];
                    }
                    digits= total;
                } else{
                    digits[i]=0;
                }
            } else
                break;
        }

        return digits;
    }
}
