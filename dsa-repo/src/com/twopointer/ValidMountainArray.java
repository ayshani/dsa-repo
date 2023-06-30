package com.twopointer;
/*
941. Valid Mountain Array

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true

TC : o(n)
SC: o(1)
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,2,1};
        System.out.println(new ValidMountainArray().validMountainArray(nums));
    }
    /*
    Two people climb from left and from right separately.
    If they are climbing the same mountain,
    they will meet at the same point.
     */
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3)
            return false;
        int n = arr.length , i=0, j= n-1;
        while(i+1<n && arr[i]<arr[i+1])
            i++;
        while(j>0 && arr[j]<arr[j-1])
            j--;
        return i>0 && j<n-1 && i==j;
    }
}
