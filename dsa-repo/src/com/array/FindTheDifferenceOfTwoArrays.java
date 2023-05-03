package com.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
2215. Find the Difference of Two Arrays

Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.



Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1
and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4
and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].

TC: o(n)
SC: o(n)
 */
public class FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3}, num2 = new int[]{2,4,6};

        System.out.println(new FindTheDifferenceOfTwoArrays().findDifference(num1,num2));
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();

        for(int num : nums1){
            set1.add(num);
        }

        for(int num : nums2){
            set2.add(num);
        }

        for(int num : nums1){
            if(set2.contains(num))
                set2.remove(num);
        }

        for(int num : nums2){
            if(set1.contains(num))
                set1.remove(num);
        }

        result.add(new ArrayList<>(set1));
        result.add(new ArrayList<>(set2));
        return result;
    }
}
