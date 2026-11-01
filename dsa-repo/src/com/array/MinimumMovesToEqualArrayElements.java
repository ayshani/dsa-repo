package com.array;

import java.util.Arrays;

/*
453. Minimum Moves to Equal Array Elements

Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment n - 1 elements of the array by 1.



Example 1:

Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

TC: o(n)
SC: o(1)
 */
public class MinimumMovesToEqualArrayElements {

    public static void main(String[] args) {
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(new int[]{1,2,3}));
    }
    public int minMoves(int[] nums) {
        int low = Arrays.stream(nums).min().getAsInt();
        int moves =0;
        for(int x: nums){
            moves += x-low;
        }
        return moves;
    }
}
