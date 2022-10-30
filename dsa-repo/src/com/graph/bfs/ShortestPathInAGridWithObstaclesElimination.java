package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
1293. Shortest Path in a Grid with Obstacles Elimination

You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle).
You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to
the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to
find such walk return -1.

Example 1:
Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.

TC : o(m*n*k)
SC : o(m*n*k)
*/
public class ShortestPathInAGridWithObstaclesElimination {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,1},{1,1,1},{1,0,0}};
        System.out.println(new ShortestPathInAGridWithObstaclesElimination().shortestPath(grid,1));
    }
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] visisted = new boolean[m][n][k+1];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0,k});
        int result =0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] current = q.poll();
                int x = current[0], y = current[1], obstacle = current[2];

                if(x==m-1 && y==n-1 && obstacle>=0)
                    return result;

                if(obstacle<0 || visisted[x][y][obstacle])
                    continue;

                visisted[x][y][obstacle] = true;

                if(x-1>=0)
                    q.offer(new int[]{x-1,y,obstacle-grid[x-1][y]});
                if(y-1>=0)
                    q.offer(new int[]{x,y-1,obstacle-grid[x][y-1]});
                if(x+1<m)
                    q.offer(new int[]{x+1,y,obstacle-grid[x+1][y]});
                if(y+1<n)
                    q.offer(new int[]{x,y+1,obstacle-grid[x][y+1]});
            }
            result++;
        }

        return -1;
    }
}
