package com.array;

import java.util.HashSet;
import java.util.Set;

/*
2206. Divide Array Into Equal Pairs

You are given an integer array nums consisting of 2 * n integers.

You need to divide nums into n pairs such that:

Each element belongs to exactly one pair.
The elements present in a pair are equal.
Return true if nums can be divided into n pairs, otherwise return false.

Example 1:

Input: nums = [3,2,3,2,2,2]
Output: true
Explanation:
There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.


 */
public class DivideArrayIntoEqualPairs {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,2,2,2};
        System.out.println(new DivideArrayIntoEqualPairs().divideArray(nums));
    }
    public boolean divideArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num))
                set.remove(num);
        }
        return set.isEmpty();
    }
}
