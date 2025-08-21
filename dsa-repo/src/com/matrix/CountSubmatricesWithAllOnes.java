package com.matrix;
/*
1504. Count Submatrices With All Ones

Given an m x n binary matrix mat, return the number of submatrices that have all ones.

Example 1:
Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
Output: 13
Explanation:
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2.
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.

TC : o(m^2 * n)
SC: o(m*n)
 */
public class CountSubmatricesWithAllOnes {

    public static void main(String[] args) {
        System.out.println(new CountSubmatricesWithAllOnes().numSubmat(new int[][]{
                {1,0,1},{1,1,0},{1,1,0}
        }));
    }
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int res =0;
        int[][] row = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    row[i][j] = mat[i][j];
                } else{
                    row[i][j] = mat[i][j] == 0 ? 0: row[i][j-1] +1;
                }
                int cur = row[i][j];
                for(int k= i;k>=0;k--){
                    cur = Math.min(cur, row[k][j]);
                    if(cur==0){
                        break;
                    }
                    res += cur;
                }
            }
        }
        return res;
    }
}
