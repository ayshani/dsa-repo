package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
1162. As Far from Land as Possible

Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land,
find a water cell such that its distance to the nearest land cell is maximized, and return the distance.
If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two
cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

Example 1:
input: grid = [[1,0,1],[0,0,0],[1,0,1]]
        1  0  1
        0  0  0
        1  0  1
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.

Logic
-------
This is a very typical BFS problem and very straight forward.
We start from all the lands and start exploring the water layer by layer until all the water are explored.
How many layers have we explored? That would be the answer to be returned.

TC : o(m*n)
SC : o(m*n)
 */
public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,1},{0,0,0},{1,0,1}
        };

        System.out.println(new AsFarFromLandAsPossible().maxDistance(grid));
    }
    public int maxDistance(int[][] grid) {
        int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                {
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }
        int level =-1;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){
                int[] coordinate = q.poll();
                int x = coordinate[0], y = coordinate[1];

                for(int i=0;i<4;i++){
                    int newX = x + direction[i][0];
                    int newY = y + direction[i][1];

                    if(newX>=0 && newX < m && newY >=0 && newY<n && !visited[newX][newY] & grid[newX][newY] == 0)
                    {
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX,newY});
                    }
                }
            }
            level++;
        }

        return level <=0 ? -1 : level;
    }
}
