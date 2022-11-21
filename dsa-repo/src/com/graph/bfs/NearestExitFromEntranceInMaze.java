package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
1926. Nearest Exit from Entrance in Maze

You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and
column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall,
and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance.
An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Example 1:

Input: maze = [["+","+",".","+"],
               [".",".",".","+"],
               ["+","+","+","."]],
               entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.

TC : o(m*n)
SC : o(m+n)+ o(max(m,n))
 */
public class NearestExitFromEntranceInMaze {

    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {'+','+','+'},
                {'.','.','.'},
                {'+','+','+'}
        };

        System.out.println(new NearestExitFromEntranceInMaze().nearestExit(maze, new int[]{1,0}));
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;

        int[][] dir = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

        // Mark the entrance as visited since its not a exit.
        int startRow = entrance[0], startCol = entrance[1];

        maze[startRow][startCol] = '+';

        // Start BFS from the entrance, and use a queue `q` to store all
        // the cells to be visited.
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startRow, startCol,0});

        while(!q.isEmpty()){
            int[] currentState = q.poll();

            int curRow = currentState[0], curCol = currentState[1], curDistance = currentState[2];

            // For the current cell, check its four neighbor cells.
            for(int[] d : dir ){
                int nextRow = d[0] + curRow, nextCol = d[1]+curCol;

                // If there exists an unvisited empty neighbor:
                if(0<=nextRow && nextRow<rows && 0<= nextCol && nextCol<cols
                        && maze[nextRow][nextCol]=='.'){

                    // If this empty cell is an exit, return distance + 1.
                    if(nextRow == 0 || nextRow == rows-1 || nextCol==0 || nextCol== cols-1){
                        return curDistance+1;
                    }

                    // Otherwise, add this cell to 'q' and mark it as visited.
                    maze[nextRow][nextCol] = '+';
                    q.offer(new int[]{nextRow,nextCol,curDistance+1});
                }
            }
        }

        return -1;
    }
}
