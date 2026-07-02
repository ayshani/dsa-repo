package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
3286. Find a Safe Walk Through a Grid

You are given an m x n binary matrix grid and an integer health.

You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).

You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.

Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.

Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.



Example 1:

Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1

Output: true

Explanation:

The final cell can be reached safely by walking along the gray cells below.

TC : O(mnlog(mn))
SC: o(mn)
 */
public class FindASafeWalkThroughAGrid {

    public static void main(String[] args) {
        System.out.println(new FindASafeWalkThroughAGrid().findSafeWalk(
                List.of(List.of(0,1,0,0,0), List.of(0,1,0,1,0), List.of(0,0,0,1,0)), 1
        ));
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], -1);
        }
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );
        pq.offer(new int[] { grid.get(0).get(0), 0, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0];
            int cx = cur[1];
            int cy = cur[2];
            if (dis[cx][cy] >= 0) {
                continue;
            }
            dis[cx][cy] = val;
            for (int[] d : dirs) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if (dis[nx][ny] >= 0) {
                    continue;
                }
                pq.offer(new int[] { val + grid.get(nx).get(ny), nx, ny });
            }
        }

        return dis[m - 1][n - 1] < health;
    }
}
