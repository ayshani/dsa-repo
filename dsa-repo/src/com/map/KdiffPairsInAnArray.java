package com.map;

import java.util.HashMap;
import java.util.Map;

/*
532. K-diff Pairs in an Array

Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
nums[i] - nums[j] == k
Notice that |val| denotes the absolute value of val.



Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

Logic
------
First we will create map for counting frequencies of each element in the array.

Now we have 2 cases over here as
-->a) if k == 0 it means we need to count frequency of the same element by using map.get(i) method.
-->b) we need to take counter approach for every element by adding k everytime and check whether that
      element is present in map or not.

Instead of iterating through array, we will iterate through map.keySet() for getting unique elements.

TC : o(n)
SC : o(n)
 */
public class KdiffPairsInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(new KdiffPairsInAnArray().findPairs(nums,1));
    }
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int result =0;
        for(int num : map.keySet()){
            if((k>0 && map.containsKey(num+k)) || (k==0 && map.get(num)>1)){
                result++;
            }
        }

        return result;
    }
}
