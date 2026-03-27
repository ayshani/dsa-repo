package com.matrix;
/*
2946. Matrix Similarity After Cyclic Shifts

You are given an m x n integer matrix mat and an integer k. The matrix rows are 0-indexed.

The following proccess happens k times:

Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.
Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.
Return true if the final modified matrix after k steps is identical to the original matrix, and false otherwise.



Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4

Output: false

Explanation:

In each step left shift is applied to rows 0 and 2 (even indices), and right shift to row 1 (odd index).


TC : o(mn)
SC: o(mn)
 */
public class MatrixSimilarityAfterCyclicShifts {

    public static void main(String[] args) {
        System.out.println(new MatrixSimilarityAfterCyclicShifts().areSimilar(
                new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 4
        ));
    }
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length, count =0;
        if(k==n)
            return true;
        if(k!=n)
            k = k%n;
        for(int i=0;i<mat.length;i++){
            int[] temp = new int[n];
            int index =0;
            for( int j= n-k;j<n;j++){
                temp[index++] = mat[i][j];
            }
            for(int j=0;j<n-k;j++){
                temp[index++] = mat[i][j];
            }
            boolean flag = true;
            for(int j=0;j<n;j++){
                if(temp[j]!=mat[i][j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count==mat.length;
    }
}
