package com.dp;
/*
845. Longest Mountain in Array

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain.
Return 0 if there is no mountain subarray.



Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

TC : o(n)
SC: o(n)
 */
public class LongestMountainInArray {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,4,7,3,2,5};
        System.out.println(new LongestMountainInArray().longestMountain(nums));
    }
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] LIS = new int[n], LDS = new int[n];
        LIS[0]=1;
        LDS[n-1] =1;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                LIS[i] = LIS[i-1]+1;
            }else{
                LIS[i] = 1;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                LDS[i] = LDS[i+1]+1;
            }else{
                LDS[i] = 1;
            }
        }
        int maxLength =0;
        for(int i=0;i<n;i++){
            maxLength = Math.max(maxLength, LIS[i] + LDS[i]-1);
        }

        return maxLength;
    }
}
