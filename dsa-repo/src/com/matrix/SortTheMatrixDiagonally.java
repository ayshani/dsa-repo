package com.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
1329. Sort the Matrix Diagonally

A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or
leftmost column and going in the bottom-right direction until reaching the matrix's end.
For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix,
includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order
and return the resulting matrix.

Example 1:

Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
        3  3  1  1
        2  2  1  2
        1  1  1  2


Output: [[1,1,1,1],
        [1,2,2,2],
        [1,2,3,3]]

Explanation
A[i][j] on the same diagonal have same value of i - j
For each diagonal,
put its elements together, sort, and set them back.


Complexity
Time O(MNlogD), where D is the length of diagonal with D = min(M,N).
Space O(MN)
 */
public class SortTheMatrixDiagonally {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2}
        };

        int[][] res = new SortTheMatrixDiagonally().diagonalSort(mat);

        Arrays.stream(mat).forEach(e -> {Arrays.stream(e).forEach(ele -> {System.out.print(ele+" ");}); System.out.println();});
    }
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> pq = new HashMap<>();
        int n = mat.length, m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pq.putIfAbsent(i-j, new PriorityQueue<Integer>());
                pq.get(i-j).offer(mat[i][j]);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = pq.get(i-j).poll();
            }
        }

        return mat;
    }
}
