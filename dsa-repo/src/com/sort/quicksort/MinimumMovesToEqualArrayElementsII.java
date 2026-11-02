package com.sort.quicksort;

import java.util.Random;

/*
462. Minimum Moves to Equal Array Elements II

Given an integer array nums of size n, return the minimum number of moves required to make all array
elements equal.

In one move, you can increment or decrement an element of the array by 1.

Test cases are designed so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

TC :
 */
public class MinimumMovesToEqualArrayElementsII {

    public static void main(String[] args) {
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(new int[]{1,2,3}));
    }
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int op =0, mid = quickSort(nums,0,n-1,n/2);

        for(int i=0;i<n;i++){
            op+=Math.abs(mid-nums[i]);
        }

        return op;
    }

    int quickSort(int[] nums, int l, int r, int k){
        if(l==r)
            return nums[l];
        int pIndex = new Random().nextInt(r-l+1) + l;
        pIndex = partition(nums,l,r,pIndex);
        if(pIndex==k)
            return nums[pIndex];
        else if(pIndex>k)
            return quickSort(nums,l,pIndex-1,k);
        else
            return quickSort(nums,pIndex+1,r,k);
    }

    int partition(int[] nums,int l, int r , int pIndex){
        int pivot = nums[pIndex];
        swap(nums,r,pIndex);

        pIndex=l;

        for(int i=l;i<=r;i++){
            if(nums[i]<=pivot)
                swap(nums,i,pIndex++);
        }

        return pIndex-1;
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
