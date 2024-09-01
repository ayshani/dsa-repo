package com.matrix;

import java.util.Arrays;

/*
2022. Convert 1D Array Into 2D Array

You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked
with creating a 2-dimensional (2D) array with  m rows and n columns using all the elements from original.

The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array,
the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and
so on.

Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.

Example 1:

Input: original = [1,2,3,4], m = 2, n = 2
Output: [[1,2],[3,4]]
Explanation: The constructed 2D array should contain 2 rows and 2 columns.
The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.

TC : o(m*n)
SC : o(1)

 */
public class Convert1DArrayInto2DArray {

    public static void main(String[] args) {
        int[][] res = new Convert1DArrayInto2DArray().construct2DArray(new int[]{1,2,3,4}, 2,2);
        Arrays.stream(res).forEach(e -> System.out.println(Arrays.toString(e)));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        if(original.length != m*n){
            return new int[][]{};
        }
        int index =0;
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                res[i][j] = original[index++];
            }
        }
        return res;
    }
}
