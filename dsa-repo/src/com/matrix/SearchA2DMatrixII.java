package com.matrix;
/*
 * 240. Search a 2D Matrix II
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:
 *  - Integers in each row are sorted in ascending from left to right.
 *  - Integers in each column are sorted in ascending from top to bottom.
 *
 *  Example 1:
 *  1  4   7 11 15
 *  2  5   8 12 19
 *  3  6   9 16 22
 *  10 13 14 17 24
 *  18 21 23 26 30
 *
 *  target = 5
 *
 *  Output: true
 *
 *  Logic
 *  --------
 *
 *  We have to start from one index of which in up to down, all are bigger and left-right, all are smaller.
 *  Hence choose [0][n-1] position to start.
 *  Iterate over till col>= 0 and row<n
 *  	check if target == matrix[i][j]
 *  			- yes : return true
 *  			- target bigger : row++
 *  			- target smaller : col--
 *
 *  TC : O(N)
 *  SC : O(1)
 *
 */
public class SearchA2DMatrixII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = new int[][] {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 5 ;
        SearchA2DMatrixII obj = new SearchA2DMatrixII();
        System.out.println(obj.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix== null || matrix.length<1 || matrix[0].length<1)
            return false;
        int i= 0, j = matrix[0].length-1;

        while(i<=matrix.length-1 && j>=0){
            if(target==matrix[i][j])
                return true;
            else if(target> matrix[i][j])
                i++;
            else if(target<matrix[i][j])
                j--;
        }

        return false;
    }

}

