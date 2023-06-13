package com.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
2352. Equal Row and Column Pairs

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column
cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

Example 1:
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]

Complexity Analysis
Let n×n times nn×n be the size of grid.

Time complexity: O(n^2)
We iterate over each row and column only once, converting one array of length nnn into a hashable object takes O(n)
time. Operations like adding or checking on hash map take O(1) time.

Space complexity: O(n^2)
We store each row of the grid in the hash map, in the worst-case scenario, row_counter might contains
n distinct rows of length n.
 */
public class EqualRowAndColumnPairs {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {3,2,1},{1,7,6},{2,7,7}
        };
        System.out.println(new EqualRowAndColumnPairs().equalPairs(grid));
    }
    public int equalPairs(int[][] grid) {
        int count =0;
        int n = grid.length;

        // Keep track of the frequency of each row.
        Map<String, Integer> map = new HashMap<>();
        for(int[] row : grid){
            String rowString = Arrays.toString(row);
            map.put(rowString, map.getOrDefault(rowString,0)+1);
        }

        // Add up the frequency of each column in map.
        for(int col =0;col<n;col++){
            int[] ar = new int[n];
            for(int row =0;row<n;row++){
                ar[row] = grid[row][col];
            }

            count += map.getOrDefault(Arrays.toString(ar),0);
        }

        return count;
    }
}
