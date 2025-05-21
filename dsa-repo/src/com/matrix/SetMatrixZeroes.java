package com.matrix;

import java.util.Arrays;

/*
73. Set Matrix Zeroes

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.



Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

TC : o(n^2)
SC: o(1)
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        new SetMatrixZeroes().setZeroes(matrix);
        Arrays.stream(matrix).forEach(a -> System.out.println(Arrays.toString(a)));
    }
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return;
        }

        boolean setFirstRowToZeroes = false;
        boolean setFirstColumnToZeroes = false;

        //check if first column needs to be set to zero
        for(int row=0;row<matrix.length;row++){
            if(matrix[row][0] == 0){
                setFirstColumnToZeroes=true;
                break;
            }
        }

        //check if first row needs to be set to zero
        for(int col=0;col<matrix[0].length;col++){
            if(matrix[0][col] == 0){
                setFirstRowToZeroes=true;
                break;
            }
        }

        //mark columns and rows to be set to zero
        for(int row=1;row<matrix.length;row++){
            for(int col=1;col<matrix[0].length;col++){
                if(matrix[row][col]==0){
                    matrix[row][0]=0;
                    matrix[0][col]=0;
                }
            }
        }

        // make rows zero
        for(int row=1;row<matrix.length;row++){
            if(matrix[row][0]==0){
                for(int col=1;col<matrix[0].length;col++){
                    matrix[row][col]=0;
                }
            }
        }

        // make columns zero
        for(int col=1;col<matrix[0].length;col++){
            if(matrix[0][col]==0){
                for(int row=1;row<matrix.length;row++){
                    matrix[row][col]=0;
                }
            }
        }

        // zero out first row (if needed)
        if(setFirstRowToZeroes){
            for(int col=0;col<matrix[0].length;col++){
                matrix[0][col]=0;
            }
        }

        // zero out first column (if needed)
        if(setFirstColumnToZeroes){
            for(int row=0;row<matrix.length;row++){
                matrix[row][0]=0;
            }
        }
    }
}
