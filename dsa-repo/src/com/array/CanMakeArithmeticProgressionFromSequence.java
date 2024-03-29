package com.array;

import java.util.Arrays;

/*
1502. Can Make Arithmetic Progression From Sequence

A sequence of numbers is called an arithmetic progression if the difference between any two consecutive
elements is the same.

Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression.
Otherwise, return false.



Example 1:

Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively,
between each consecutive elements.

TC: o(nlogn)
SC: o(1)
 */
public class CanMakeArithmeticProgressionFromSequence {

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,1};
        System.out.println(new CanMakeArithmeticProgressionFromSequence().canMakeArithmeticProgression(nums));
    }
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length==0 || arr.length==1)
            return true;
        Arrays.sort(arr);
        int diff = arr[1]-arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]!=diff)
                return false;
        }
        return true;
    }
}
