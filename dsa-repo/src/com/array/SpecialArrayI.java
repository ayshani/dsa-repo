package com.array;
/*
3151. Special Array I

An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.



Example 1:

Input: nums = [1]

Output: true

Explanation:

There is only one element. So the answer is true.
 */
public class SpecialArrayI {

    public static void main(String[] args) {
        System.out.println(new SpecialArrayI().isArraySpecial(new int[]{1}));
    }
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if(n<2){
            return true;
        }
        for(int i=1;i<n;i++){
            if(getParity(nums[i-1]) == getParity(nums[i])){
                return false;
            }
        }
        return true;

    }

    private boolean getParity(int num){
        return num%2==0;
    }
}
