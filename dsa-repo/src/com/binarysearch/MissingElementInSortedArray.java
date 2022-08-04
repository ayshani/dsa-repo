package com.binarysearch;
/*
1060. Missing Element in Sorted Array

Given a sorted array A of unique numbers,
find the K-th missing number starting from the leftmost number of the array.

Example 1:

Input: A = [4,7,9,10], K = 1

Output: 5

Explanation:

The first missing number is 5.

Logic
-------
See inline

TC : o(logn)
SC : o(1)

 */
public class MissingElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4,7,9,10};
        int k =3;

        System.out.println(new MissingElementInSortedArray().missingNumber(nums,k));
    }
    /*
    we need to find the no. of missing numbers between index range[0,idx]
    so, we get nums[idx] as max Number, nums[0] as the min number.
    total mising number between these two = nums[idx] - nums[0]
    Now, the number nums[idx] resides at idx index i.e. we assume that before this index,
    we have some numbers which exists in [0,idx] range.
    so we need to subtract those mnay numbers which we cna get from idx index.
    So, the final solution become = nums[idx] - nums[0] -idx;
    */
    private int totalMissingNumber(int nums[], int idx){
        return nums[idx]- nums[0] -idx;
    }


    public int missingNumber(int[] nums, int k){
        int n = nums.length;
        /*
        First , we check if k is greater than total missing numbers between [0,n).
        If yes, then we take last number and add k. but we need to take into account total
        missing numbers between [0,n).
        so, we subtract those total missing numbers and get the actual missing one.
         */
        if(k> totalMissingNumber(nums,n-1))
            return nums[n-1] +k - totalMissingNumber(nums,n-1);

        /*
        Incase, k is in between [0,n), then we do binary search to get the nearest largest index
        which can contain k number of missing elements.
         */
        int low = 0, high = n-1;
        while(low < high){
            int mid = low+(high-low)/2;

            if(totalMissingNumber(nums,mid)<k)
                low = mid+1;
            else
                high = mid;
        }
        /*
        Once we get the high = nearest larget index,
        we calculate from [high-1] and get the ans.
         */
        return nums[high-1] + k - totalMissingNumber(nums,high-1);
    }
}
