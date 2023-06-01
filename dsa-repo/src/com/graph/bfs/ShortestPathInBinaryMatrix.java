package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
1091. Shortest Path in Binary Matrix

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no
clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e.,
(n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge
or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 2

TC : o(n)
SC: o(8) = o(1)
 */
public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0},{1,1,0},{1,1,0}
        };
        System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid));
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1)
            return -1;

        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        Queue<GPair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(new GPair(0,0,1));
        visited[0][0] = true;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                GPair cur = q.poll();
                if(cur.x == m-1 && cur.y == n-1)
                    return cur.move;
                for(int[] d : dir){
                    int x = cur.x+d[0], y = cur.y + d[1];
                    if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && grid[x][y]==0){
                        visited[x][y] = true;
                        q.offer(new GPair(x,y,cur.move+1));
                    }
                }
            }
        }
        return -1;
    }
}

class GPair {
    int x, y,move;

    public GPair(int x, int y, int m){
        this.x =x;
        this.y = y;
        this.move =m;
    }
}
