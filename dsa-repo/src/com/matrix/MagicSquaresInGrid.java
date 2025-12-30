package com.matrix;
/*
840. Magic Squares In Grid

A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and
both diagonals all have the same sum.

Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?

Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.

Example 1:
Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
Output: 1
Explanation:
The following subgrid is a 3 x 3 magic square:

In total, there is only one magic square inside the given grid.

TC : o(m*n)
SC: o(1)
 */
public class MagicSquaresInGrid {

    public static void main(String[] args) {
        System.out.println(new MagicSquaresInGrid().numMagicSquaresInside(
                new int[][]{
                        {4,3,8,7},{9,5,1,9},{2,7,6,2}
                }
        ));
    }
    public int numMagicSquaresInside(int[][] grid) {
        int ans =0;
        int m = grid.length, n = grid[0].length;
        for(int row =0; row +2<m;row++){
            for(int col =0; col+2<n; col++){
                if(isMagicSquare(grid, row, col)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isMagicSquare(int[][] grid,int row, int col){
        // The sequences are each repeated twice to account for
        // the different possible starting points of the sequence
        // in the magic square
        String sequence = "2943816729438167";
        String sequenceReversed = "7618349276183492";

        StringBuilder border = new StringBuilder();
        int[] borderIndices = new int[]{0,1,2,5,8,7,6,3};
        for(int i: borderIndices){
            int num = grid[row+i/3][col+(i%3)];
            border.append(num);
        }

        String borderConverted = border.toString();

        // Make sure the sequence starts at one of the corners
        return (grid[row][col]%2==0 && (sequence.contains(borderConverted) ||
                sequenceReversed.contains(borderConverted)) && grid[row+1][col+1] ==5);
    }
}
