package com.matrix;

import java.util.ArrayList;
import java.util.List;

/*
54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1 :
1   2  3  4
5   6  7  8
9  10 11 12


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix= new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };

        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0)
            return result;

        int top=0, left =0,right = matrix[0].length-1,down = matrix.length-1;

        while(top<=down && left<=right){
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=down;i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(top<=down){
                for(int i=right;i>=left;i--){
                    result.add(matrix[down][i]);
                }
            }
            down--;
            if(left<=right){
                for(int i=down;i>=top;i--){
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }

        return result;
    }
}
