package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.PriorityQueue;

/*
778. Swim in Rising Water

You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.

You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).



Example 1:
Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.

TC: o(v*elogv)
SC: o(m*n)
 */
public class SwimInRisingWater {

    public static void main(String[] args) {
        System.out.println(new SwimInRisingWater().swimInWater(
                new int[][]{
                        {0,2},
                        {1,3}
                }
        ));
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        boolean[][] visited = new boolean[n][n];
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        pq.offer(new int[]{0,0,grid[0][0]});
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int i = info[0], j = info[1], maxWeight = info[2];

            for(int[] d: dir){
                int ix = i+d[0], iy = j + d[1];
                if(ix<0 || ix>=n || iy<0 || iy>=n)
                    continue;
                if(!visited[ix][iy]){
                    visited[ix][iy]= true;
                    int max = Math.max(maxWeight, grid[ix][iy]);
                    if(ix==n-1 && iy==n-1)
                        return max;
                    pq.offer(new int[]{ix,iy,max});
                }
            }
        }
        return 0;
    }
}
