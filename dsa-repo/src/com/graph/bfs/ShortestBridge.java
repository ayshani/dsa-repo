package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
934. Shortest Bridge

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's.
There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.



Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

Explanation
-----------
1. mark first  1 i.e. first island and its surrounding 1s to 2.
2. put those marked cells in queue.
3. in queue, mark all the surrounding cells of 2 to 2 if the current cell=0
   and per each size of the queue, increase change.
4. in this way, if we reach cell=1 i.e. we reach second island, then we return the change value.

TC : o(row*column)
SC: o(total surrounding values)
 */
public class ShortestBridge {

    int[] direction = new int[]{0,-1,0,1,0};

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}
        };
        System.out.println(new ShortestBridge().shortestBridge(grid));
    }
    public int shortestBridge(int[][] grid) {
        int row = grid.length, column = grid[0].length;

        Queue<int[]> q = new LinkedList<>();


        boolean check = false;

        // change the neighbour cells of island
        for(int i=0;i<row;i++){
            for(int j=0;j<column; j++){
                if(grid[i][j]==1){
                    changeAllNeighboursOfIslans(grid, i,j, row, column);
                    check  = true;
                    break;
                }
            }

            if(check)
                break;
        }

        // Get the new islands in queue
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }


        int change =0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] cur = q.poll();
                int curX = cur[0], curY = cur[1];

                for(int i=0;i<4;i++){
                    int x = curX + direction[i];
                    int y = curY + direction[i+1];

                    if(isValid(x,y,row,column)){
                        if(grid[x][y]==0){
                            grid[x][y]=2;
                            q.offer(new int[]{x,y});
                        }

                        if(grid[x][y]==1)
                            return change;
                    }
                }
            }
            change++;
        }
        return -1;
    }

    private boolean isValid(int i,int j,int row,int column){
        return i>=0 && i<row && j>=0 && j<column;
    }
    private void changeAllNeighboursOfIslans(int[][] graph, int i, int j, int row, int column){
        if(i<0 || i>=row || j<0 || j>=column || graph[i][j] == 0 || graph[i][j]==2){
            return;
        }
        graph[i][j] = 2;

        for(int d=0;d<4;d++){
            int x = i + direction[d];
            int y = j + direction[d+1];
            changeAllNeighboursOfIslans(graph, x,y, row, column);
        }

    }
}
