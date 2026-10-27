package com.string.manipulation;

import java.util.Arrays;

/*
3963. Create Grid With Exactly One Path

You are given two integers m and n, representing the number of rows and columns of a grid.

Construct any m x n grid consisting only of the characters '.' and '#', where:

'.' represents a free cell.
'#' represents an obstacle cell.
A valid path is a sequence of free cells that:

Starts at the top-left cell (0, 0).
Ends at the bottom-right cell (m - 1, n - 1).
Moves only:
Right, from (i, j) to (i, j + 1), or
Down, from (i, j) to (i + 1, j).
Return any grid such that there is exactly one valid path from the top-left cell to the bottom-right cell.



Example 1:

Input: m = 2, n = 3

Output: ["..#","#.."]

Explanation:

The only valid path is: (0,0) → (0,1) → (1,1) → (1,2)

TC : o(mn)
SC : o(n)
 */
public class CreateGridWithExactlyOnePath {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CreateGridWithExactlyOnePath().createGrid(2,3)));
    }
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        grid[0]= ".".repeat(n);
        String row = "#".repeat(n-1)+".";
        for(int i=1;i<m;i++){
            grid[i]= row;
        }
        return grid;
    }
}
