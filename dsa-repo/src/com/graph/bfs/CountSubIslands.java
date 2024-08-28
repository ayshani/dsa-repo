package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
1905. Count Sub Islands

You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's
(representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical).
Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that
make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.


Example 1:
Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]],
grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.

TC : o(m*n)
SC: o(m*n)
 */
public class CountSubIslands {

    public static void main(String[] args) {
        System.out.println(new CountSubIslands().countSubIslands(
                new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}},
                new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}
        ));
    }
    // Directions in which we can traverse inside the grids.
    private final int[][] directions = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
    };

    // Helper method to check if the cell at the position (x, y) in the 'grid'
    // is a land cell.
    private boolean isCellLand(int x, int y, int[][] grid) {
        return grid[x][y] == 1;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;

        boolean[][] visited = new boolean[totalRows][totalCols];
        int subIslandCounts = 0;

        // Iterate on each cell in 'grid2'
        for (int x = 0; x < totalRows; ++x) {
            for (int y = 0; y < totalCols; ++y) {
                if (
                        !visited[x][y] &&
                                isCellLand(x, y, grid2) &&
                                isSubIsland(x, y, grid1, grid2, visited)
                ) {
                    subIslandCounts += 1;
                }
            }
        }

        // Return total count of sub-islands.
        return subIslandCounts;
    }

    private boolean isSubIsland(
            int x,
            int y,
            int[][] grid1,
            int[][] grid2,
            boolean[][] visited
    ) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;

        boolean isSubIsland = true;

        Queue<int[]> pendingCells = new LinkedList<>();

        pendingCells.offer(new int[] { x, y });
        visited[x][y] = true;

        while (!pendingCells.isEmpty()) {
            int[] curr = pendingCells.poll();
            int currX = curr[0];
            int currY = curr[1];

            // If the current position cell is not a land cell in 'grid1',
            // then the current island can't be a sub-island.
            if (!isCellLand(currX, currY, grid1)) {
                isSubIsland = false;
            }

            for (int[] direction : directions) {
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];
                if (
                        nextX >= 0 &&
                                nextY >= 0 &&
                                nextX < totalRows &&
                                nextY < totalCols &&
                                !visited[nextX][nextY] &&
                                isCellLand(nextX, nextY, grid2)
                ) {
                    // Push the next cell in the queue and mark it as visited.
                    pendingCells.offer(new int[] { nextX, nextY });
                    visited[nextX][nextY] = true;
                }

            }

        }
        return isSubIsland;

    }
}
