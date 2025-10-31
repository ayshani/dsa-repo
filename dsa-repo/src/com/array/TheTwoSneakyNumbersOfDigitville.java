package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
3289. The Two Sneaky Numbers of Digitville

In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1. Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in an additional time, making the list longer than usual.

As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing the two numbers (in any order), so peace can return to Digitville.



Example 1:

Input: nums = [0,1,1,0]

Output: [0,1]

Explanation:

The numbers 0 and 1 each appear twice in the array.

TC : o(n)
SC: o(n)
 */
public class TheTwoSneakyNumbersOfDigitville {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new TheTwoSneakyNumbersOfDigitville().getSneakyNumbers(new int[]{0,1,1,0})));
    }
    public int[] getSneakyNumbers(int[] nums) {
        int[] result = new int[2];
        int index =0;
        Map<Integer,Integer> count = new HashMap<>();
        for(int num : nums){
            int c = count.getOrDefault(num,0)+1;
            count.put(num,c);
            if(c==2){
                result[index++]=num;
            }
        }
        return result;

    }
}
