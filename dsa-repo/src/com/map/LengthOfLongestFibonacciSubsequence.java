package com.map;

import java.util.HashMap;
import java.util.Map;

/*
873. Length of Longest Fibonacci Subsequence

A sequence x1, x2, ..., xn is Fibonacci-like if:

n >= 3
xi + xi+1 == xi+2 for all i + 2 <= n
Given a strictly increasing array arr of positive integers forming a sequence, return the length of the
longest Fibonacci-like subsequence of arr. If one does not exist, return 0.

A subsequence is derived from another sequence arr by deleting any number of elements (including none)
from arr, without changing the order of the remaining elements.
For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].



Example 1:

Input: arr = [1,2,3,4,5,6,7,8]
Output: 5
Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].

TC : o(n^2)
SC : o(nlogm)
 */
public class LengthOfLongestFibonacciSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(new LengthOfLongestFibonacciSubsequence().lenLongestFibSubseq(nums));
    }
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> index = new HashMap<>(), longest = new HashMap<>();
        int n = arr.length;
        // add index of individual element
        for(int i=0;i<n;i++){
            index.put(arr[i],i);
        }

        int ans =0;
        // loop over the array
        for(int k=0;k<n;k++){
            // loop over till j<k
            for(int j=0;j<k;j++){
                // get i as an index
                int i = index.getOrDefault(arr[k]-arr[j],-1);
                // if i>=0 and less than j, that means i<j<k i.e a subsequence found
                if(i>=0 && i<j){
                    // encoding the value to i*n+j
                    int cur = longest.getOrDefault(i*n+j,2)+1;
                    longest.put(j*n+k,cur);
                    ans = Math.max(ans,cur);
                }
            }
        }
        return ans>=3 ? ans : 0;
    }
}
