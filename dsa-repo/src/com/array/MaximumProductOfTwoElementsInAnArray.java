package com.array;
/*
1464. Maximum Product of Two Elements in an Array

Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum
value of (nums[i]-1)*(nums[j]-1).


Example 1:

Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is,
(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.

TC : o(n)
SC: o(1)
 */
public class MaximumProductOfTwoElementsInAnArray {

    public static void main(String[] args) {
        System.out.println(new MaximumProductOfTwoElementsInAnArray().maxProduct(new int[]{3,4,2,8}));
    }
    public int maxProduct(int[] nums) {
        int biggest=0, secondBiggest =0;
        for(int num : nums){
            if(num>biggest){
                secondBiggest = biggest;
                biggest = num;
            } else{
                secondBiggest = Math.max(secondBiggest, num);
            }
        }
        return (biggest-1)*(secondBiggest-1);
    }
}
