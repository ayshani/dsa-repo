package com.prefixsum;

import java.util.HashMap;
import java.util.Map;

/*
1074. Number of Submatrices That Sum to Target

Given a matrix and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate
that is different: for example, if x1 != x1'.

Example 1:
Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.

TC : o(m^2*n)
SC: o(m*n)
 */
public class NumberOfSubmatricesThatSumToTarget {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0,1,0},{1,1,1},{0,1,0}
        };
        System.out.println(new NumberOfSubmatricesThatSumToTarget().numSubmatrixSumTarget(mat,0));
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count=0, sum =0;
        int m = matrix.length, n = matrix[0].length;
        // create prefix sum
        int[][] prefixSum = new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                prefixSum[i][j]= prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        Map<Integer,Integer> mp =  new HashMap<>();
        // fix one row then compute prefix sum from that row downwards
        for(int r1=1;r1<m+1;++r1){
            for(int r2=r1;r2<m+1;++r2){
                mp.clear();
                mp.put(0,1);
                // treat it as 1D prefix sum computation
                for(int col=1; col<n+1;++col){
                    sum = prefixSum[r2][col] - prefixSum[r1-1][col];
                    count += mp.getOrDefault((sum-target),0);
                    mp.put(sum, mp.getOrDefault((sum),0)+1);
                }
            }
        }
        return count;
    }
}
