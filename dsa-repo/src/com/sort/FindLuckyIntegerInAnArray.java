package com.sort;

import java.util.Arrays;

/*
1394. Find Lucky Integer in an Array

Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.



Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.


TC : o(nlogn)
SC: o(1)
 */
public class FindLuckyIntegerInAnArray {

    public static void main(String[] args) {
        System.out.println(new FindLuckyIntegerInAnArray().findLucky(new int[]{2,2,3,4}));
    }
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int count =1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]== arr[i+1]){
                count++;
            } else{
                if(arr[i+1]== count){
                    return count;
                }
                count =1;
            }
        }
        return arr[0] == count ? count : -1;
    }
}
