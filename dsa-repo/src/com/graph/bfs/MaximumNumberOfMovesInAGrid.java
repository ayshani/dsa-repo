package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
2684. Maximum Number of Moves in a Grid

You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and
(row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the
current cell.
Return the maximum number of moves that you can perform.



Example 1:

Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.

TC : o(m*n)
SC: o(m*n)
 */
public class MaximumNumberOfMovesInAGrid {

    // The three possible directions for the next column.
    private final int[] dirs = { -1, 0, 1 };

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfMovesInAGrid().maxMoves(
                new int[][]{
                        {2,4,3,5},
                        {5,4,9,3},
                        {3,4,2,11},
                        {10,9,13,15}
                }
        ));
    }
    public int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;


        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[M][N];

        // Enqueue the cells in the first column.
        for (int i = 0; i < M; i++) {
            vis[i][0] = true;
            q.offer(new int[] { i, 0, 0 });
        }

        int maxMoves = 0;
        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int[] v = q.poll();

                // Current cell with the number of moves made so far.
                int row = v[0], col = v[1], count = v[2];

                maxMoves = Math.max(maxMoves, count);

                for (int dir : dirs) {
                    // Next cell after the move.
                    int newRow = row + dir, newCol = col + 1;

                    // If the next cell isn't visited yet and is greater than
                    // the current cell value, add it to the queue with the
                    // incremented move count.
                    if (
                            newRow >= 0 &&
                                    newCol >= 0 &&
                                    newRow < M &&
                                    newCol < N &&
                                    !vis[newRow][newCol] &&
                                    grid[row][col] < grid[newRow][newCol]
                    ) {
                        vis[newRow][newCol] = true;
                        q.offer(new int[] { newRow, newCol, count + 1 });
                    }
                }
            }
        }

        return maxMoves;
    }
}
