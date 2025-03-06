package com.array;

import java.util.Arrays;

/*
2965. Find Missing and Repeated Values

You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.



Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].

TC : o(n)
SC: o(n)

 */
public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindMissingAndRepeatedValues().findMissingAndRepeatedValues(
                new int[][]{{1,3},{2,2}}
        )));
    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] res = new int[2];
        int[] valueCount = new int[n*n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(valueCount[grid[i][j]]>0){
                    res[0] = grid[i][j];
                }
                valueCount[grid[i][j]]++;
            }
        }
        for(int i=1;i<valueCount.length;i++){
            if(valueCount[i]==0){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
