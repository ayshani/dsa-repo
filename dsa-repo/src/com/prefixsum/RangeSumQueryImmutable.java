package com.prefixsum;
/*
303. Range Sum Query - Immutable

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Logic
------
compute prefix sum and return sum of range [right-(left-1)]

TC : o(n)
SC : o(n)
 */
public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,3,-5,2,-1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));

    }
}

class NumArray {
    int[] prefSum;
    int n;
    public NumArray(int[] nums) {
        int size = nums.length;
        if(size>0){
            this.n = size;
            prefSum = new int[n];
            buildSum(nums);
        }
    }

    public int sumRange(int left, int right) {
        if(left==0)
            return prefSum[right];
        return prefSum[right]-prefSum[left-1];
    }

    private void buildSum(int[] nums){
        int sum = 0;
        prefSum[0]=nums[0];
        for(int i=1;i<n;i++)
            prefSum[i]= prefSum[i-1]+nums[i];
    }
}

