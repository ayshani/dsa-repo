package com.graph.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
2290. Minimum Obstacle Removal to Reach Corner

You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:

0 represents an empty cell,
1 represents an obstacle that may be removed.
You can move up, down, left, or right from and to an empty cell.

Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0)
to the lower right corner (m - 1, n - 1).

Example 1:
Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
Output: 2
Explanation: We can remove the obstacles at (0, 1) and (0, 2) to create a path from (0, 0) to (2, 2).
It can be shown that we need to remove at least 2 obstacles, so we return 2.
Note that there may be other ways to remove 2 obstacles to create a path.

Algorithn
-----------
1. Initialize dist with Integer.MAX_VALUE and use dist[i][j]
to indicate the currently minimum obstacles need to remove to reach (i, j);

2. Starting from (0, 0), put [grid[0][0], 0, 0] into a Deque to begin BFS, and use dist value to avoid duplicates;

3. Whenever encountering an empty cell neighbor, the dist value is same and
hence we can put it to the front of the Deque; Otherwise, put it to the back of the Deque;

4. Repeat 2. and 3. and update dist accordingly till the Deque is empty;
5. return dist[m - 1][n - 1] as solution.

TC : o(m*n)
SC : o(m*n)
 */
public class MinimumObstacleRemovalToReachCorner {

    int[] d = new int[]{0,1,0,-1,0};
    int M = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,1}, {1,1,0},{1,1,0}
        };
        System.out.println(new MinimumObstacleRemovalToReachCorner().minimumObstacles(grid));
    }
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dist = new int[m][n];

        for(int[] di : dist){
            Arrays.fill(di,M);
        }

        dist[0][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[3]);

        while(!q.isEmpty()){
            int[] current = q.poll();

            int obstacle = current[0], x = current[1], y = current[2];
            for(int k=0;k<4;k++){
                int i = x+d[k], j = y+d[k+1];
                if(0<=i && i<m && 0<=j && j<n && dist[i][j]==M){
                    if(grid[i][j]==1){
                        dist[i][j] = obstacle+1;
                        q.offer(new int[]{obstacle+1,i,j});
                    } else{
                        dist[i][j] = obstacle;
                        q.offerFirst(new int[]{obstacle,i,j});
                    }
                }
            }
        }

        return dist[m-1][n-1];
    }
}
