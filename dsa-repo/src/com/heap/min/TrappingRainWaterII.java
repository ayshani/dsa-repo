package com.heap.min;

import java.util.PriorityQueue;

/*
407. Trapping Rain Water II
https://leetcode.com/problems/trapping-rain-water-ii/

Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map,
return the volume of water it can trap after raining.

Example 1:
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.

TC : o(nlogn)
SC : o(n)
 */
public class TrappingRainWaterII {
    public static void main(String[] args) {
        int[][] h = new int[][]{
                {1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}
        };

        System.out.println(new TrappingRainWaterII().trapRainWater(h));
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap== null || heightMap.length==0 || heightMap[0].length==0)
            return 0;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height-b.height);

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        // Initially, add all the Cells which are on borders to the queue.
        for(int i=0;i<m;i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.offer(new Cell(i,0,heightMap[i][0]));
            pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
        }

        for(int i=0;i<n;i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            pq.offer(new Cell(0,i,heightMap[0][i]));
            pq.offer(new Cell(m-1,i,heightMap[m-1][i]));
        }

        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its
        // height as its height plus the water trapped
        //  add all its neighbors to the queue.

        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int totalTrappedWater=0;
        while(!pq.isEmpty()){
            Cell currentCell = pq.poll();
            for(int[] d: dir){
                int newRow = currentCell.row+d[0];
                int newCol = currentCell.col + d[1];

                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    totalTrappedWater+= Math.max(0, currentCell.height - heightMap[newRow][newCol]);
                    pq.offer(new Cell(newRow,newCol, Math.max(currentCell.height, heightMap[newRow][newCol])));
                }
            }
        }

        return totalTrappedWater;
    }
}

class Cell{
    int row,col,height;

    Cell(int row, int col , int h){
        this.row = row;
        this.col = col;
        this.height = h;
    }
}