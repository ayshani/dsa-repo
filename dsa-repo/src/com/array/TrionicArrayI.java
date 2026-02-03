package com.array;
/*
3637. Trionic Array I

You are given an integer array nums of length n.

An array is trionic if there exist indices 0 < p < q < n − 1 such that:

nums[0...p] is strictly increasing,
nums[p...q] is strictly decreasing,
nums[q...n − 1] is strictly increasing.
Return true if nums is trionic, otherwise return false.



Example 1:

Input: nums = [1,3,5,4,2,6]

Output: true

Explanation:

Pick p = 2, q = 4:

nums[0...2] = [1, 3, 5] is strictly increasing (1 < 3 < 5).
nums[2...4] = [5, 4, 2] is strictly decreasing (5 > 4 > 2).
nums[4...5] = [2, 6] is strictly increasing (2 < 6).

TC : o(n)
SC: o(1)
 */
public class TrionicArrayI {

    public static void main(String[] args) {
        System.out.println(new TrionicArrayI().isTrionic(new int[]{1,3,5,4,2,6}));
    }
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (nums[0] >= nums[1]) {
            return false;
        }
        int count = 1;
        for(int i=2;i<n;i++){
            if(nums[i-1]== nums[i]){
                return false;
            }
            /*
            This defines there will be two segments where increasing -> decreasing -> increasing is defined
            whenever we go from increasing -> decreasing or decreasing -> increasing,
            one pair should always be negative hence the multiplication would be -ve
             */
            if((nums[i-2]-nums[i-1])* (nums[i-1]-nums[i])<0){
                count++;
            }
        }
        return count ==3;
    }
}
