package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
1631. Path With Minimum Effort

You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1:
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

TC : o(ElogV)
SC: o(m*n) + o(ElogE)
 */
public class PathWithMinimumEffort {

    public static void main(String[] args) {
        int[][] heights = new int[][]{
                {1,2,2},{3,8,2},{5,3,5}
        };
        System.out.println(new PathWithMinimumEffort().minimumEffortPath(heights));
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        if(n==1 && m==1)
            return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[2]-b[2]);
        pq.offer(new int[]{0,0,0});
        int[][] distance = new int[m][n];
        for(int[] d:distance){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        distance[0][0] =0;
        boolean[][] visited = new boolean[m][n];
        int[] direction = new int[]{0,1,0,-1,0};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]][cur[1]])
                continue;
            if(cur[0]== m-1 && cur[1]==n-1)
                return cur[2];
            visited[cur[0]][cur[1]] = true;

            for(int i=0;i<4;i++){
                int nextX = cur[0]+ direction[i], nextY = cur[1]+ direction[i+1];

                if(nextX<0 || nextX>=m || nextY<0 || nextY>=n|| visited[nextX][nextY])
                    continue;
                int nextWeight = Math.max(cur[2],
                        Math.abs(heights[cur[0]][cur[1]] - heights[nextX][nextY]));

                if(nextWeight< distance[nextX][nextY]){
                    distance[nextX][nextY] = nextWeight;
                    pq.offer(new int[]{nextX, nextY, distance[nextX][nextY]});
                }
            }

        }
        return distance[m-1][n-1];
    }
}
