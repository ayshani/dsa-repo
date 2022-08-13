package com.matrix;

import java.util.HashSet;
import java.util.Set;

/*
2133. Check if Every Row and Column Contains All Numbers

An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.
Example 1:
Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.

TC : o(n^2)
SC : o(n+n)
 */
public class CheckIfEveryRowAndColumnContainsAllNumbers {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},{3,1,2},{2,3,1}
        };

        System.out.println(new CheckIfEveryRowAndColumnContainsAllNumbers().checkValid(matrix));
    }
    public boolean checkValid(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();

            for(int j=0;j<matrix[0].length;j++){
                if(!row.add(matrix[i][j]) || !col.add(matrix[j][i]))
                    return false;
            }
        }

        return true;
    }
}
