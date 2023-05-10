package com.matrix;

import java.util.Arrays;

/*
59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

1  2  3
8  9  4
7  6  5

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

TC : o(n*n)
SC : o(n*n)
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        int[][] matrix = new SpiralMatrixII().generateMatrix(3);

        Arrays.stream(matrix).forEach(row-> Arrays.stream(row).forEach(col -> System.out.print(col +" ")));
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int value =1;
        for(int firstRow  = 0, firstCol = 0, lastRow = n-1, lastCol = n-1; firstRow <= lastRow && firstCol <= lastCol; firstCol++){
            for(int i = firstCol; i<=lastCol; i++){
                result[firstRow][i] = value++;
            }
            firstRow++;
            for(int i= firstRow;i<=lastRow; i++){
                result[i][lastCol] = value++;
            }
            lastCol--;
            if(firstRow>lastRow || firstCol>lastCol)
                break;

            for(int i=lastCol;i>=firstCol;i--){
                result[lastRow][i] = value++;
            }

            lastRow--;
            for(int i= lastRow;i>=firstRow;i--){
                result[i][firstCol]=value++;
            }
        }

        return result;
    }

    public int[][] generateMatrixV2(int n) {
        int[][] res = new int[n][n];
        int value =1;
        int top=0,down =n-1,left=0,right=n-1;

        while(left<=right && top<=down){
            for(int i =left;i<=right;i++){
                res[top][i] =value++;
            }
            top++;
            for(int i =top;i<=down;i++){
                res[i][right] =value++;
            }
            right--;
            if(top>down || left>right)
                break;
            for(int i =right;i>=left;i--){
                res[down][i] =value++;
            }
            down--;
            for(int i =down;i>=top;i--){
                res[i][left] =value++;
            }
            left++;
        }
        return res;
    }
}
