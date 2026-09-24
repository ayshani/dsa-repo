package com.array;
/*
3550. Smallest Index With Digit Sum Equal to Index

You are given an integer array nums.

Return the smallest index i such that the sum of the digits of nums[i] is equal to i.

If no such index exists, return -1.



Example 1:

Input: nums = [1,3,2]

Output: 2

Explanation:

For nums[2] = 2, the sum of digits is 2, which is equal to index i = 2. Thus, the output is 2.

TC : o(n*digit)
SC: o(1)
 */
public class SmallestIndexWithDigitSumEqualToIndex {
    public static void main(String[] args) {
        System.out.println(new SmallestIndexWithDigitSumEqualToIndex().smallestIndex(new int[]{1,3,2}));
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int digitSum = sum(nums[i]);
            if(digitSum == i){
                return i;
            }
        }
        return -1;
    }

    private int sum(int num){
        int sum =0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
