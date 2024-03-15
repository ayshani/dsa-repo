package com.array;

import java.util.Arrays;

/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

TC : o(n)
SC: o(1)
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,0};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelfV1(nums)));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelfV2(nums)));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelfV3(nums)));
    }
    public int[] productExceptSelfV1(int[] nums) {

        int prod =1, zeroNum=0, zeroIndex=0, n = nums.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroNum++;
                zeroIndex=i;
            } else{
                prod *= nums[i];
            }
        }

        if(zeroNum>1){
            return res;
        } else if(zeroNum==1){
            res[zeroIndex]= prod;
            return res;
        }

        for(int i=0;i<n;i++){
            res[i] = prod/nums[i];
        }
        return res;
    }

    public int[] productExceptSelfV2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n], left = new int[n], right = new int[n];

        left[0] = 1;
        for(int i=1;i<n;i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i=0;i<n;i++){
            ans[i] = left[i]*right[i];
        }

        return ans;
    }

    public int[] productExceptSelfV3(int[] nums) {
        int n = nums.length;
        int cur =1;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        for(int i=0;i<n;i++){
            ans[i] *=cur;
            cur *= nums[i];
        }

        cur=1;
        for(int i=n-1;i>=0;i--){
            ans[i] *= cur;
            cur*=nums[i];
        }

        return ans;
    }
}
