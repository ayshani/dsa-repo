package com.greedy;

import java.util.Arrays;

/*
945. Minimum Increment to Make Array Unique

You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length
and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.
The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].
Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

Intuition

Let's imagine the array is sorted and we are moving from left to right. we want to take duplicate
values to release later.

Algorithm

As we iterate over the sorted array, for each number, there are two possible cases:

If nums[i-1] equals nums[i], we have a duplicate to take.

If nums[i-1] is less than nums[i], we might be able to place our taken values into those free positions.
Specifically, we have give = min(taken, nums[i] - nums[i-1] - 1) possible values to release, and they will have
final values nums[i-1] + 1, nums[i-1] + 2, ..., nums[i-1] + give.
This has a sum of nums[i−1]∗give+(∑ k=1 to give ).

TC : o(nlogn)
SC : o(1)
 */
public class MinimumIncrementToMakeArrayUnique {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,2,1,7};
        System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUniqueV1(nums));
    }

    public int minIncrementForUniqueV1(int[] nums) {
        Arrays.sort(nums);
        int minIncrement =0;

        for(int i=1; i<nums.length;i++){
            if(nums[i]<= nums[i-1]){
                int increment = nums[i-1] +1 - nums[i];
                minIncrement += increment;
                nums[i] = nums[i-1]+1;
            }
        }
        return minIncrement;
    }
    public int minIncrementForUniqueV2(int[] nums) {
        Arrays.sort(nums);
        int moves =0, taken =0;

        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                taken++;
                moves-=nums[i];
            } else{
                int give = Math.min(taken, nums[i]- nums[i-1]-1);
                moves+= give*(give+1)/2 + give*nums[i-1];
                taken-=give;
            }
        }

        if(nums.length>0){
            moves+= taken*(taken+1)/2 + taken*nums[nums.length-1];
        }

        return moves;
    }
}
