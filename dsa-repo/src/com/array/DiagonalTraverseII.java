package com.array;

import java.util.*;

/*
1424. Diagonal Traverse II

Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.

Eg :1
Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

TC : o(n)
SC: o(n)
 */
public class DiagonalTraverseII {

    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(List.of(1,2,3), List.of(4,5,6), List.of(7,8,9));
        System.out.println(Arrays.toString(new DiagonalTraverseII().findDiagonalOrder(nums)));
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n=0;
        for(int row = nums.size()-1;row>=0;row--){
            for(int col =0; col<nums.get(row).size(); col++){
                int diagonal = row + col;
                map.computeIfAbsent(diagonal, value -> new ArrayList<>())
                        .add(nums.get(row).get(col));
                n++;
            }
        }
        int[] ans = new int[n];
        int index =0, cur =0;
        while(map.containsKey(cur)){
            for(int num : map.get(cur)){
                ans[index++] = num;
            }
            cur++;
        }
        return ans;
    }
}
