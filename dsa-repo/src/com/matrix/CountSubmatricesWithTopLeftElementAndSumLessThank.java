package com.matrix;
/*
3070. Count Submatrices with Top-Left Element and Sum Less Than k

You are given a 0-indexed integer matrix grid and an integer k.

Return the number of submatrices that contain the top-left element of the grid, and have a sum less than or equal to k.



Example 1:
Input: grid = [[7,6,3],[6,6,1]], k = 18
Output: 4
Explanation: There are only 4 submatrices, shown in the image above, that contain the top-left element of grid,
and have a sum less than or equal to 18.

TC : o(mn)
SC: o(n)
 */
public class CountSubmatricesWithTopLeftElementAndSumLessThank {

    public static void main(String[] args) {
        System.out.println(new CountSubmatricesWithTopLeftElementAndSumLessThank().countSubmatrices(
                new int[][]{{7,6,3},{6,6,1}}, 18
        ));
    }
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int count =0;
        int[] cols = new int[n];
        for(int i=0;i<m;i++){
            int rowsPrefixSum = 0;
            for(int j=0;j<n;j++){
                cols[j] += grid[i][j];
                rowsPrefixSum += cols[j];
                if(rowsPrefixSum <= k){
                    count++;
                }
            }
        }
        return count;
    }
}
