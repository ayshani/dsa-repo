package com.array;
/*
961. N-Repeated Element in Size 2N Array

You are given an integer array nums with the following properties:

nums.length == 2 * n.
nums contains n + 1 unique elements.
Exactly one element of nums is repeated n times.
Return the element that is repeated n times.



Example 1:

Input: nums = [1,2,3,3]
Output: 3
Example 2:

Input: nums = [2,1,2,5,3,2]
Output: 2

Intuition and Algorithm

If we ever find a repeated element, it must be the answer. Let's call this answer the major element.

Consider all subarrays of length 4. There must be a major element in at least one such subarray.

This is because either:

There is a major element in a length 2 subarray, or;
Every length 2 subarray has exactly 1 major element, which means that a length 4 subarray
that begins at a major element will have 2 major elements.
Thus, we only have to compare elements with their neighbors that are distance 1, 2, or 3 away.

Time Complexity: O(N), where NN is the length of A.

Space Complexity: O(1).


 */
public class NRepeatedElementInSize2NArray {

    public static void main(String[] args) {
        int[] num = new int[]{5,1,5,2,5,3,5,4};
        System.out.println(new NRepeatedElementInSize2NArray().repeatedNTimes(num));
    }
    public int repeatedNTimes(int[] A) {
        for(int k=1;k<=3;k++){
            for(int i=0;i<A.length-k;i++){
                if(A[i] == A[i+k])
                    return A[i];
            }
        }

        return 0;
    }
}
