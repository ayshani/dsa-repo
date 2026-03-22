package com.matrix;
/*
1886. Determine Whether Matrix Can Be Obtained By Rotation

Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by
rotating mat in 90-degree increments, or false otherwise.

Example 1:
Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.

TC : o(n^2)
SC: o(1)
 */
public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public static void main(String[] args) {
        System.out.println(new DetermineWhetherMatrixCanBeObtainedByRotation().findRotation(
                new int[][]{{0,1},{1,0}}, new int[][]{{1,0},{0,1}}
        ));
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        //4 rotations
        for (int k = 0; k < 4; k++) {
            // rotation operation
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[n - 1 - j][i];
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                    mat[j][n - 1 - i] = temp;
                }
            }

            if (isEqual(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
