package com.string.manipulation;
/*
556. Next Greater Element III

Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer
n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in
32-bit integer, return -1.



Example 1:

Input: n = 12
Output: 21

TC : o(n)
SC: o(n)
 */
public class NextGreaterElementIII {

    public static void main(String[] args) {
        System.out.println(new NextGreaterElementIII().nextGreaterElement(3474683));
    }
    public int nextGreaterElement(int n) {
        char[] nums = (n+"").toCharArray();
        int size = nums.length;
        int i = size-1;
        while(i>0 && nums[i-1]>=nums[i])
            i--;
        if(i==0)
            return -1;

        int j = size-1;
        while(j>0 && nums[i-1]>=nums[j])
            j--;

        char temp = nums[i-1];
        nums[i-1] =nums[j];
        nums[j] = temp;

        int l=i, h =size-1;
        while(l<h){
            char t = nums[l];
            nums[l] =nums[h];
            nums[h] = t;
            l++;
            h--;
        }
        try{
            return Integer.parseInt(new String(nums));
        } catch(Exception e){
            return -1;
        }

    }
}
