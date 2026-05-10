package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1914. Cyclically Rotating a Grid

You are given an m x n integer matrix grid​​​, where m and n are both even integers, and an integer k.

The matrix is composed of several layers, which is shown in the below image, where each color is its own layer:



A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix. To cyclically rotate a layer once, each element in the layer will take the place of the adjacent element in the counter-clockwise direction. An example rotation is shown below:


Return the matrix after applying k cyclic rotations to it.



Example 1:


Input: grid = [[40,10],[30,20]], k = 1
Output: [[10,20],[40,30]]
Explanation: The figures above represent the grid at every state.

 */
public class CyclicallyRotatingAGrid {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new CyclicallyRotatingAGrid().rotateGrid(
                new int[][]{
                        {40, 10}, {30, 20}
                }, 1
        )));
    }
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int nlayer = Math.min(m / 2, n / 2); // level count
        // enumerate each layer counterclockwise starting from the top-left corner
        for (int layer = 0; layer < nlayer; ++layer) {
            List<Integer> r = new ArrayList<>();
            List<Integer> c = new ArrayList<>();
            List<Integer> val = new ArrayList<>(); // each element's row index, column index, and value
            for (int i = layer; i < m - layer - 1; ++i) { // left
                r.add(i);
                c.add(layer);
                val.add(grid[i][layer]);
            }
            for (int j = layer; j < n - layer - 1; ++j) { // down
                r.add(m - layer - 1);
                c.add(j);
                val.add(grid[m - layer - 1][j]);
            }
            for (int i = m - layer - 1; i > layer; --i) { // right
                r.add(i);
                c.add(n - layer - 1);
                val.add(grid[i][n - layer - 1]);
            }
            for (int j = n - layer - 1; j > layer; --j) { // up
                r.add(layer);
                c.add(j);
                val.add(grid[layer][j]);
            }
            int total = val.size(); // total number of elements in each layer
            int kk = k % total; // equivalent number of rotations
            // find the value at each index after rotation
            for (int i = 0; i < total; ++i) {
                int idx = (i + total - kk) % total; // the index corresponding to the value after rotation
                grid[r.get(i)][c.get(i)] = val.get(idx);
            }
        }
        return grid;
    }
}
