package com.matrix;
/*
3212. Count Submatrices With Equal Frequency of X and Y

Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:

grid[0][0]
an equal frequency of 'X' and 'Y'.
at least one 'X'.


Example 1:

Input: grid = [["X","Y","."],["Y",".","."]]

Output: 3

TC : o(mn)
SC: o(mn)
 */
public class CountSubmatricesWithEqualFrequencyOfXAndY {

    public static void main(String[] args) {
        System.out.println(new CountSubmatricesWithEqualFrequencyOfXAndY().numberOfSubmatrices(
                new char[][]{
                        {'X','Y','.'},
                        {'Y','.','.'}
                }
        ));
    }
    public int numberOfSubmatrices(char[][] A) {
        int n = A.length, m = A[0].length, res = 0;
        int[][] X = new int[n + 1][m + 1], Y = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                X[i + 1][j + 1] = X[i][j + 1] + X[i + 1][j] - X[i][j] + (A[i][j] == 'X' ? 1 : 0);
                Y[i + 1][j + 1] = Y[i][j + 1] + Y[i + 1][j] - Y[i][j] + (A[i][j] == 'Y' ? 1 : 0);
                if (X[i + 1][j + 1] == Y[i + 1][j + 1] && X[i + 1][j + 1] > 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
