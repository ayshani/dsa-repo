package com.sort.quicksort;

import java.util.Arrays;

/*
912. Sort an Array

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and
with the smallest space complexity possible.

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3),
while the positions of other numbers are changed (for example, 1 and 5).

TC : o(nlogn)
SC: o(logn)
 */
public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        Arrays.stream(new SortAnArray().sortArray(nums)).forEach(e -> System.out.print(e+" "));
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r){
        if(l<r){
            int pivotPosition = partition(nums, l,r);
            quickSort(nums,l,pivotPosition);
            quickSort(nums, pivotPosition+1,r);
        }
    }

    private int partition(int[] nums, int low,int high){

        int pivot = nums[low];
        int l = low-1, r = high+1;
        while(true){
            do{
                l++;
            } while(nums[l]<pivot);
            do{
                r--;
            } while(nums[r]>pivot);

            if(l>=r)
                return r;

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

    }
}
