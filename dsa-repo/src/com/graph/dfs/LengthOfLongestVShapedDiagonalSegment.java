package com.graph.dfs;

import java.util.Arrays;

/*
3459. Length of Longest V-Shaped Diagonal Segment

You are given a 2D integer matrix grid of size n x m, where each element is either 0, 1, or 2.

A V-shaped diagonal segment is defined as:

The segment starts with 1.
The subsequent elements follow this infinite sequence: 2, 0, 2, 0, ....
The segment:
Starts along a diagonal direction (top-left to bottom-right, bottom-right to top-left, top-right to bottom-left, or bottom-left to top-right).
Continues the sequence in the same diagonal direction.
Makes at most one clockwise 90-degree turn to another diagonal direction while maintaining the sequence.


Return the length of the longest V-shaped diagonal segment. If no valid segment exists, return 0.



Example 1:

Input: grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]

Output: 5

Explanation:
The longest V-shaped diagonal segment has a length of 5 and follows these coordinates: (0,2) → (1,3) → (2,4), takes a 90-degree clockwise turn at (2,4), and continues as (3,3) → (4,2).

TC : o(m*n)
SC: o(m*n)

 */
public class LengthOfLongestVShapedDiagonalSegment {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestVShapedDiagonalSegment().lenOfVDiagonal(
                new int[][]{{2,2,1,2,2}, {2,0,2,2,0}, {2,0,1,1,0},{1,0,2,2,2}, {2,0,0,2,2}}
        ));
    }
    private static final int[][] DIRS = {
            { 1, 1 },
            { 1, -1 },
            { -1, -1 },
            { -1, 1 },
    };
    private int[][][][] memo;
    private int[][] grid;
    private int m, n;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n][4][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int direction = 0; direction < 4; direction++) {
                        res = Math.max(res, dfs(i, j, direction, true, 2) + 1);
                    }
                }
            }
        }
        return res;
    }

    private int dfs(int cx, int cy, int direction, boolean turn, int target) {
        int nx = cx + DIRS[direction][0];
        int ny = cy + DIRS[direction][1];
        /* If it goes beyond the boundary or the next node's value is not the target value, then return */
        if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != target) {
            return 0;
        }

        int turnInt = turn ? 1 : 0;
        if (memo[nx][ny][direction][turnInt] != -1) {
            return memo[nx][ny][direction][turnInt];
        }

        /* Continue walking in the original direction. */
        int maxStep = dfs(nx, ny, direction, turn, 2 - target);
        if (turn) {
            /* Clockwise rotate 90 degrees turn */
            maxStep = Math.max(
                    maxStep,
                    dfs(nx, ny, (direction + 1) % 4, false, 2 - target)
            );
        }
        memo[nx][ny][direction][turnInt] = maxStep + 1;
        return maxStep + 1;
    }
}
