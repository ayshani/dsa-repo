package com.matrix;
/*
 * 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

TC : O(M+N)
SC : 1
*
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        int target = 3;
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, target));

    }

    public boolean searchMatrix(int[][] matrix, int target) {


        int m = matrix.length;
        int n = matrix[0].length;

        int i=m-1,j=0;

        while(i>=0 && j<n){
            if(target == matrix[i][j])
                return true;
            else if(target> matrix[i][j])
                j++;
            else
                i--;
        }

        return false;
    }
}

