package com.prefixsum;
/*
2017. Grid Game

You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.

Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).

At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.

The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.



Example 1:Input: grid = [[2,5,4],[1,5,1]]
Output: 4
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 0 + 4 + 0 = 4 points.

TC : o(n)
SC: o(1)
 */
public class GridGame {

    public static void main(String[] args) {
        System.out.println(new GridGame().gridGame(new int[][]{{2,5,4},{1,5,1}}));
    }
    public long gridGame(int[][] grid) {
        // Calculate the sum of all the elements for the first row
        long firstRowSum = 0;
        for (int num : grid[0]) {
            firstRowSum += num;
        }
        long secondRowSum = 0;
        long minimumSum = Long.MAX_VALUE;
        for (int turnIndex = 0; turnIndex < grid[0].length; ++turnIndex) {
            firstRowSum -= grid[0][turnIndex];
            // Find the minimum maximum value out of firstRowSum and
            // secondRowSum.
            minimumSum = Math.min(
                    minimumSum,
                    Math.max(firstRowSum, secondRowSum)
            );
            secondRowSum += grid[1][turnIndex];
        }
        return minimumSum;
    }
}
