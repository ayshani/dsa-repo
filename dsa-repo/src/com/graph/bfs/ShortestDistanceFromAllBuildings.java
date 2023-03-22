package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*317. Shortest Distance from All Buildings

You are given an m x n grid grid of values 0, 1, or 2, where:

each 0 marks an empty land that you can pass by freely,
each 1 marks a building that you cannot pass through, and
each 2 marks an obstacle that you cannot pass through.
You want to build a house on an empty land that reaches all buildings in the shortest total travel distance.
You can only move up, down, left, and right.

Return the shortest travel distance for such a house. If it is not possible to build such a house according to
the above rules, return -1.

The total travel distance is the sum of the distances between the houses of the friends and the meeting point.

The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

Example 1:

Input: grid = [[1,0,2,0,1],
               [0,0,0,0,0],
               [0,0,1,0,0]]
Output: 7
Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
So return 7.


TC: o(m*n*totalspots)
SC: o(m*n)
 */
public class ShortestDistanceFromAllBuildings {

    int[] ds = new int[]{0,1,0,-1,0};

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        System.out.println(new ShortestDistanceFromAllBuildings().shortestDistance(grid));
    }
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dist = new int[m][n];
        int[][] reach = new int[m][n];
        int buildingNumber =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    bfs(grid, i,j, m, n, dist, reach);
                    buildingNumber++;
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(reach[i][j]==buildingNumber && grid[i][j]==0){
                    minDistance = Math.min(minDistance, dist[i][j]);
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void bfs(int[][] grid, int i, int j, int m, int n, int[][] dist,  int[][] reach){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        boolean[][] visited = new boolean[m][n];
        int level=1;
        while(!q.isEmpty()){

            int size = q.size();
            while(size-->0){
                int[] cur = q.poll();
                for(int d = 0;d<4;d++){
                    int nexti = cur[0]+ ds[d], nextj = cur[1]+ ds[d+1];

                    if(nexti>=0 && nexti<m && nextj>=0 && nextj<n && grid[nexti][nextj]==0
                            && !visited[nexti][nextj]){
                        dist[nexti][nextj] += level;
                        reach[nexti][nextj]++;
                        visited[nexti][nextj] = true;
                        q.offer(new int[]{nexti, nextj});
                    }
                }
            }
            level++;
        }
    }
}
