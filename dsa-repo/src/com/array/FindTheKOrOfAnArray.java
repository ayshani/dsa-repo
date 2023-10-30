package com.array;
/*
100111. Find the K-or of an Array

You are given a 0-indexed integer array nums, and an integer k.

The K-or of nums is a non-negative integer that satisfies the following:

The ith bit is set in the K-or if and only if there are at least k elements of nums in which bit i is set.
Return the K-or of nums.

Note that a bit i is set in x if (2i AND x) == 2i, where AND is the bitwise AND operator.

Example 1:

Input: nums = [7,12,9,8,9,15], k = 4
Output: 9
Explanation: Bit 0 is set at nums[0], nums[2], nums[4], and nums[5].
Bit 1 is set at nums[0], and nums[5].
Bit 2 is set at nums[0], nums[1], and nums[5].
Bit 3 is set at nums[1], nums[2], nums[3], nums[4], and nums[5].
Only bits 0 and 3 are set in at least k elements of the array, and bits i >= 4 are not set in any of the array's
elements. Hence, the answer is 2^0 + 2^3 = 9.
 */
public class FindTheKOrOfAnArray {

    public static void main(String[] args) {
        System.out.println(new FindTheKOrOfAnArray().findKOr(new int[]{7,12,9,8,9,15}, 4));
    }
    public int findKOr(int[] nums, int k) {
        int n = nums.length;
        if(k==0)
            return 0;
        if(k== n){
            return bitwiseAnd(nums, n);
        } else if(k==1){
            return bitwiseOr(nums, n);
        }

        String[] binary = new String[n];
        int maxBit =0;
        for(int i=0;i<n;i++){
            binary[i] = new StringBuilder(Integer.toBinaryString(nums[i])).reverse().toString();
            maxBit = Math.max(maxBit, binary[i].length());
        }
        int total =0;
        for(int i=0;i<maxBit;i++){
            int sum =0;
            for(int j=0;j<n;j++){
                if(binary[j].length()>i)
                    sum += (binary[j].charAt(i)=='1' ? 1 : 0);
            }
            if(sum>=k){
                total += (int)(Math.pow(2,i));
            }
        }
        return total;
    }

    private int bitwiseAnd(int[] nums, int n){
        int and =nums[0];
        for(int i=1;i<n;i++){
            and &= nums[i];
        }
        return and;
    }

    private int bitwiseOr(int[] nums, int n){
        int or =nums[0];
        for(int i=1;i<n;i++){
            or |= nums[i];
        }
        return or;
    }
}
