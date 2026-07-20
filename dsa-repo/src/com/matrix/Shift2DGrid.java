package com.matrix;

import java.util.ArrayList;
import java.util.List;

/*
1260. Shift 2D Grid

Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.



Example 1:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]

TC : o(m*n*k)
SC: o(m*n)
 */
public class Shift2DGrid {

    public static void main(String[] args) {
        System.out.println(new Shift2DGrid().shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1));
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        while(k>0){
            int[][] res = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==m-1 && j== n-1){
                        res[0][0] = grid[m-1][n-1];
                    } else if(j== n-1){
                        res[i+1][0] = grid[i][n-1];
                    } else{
                        res[i][j+1] = grid[i][j];
                    }
                }
            }
            k--;
            grid = res;
        }

        List<List<Integer>> resultant = new ArrayList<>();
        for(int i=0;i<m;i++){
            resultant.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                resultant.get(i).add(grid[i][j]);
            }
        }
        return resultant;
    }
}
