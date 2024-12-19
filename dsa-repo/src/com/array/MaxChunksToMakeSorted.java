package com.array;
/*
769. Max Chunks To Make Sorted

You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk.
After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.


Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

TC : o(n)
SC: o(n)
 */
public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4};
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(nums));
    }
    public int maxChunksToSorted(int[] arr) {
        /*
        The basic idea is to use max[] array to keep track of the max value untiles from 0 to arr.length - 1).
        If the max[i] equals to index i in the sorted array, then the final count++.
        */
        int n = arr.length;
        int[] max = new int[n];
        max[0] = arr[0];
        for(int i=1;i<n;i++){
            max[i] = Math.max(max[i-1], arr[i]);
        }
        int count =0;
        for(int i=0;i<n;i++){
            if(max[i]==i)
                count++;
        }
        return count;
    }
}
