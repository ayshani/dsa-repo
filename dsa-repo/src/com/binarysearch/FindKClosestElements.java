package com.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
658. Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

TC : o(logn)
SC: o(1)
 */
public class FindKClosestElements {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(new FindKClosestElements().findClosestElements(arr,4,3));
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0, r = arr.length-k;
        while(l<r){
            int mid = l+(r-l)/2;
            if(x-arr[mid] > arr[mid+k]-x){
                l =mid+1;
            } else{
                r = mid;
            }
        }

        return Arrays.stream(arr, l, l+k).boxed().collect(Collectors.toList());
    }
}
