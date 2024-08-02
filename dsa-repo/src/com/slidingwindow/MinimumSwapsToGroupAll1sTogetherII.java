package com.slidingwindow;
/*
2134. Minimum Swaps to Group All 1's Together II

A swap is defined as taking two distinct positions in an array and swapping the values in them.

A circular array is defined as an array where we consider the first element and the last element to be adjacent.

Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the
array together at any location.

Example 1:

Input: nums = [0,1,0,1,1,0,0]
Output: 1
Explanation: Here are a few of the ways to group all the 1's together:
[0,0,1,1,1,0,0] using 1 swap.
[0,1,1,1,0,0,0] using 1 swap.
[1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
There is no way to group all 1's together with 0 swaps.
Thus, the minimum number of swaps required is 1.

TC : o(n)
SC : o(1)
 */
public class MinimumSwapsToGroupAll1sTogetherII {

    public static void main(String[] args) {
        System.out.println(new MinimumSwapsToGroupAll1sTogetherII().minSwaps(
                new int[]{0,1,0,1,1,0,0}
        ));
    }


    public int minSwaps(int[] nums) {
        int minOne = minSwap(nums, 1);
        int minZero = minSwap(nums, 0);
        return Math.min(minOne, minZero);
    }

    private int minSwap(int[] nums, int val){
        int n = nums.length;
        int total = 0;

        for(int i=n-1; i>=0; i--){
            if(nums[i]== val){
                total++;
            }
        }

        if(total ==0 || total == n){
            return 0;
        }

        int start =0, end =0;
        int maxWindow = 0, currentWindow =0;

        while(end<total){
            if(nums[end++] == val){
                currentWindow++;
            }
        }
        maxWindow = Math.max(maxWindow, currentWindow);
        while(end < n){
            if(nums[start++] == val){
                currentWindow--;
            }

            if(nums[end++]== val){
                currentWindow++;
            }

            maxWindow = Math.max(maxWindow, currentWindow);
        }

        return total - maxWindow;
    }
}
