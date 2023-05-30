package com.binarysearch;

import java.util.Arrays;

/*
1901. Find a Peak Element II

A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to
the left, right, top, and bottom.
Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j]
and return the length 2 array [i,j].
You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

Example 1:
Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

TC : o(m*logn)
SC: o(1)
 */
public class FindAPeakElementII {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,4},{3,2}
        };
        System.out.println(Arrays.toString(new FindAPeakElementII().findPeakGrid(mat)));
    }
    public int[] findPeakGrid(int[][] mat) {
        int startCol =0, endCol = mat[0].length-1;

        while(startCol<=endCol){
            // get mid column
            int midCol = startCol + (endCol - startCol)/2;
            // keep row who has global Peak element
            int ansRow =0;

            // find max element in mid column
            for(int row = 0; row<mat.length;row++){
                ansRow = mat[row][midCol] >= mat[ansRow][midCol] ? row : ansRow;
            }

            // find next search space either left or right
            boolean toLeft = midCol-1>=startCol && mat[ansRow][midCol-1]> mat[ansRow][midCol];
            boolean toRight = midCol+1<=endCol && mat[ansRow][midCol+1]> mat[ansRow][midCol];
            // if both   toLeft and toRight are falsei.e. we are at peak element
            if(!toLeft && !toRight){
                return new int[]{ansRow, midCol};
            }
            else if(toRight)
                startCol = midCol+1;
            else
                endCol = midCol;
        }

        return new int[]{-1,-1};
    }
}
