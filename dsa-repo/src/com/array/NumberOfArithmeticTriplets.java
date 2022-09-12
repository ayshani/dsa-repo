package com.array;

import java.util.HashSet;
import java.util.Set;

/*
2367. Number of Arithmetic Triplets

You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff.
A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

i < j < k,
nums[j] - nums[i] == diff, and
nums[k] - nums[j] == diff.
Return the number of unique arithmetic triplets.

Example 1:

Input: nums = [0,1,4,6,7,10], diff = 3
Output: 2
Explanation:
(1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
(2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.

Explanation:

You are looking for a triplet of numbers that have:

indexes i < j < k
nums[j] - nums[i] == diff and nums[k] - nums[j] == diff
Example: [1,3,5] diff = 2

So for example when you get to value 5 you check backward with the hashmap.
you know 5-diff = 3, so you check if you visited 3.
you know 3-diff = 1, or 5-2*diff = 1. So you check if you visited 1.

This works because the array is sorted.

TC : o(n)
SC : o(n)
 */
public class NumberOfArithmeticTriplets {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,4,6,7,10};
        int diff = 3;
        System.out.println(new NumberOfArithmeticTriplets().arithmeticTriplets(nums,diff));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int count =0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num-diff) && set.contains(num-2*diff)){
                count++;
            }
            set.add(num);
        }

        return count;
    }
}
