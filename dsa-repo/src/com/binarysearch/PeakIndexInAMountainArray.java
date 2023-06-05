package com.binarysearch;
/*
852. Peak Index in a Mountain Array

An array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.

Input: arr = [0,2,1,0]
Output: 1

TC : o(logn)
SC: o(1)
 */
public class PeakIndexInAMountainArray {

    public static void main(String[] args) {
        int[] ar = new int[]{0,2,1,0};
        System.out.println(new PeakIndexInAMountainArray().peakIndexInMountainArray(ar));
    }
    public int peakIndexInMountainArray(int[] arr) {
        int l=0, r = arr.length-1;

        while(l<r){
            int mid= l+(r-l)/2;

            if(arr[mid]>arr[mid+1])
                r=mid;
            else
                l=mid+1;
        }

        return l;
    }
}
