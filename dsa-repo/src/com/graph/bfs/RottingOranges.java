package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
TC : o(n*n)
SC: o(n)
 */
public class RottingOranges {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {2,1,1},{1,1,0},{0,1,1}
        };
        System.out.println(new RottingOranges().orangesRotting(mat));
    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int m = grid.length, n = grid[0].length, countFresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                } else if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }

        if(countFresh==0)
            return 0;
        int count =0;
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] cur = q.poll();
                for(int[] d : dir){
                    int x = cur[0]+d[0], y = cur[1]+d[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        grid[x][y] = 2;
                        q.offer(new int[]{x,y});
                        countFresh--;
                    }
                }
            }
            count++;
        }
        return countFresh==0 ? count-1 : -1;
    }

}
