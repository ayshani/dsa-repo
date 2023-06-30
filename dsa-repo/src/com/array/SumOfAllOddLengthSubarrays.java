package com.array;
/*
1588. Sum of All Odd Length Subarrays

Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

TC: o(n)
SC: o(1)

Ref : https://www.youtube.com/watch?v=J5IIH35EBVE&t=876s
 */
public class SumOfAllOddLengthSubarrays {

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,2,5,3};
        System.out.println(new SumOfAllOddLengthSubarrays().sumOddLengthSubarrays(nums));
    }
    public int sumOddLengthSubarrays(int[] arr) {
        int result =0, n = arr.length;
        for(int i=0;i<n;i++){
            // how many subarray can start with ith element
            int start = n-i;
            // how many subarray can end with ith element
            int end = i+1;
            // total will give me total count it can appear
            // in all subarray lengths
            int total = start *end;
            // so, half should come in odd and half should go in even
            // length sub array.
            int odd = total/2;
            // but in case total count is odd, that means, total/2
            // will give me even. so we need to add one more to it.
            if(total%2!=0)
                odd++;
            result+=odd*arr[i];
        }

        return result;
    }
}
