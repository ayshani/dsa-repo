package com.graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
1765. Map of Highest Peak

You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.



Example 1:Input: isWater = [[0,1],[0,0]]
Output: [[1,0],[2,1]]
Explanation: The image shows the assigned heights of each cell.
The blue cell is the water cell, and the green cells are the land cells.

TC : o(m*n)
SC : o(m*n)
 */
public class MapOfHighestPeak {

    public static void main(String[] args) {
        int[][] res = new MapOfHighestPeak().highestPeak(new int[][]{{
            0,1},{0,0}});
        for (int[] row : res){
            System.out.println(Arrays.toString(row));
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int[] dx = { 0, 0, 1, -1 }; // Horizontal movement: right, left, down, up
        int[] dy = { 1, -1, 0, 0 }; // Vertical movement corresponding to dx

        int rows = isWater.length;
        int columns = isWater[0].length;

        // Initialize the height matrix with -1 (unprocessed cells)
        int[][] cellHeights = new int[rows][columns];
        for (int[] row : cellHeights) {
            Arrays.fill(row, -1);
        }

        // Queue to perform breadth-first search
        Queue<int[]> cellQueue = new LinkedList<>();

        // Add all water cells to the queue and set their height to 0
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                if (isWater[x][y] == 1) {
                    cellQueue.add(new int[] { x, y });
                    cellHeights[x][y] = 0;
                }
            }
        }

        int heightOfNextLayer = 1; // Initial height for land cells adjacent to water

        // Perform BFS
        while (!cellQueue.isEmpty()) {
            int layerSize = cellQueue.size();

            // Iterate through all cells in the current layer
            for (int i = 0; i < layerSize; i++) {
                int[] currentCell = cellQueue.poll();

                // Check all four possible directions for neighboring cells
                for (int d = 0; d < 4; d++) {
                    int neighborX = currentCell[0] + dx[d];
                    int neighborY = currentCell[1] + dy[d];

                    // Check if the neighbor is valid and unprocessed
                    if (
                            isValidCell(neighborX, neighborY, rows, columns) &&
                                    cellHeights[neighborX][neighborY] == -1
                    ) {
                        cellHeights[neighborX][neighborY] = heightOfNextLayer;
                        cellQueue.add(new int[] { neighborX, neighborY });
                    }
                }
            }
            heightOfNextLayer++; // Increment height for the next layer
        }

        return cellHeights;
    }

    // Function to check if a cell is within the grid boundaries
    private boolean isValidCell(int x, int y, int rows, int columns) {
        return x >= 0 && y >= 0 && x < rows && y < columns;
    }
}
