package com.graph.mst;

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


Explanation :
this one follows Dijkstra algorithm
As we are picking always a smallest edge, Once an edge is picked, we are marking it visited.
and going for 4 directions and rolling until we hit the wall. Once the wall is hit, we are going one step back.
In this, if case the distance computed for that hit wall cell is greater than the current distance,
then we are updating the distance over there and going through same process
until we reach the destination.
    As we are selecting always a min distanct cell, then it is guaranteed that once destination is reached
we ll have min distance path A|c to Dijkstra.
    If in case of Dijkstra, we simply do BFS, we ll be adding same cell again n again n again util,
the distance of the cell is greater than the present and stop the looping of priorityQueue.
So, the time complexity wise Dijkstra is more intuitive than nornal BFS. But extra space is required for
Dijkstra as we require an additional visited[][] array for marking.
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

    int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        int startX = start[0];
        int startY = start[1];
        minHeap.offer(new int[]{startX, startY, 0});
        //visited[startX][startY] = true;
        int[][] distance = new int[m][n];
        for(int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[startX][startY] = 0;
        while(!minHeap.isEmpty()){

            int[] current = minHeap.poll();
            if(visited[current[0]][current[1]]){
                continue;
            }
            if(current[0] == destination[0] && current[1] == destination[1]){
                return current[2];
            }
            visited[current[0]][current[1]] = true;
            for(int[] dir : dirs){
                int currentX = current[0];
                int currentY = current[1];
                int step = current[2];
                while(currentX >= 0 && currentX < m && currentY >= 0 && currentY < n && maze[currentX][currentY] == 0){
                    currentX += dir[0];
                    currentY += dir[1];
                    step++;
                }

                currentX -= dir[0];
                currentY -= dir[1];
                step--;

                if( !visited[currentX][currentY] && step < distance[currentX][currentY]){
                    minHeap.offer(new int[]{currentX, currentY, step});
                    distance[currentX][currentY] = step;
                }
            }

        }

        return -1;
    }
}
