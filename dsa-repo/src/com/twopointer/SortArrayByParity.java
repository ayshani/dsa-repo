package com.twopointer;

import java.util.Arrays;

/*
905. Sort Array By Parity

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd
integers.

Return any array that satisfies this condition.

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

TC: o(n)
SC: o(1)
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,4};
        new SortArrayByParity().sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));
    }
    public int[] sortArrayByParityV2(int[] nums) {
        int n = nums.length;
        int low =0, mid=0, high = n-1;
        while(mid<high){
            if(nums[mid]%2==0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        return nums;
    }

    public int[] sortArrayByParity(int[] nums) {
        int start =0, end =nums.length-1 ;
        while(start<end){
            if(nums[start]%2!=0){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                end--;
            }else{
                start++;
            }
        }
        return nums;
    }
}
