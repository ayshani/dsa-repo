package com.bit.manipulation;
/*
1442. Count Triplets That Can Form Two Arrays of Equal XOR

Given an array of integers arr.

We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

Let's define a and b as follows:

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
Note that ^ denotes the bitwise-xor operation.

Return the number of triplets (i, j and k) Where a == b.



Example 1:

Input: arr = [2,3,1,6,7]
Output: 4
Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)

TC : o(n^3)
SC : o(1)
 */
public class CountTripletsThatCanFormTwoArraysOfEqualXOR {

    public static void main(String[] args) {
        System.out.println(new CountTripletsThatCanFormTwoArraysOfEqualXOR().countTriplets(
                new int[]{2,3,1,6,7}
        ));
    }
    public int countTriplets(int[] arr) {
        int count =0, n = arr.length;
        for(int start =0; start< n; start++){
            int xorA =0;
            for(int mid = start +1; mid<n; mid++){
                xorA ^= arr[mid-1];
                int xorB = 0;
                for(int end = mid; end<n; end++){
                    xorB ^= arr[end];
                    if(xorA == xorB){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
