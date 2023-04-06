package com.graph.bfs;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
505. The Maze II

There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1).
The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling
until hitting a wall. When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol]
and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop at
the destination. If the ball cannot stop at destination, return -1.

The distance is the number of empty spaces traveled by the ball from the start position (excluded)
to the destination (included).

You may assume that the borders of the maze are all walls (see examples).

Example 1:
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: 12
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
The length of the path is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

TC : o(n^2)
SC: o(n^2)

 */
public class TheMazeII {

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = new int[]{0,4}, destination = new int[]{4,4};
        System.out.println(new TheMazeII().shortestDistance(maze,start,destination));
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);

        pq.offer(new int[]{start[0], start[1],0});
        int[][] distance = new int[m][n];
        int[] dir = new int[]{0,1,0,-1,0};
        for(int[] row : distance){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(distance[cur[0]][cur[1]]<cur[2]){
                continue;
            }
            distance[cur[0]][cur[1]]=cur[2];
            for(int i=0;i<4;i++){
                int curX = cur[0], curY = cur[1], dist = cur[2];
                while(curX>=0 && curX<m && curY>=0 && curY<n && maze[curX][curY]==0){
                    curX+=dir[i];
                    curY+=dir[i+1];
                    dist++;
                }
                curX-=dir[i];
                curY-=dir[i+1];
                dist--;
                if(distance[curX][curY]>dist)
                    pq.offer(new int[]{curX,curY,dist});

            }
        }

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ?
                -1 : distance[destination[0]][destination[1]];
    }
}
