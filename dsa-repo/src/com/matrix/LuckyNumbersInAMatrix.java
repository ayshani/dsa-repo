package com.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1380. Lucky Numbers in a Matrix

Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.



Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.


 */
public class LuckyNumbersInAMatrix {

    public static void main(String[] args) {
        System.out.println(new LuckyNumbersInAMatrix().luckyNumbers(
                new int[][]{
                        {3,7,8},
                        {9,11,13},
                        {15,16,17}
                }
        ));
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[] row = new int[m], col = new int[n];
        Arrays.fill(row, Integer.MAX_VALUE);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]==col[j]){
                    res.add(row[i]);
                    break;
                }
            }
        }
        return res;
    }
}
