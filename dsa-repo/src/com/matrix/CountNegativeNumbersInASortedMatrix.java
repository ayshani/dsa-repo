package com.matrix;
/*
1351. Count Negative Numbers in a Sorted Matrix

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

TC : o(m+n)
SC : o(1)
 */
public class CountNegativeNumbersInASortedMatrix {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}
        };
        System.out.println(new CountNegativeNumbersInASortedMatrix().countNegatives(grid));
    }
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int row = m-1, col =0;
        int total =0;

        while(row>=0 && col<n){
            if(grid[row][col]<0)
            {
                total+= (n-col);
                row--;
            } else
                col++;
        }
        return total;
    }
}
