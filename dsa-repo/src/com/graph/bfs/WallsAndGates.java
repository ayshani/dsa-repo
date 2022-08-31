package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
286	Walls and Gates
https://leetcode.ca/all/286.html

You are given a m x n 2D grid initialized with these three possible values.

 -1     - A wall or an obstacle.
 0      - A gate.
 INF    - Infinity means an empty room.
            We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that
            the distance to a gate is less than 2147483647.

 Fill each empty room with the distance to its nearest gate.
 If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:

 INF    -1      0       INF
 INF    INF     INF     -1
 INF    -1      INF     -1
 0      -1      INF     INF

 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4

Logic
------
Search for the position of 0, and every time a 0 is found,
start BFS traversal with four adjacent points around it as the starting point,
and bring in the depth value 1.

If the value encountered is greater than the current depth value,
assign the position value to the current depth value,
and start BFS traversal for the four adjacent points of the current point.
Note that the depth value needs to be increased by 1.


After the traversal is completed, all positions are updated correctly
 */
public class WallsAndGates {

    public static void main(String[] args) {
        int inf = Integer.MAX_VALUE;
        int[][] rooms = new int[][]{
                {inf, -1, 0, inf},
                {inf, inf, inf, -1},
                {inf, -1, inf, -1},
                {0, -1, inf, inf}
        };

        WallsAndGates obj = new WallsAndGates();
        obj.wallsAndGates(rooms);

        for(int i=0;i<rooms.length;i++){
            for(int j =0;j<rooms[0].length;j++){
                System.out.print(rooms[i][j] +"  ");
            }
            System.out.println();
        }
    }
    public void wallsAndGates(int[][] rooms){

        if(rooms== null || rooms.length==0)
            return;

        Queue<Pair> q = new LinkedList<>();
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int n = rooms.length, m = rooms[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rooms[i][j]==0)
                    q.offer(new Pair(i,j));
            }
        }


         while(!q.isEmpty()){

             Pair p = q.poll();
             for(int[] d : dir) {
                 int x = d[0] + p.i;
                 int y = d[1] + p.j;

                 if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] <= rooms[p.i][p.j] + 1)
                     continue;
                 rooms[x][y] = rooms[p.i][p.j] + 1;
                 q.offer(new Pair(x, y));
             }
         }


    }
}

class Pair{
    int i, j;
    Pair(int f, int s){
        this.i = f;
        this.j = s;
    }
}
