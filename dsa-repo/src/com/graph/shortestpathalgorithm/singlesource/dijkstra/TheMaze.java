package com.graph.shortestpathalgorithm.singlesource.dijkstra;

import java.util.LinkedList;
import java.util.Queue;

/*
490. The Maze

There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1).
The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling
until hitting a wall. When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol]
and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination,
otherwise return false.

You may assume that the borders of the maze are all walls (see examples).

Example 1:
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

TC: o(v*elogv)
SC: o(m*n)
 */
public class TheMaze {

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = new int[]{0,4}, destination = new int[]{4,4};
        System.out.println(new TheMaze().hasPath(maze,start,destination));
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        int startX = start[0], startY = start[1];

        q.offer(new int[]{startX,startY});
        boolean[][] visited = new boolean[m][n];
        int[] dir = new int[]{0,1,0,-1,0};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(visited[cur[0]][cur[1]])
                continue;
            if(destination[0]==cur[0] && destination[1]==cur[1])
                return true;
            visited[cur[0]][cur[1]]  =true;
            for(int i=0;i<4;i++){
                int curX = cur[0], curY= cur[1];
                while(curX>=0 && curX<m && curY>=0 && curY<n && maze[curX][curY]==0){
                    curX+=dir[i];
                    curY+=dir[i+1];
                }

                curX-=dir[i];
                curY-=dir[i+1];

                if(!visited[curX][curY]){
                    q.offer(new int[]{curX,curY});
                }
            }
        }
        return false;
    }

}
