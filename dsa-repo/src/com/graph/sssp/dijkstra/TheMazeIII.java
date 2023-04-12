package com.graph.sssp.dijkstra;

import java.util.PriorityQueue;

/*
499. The Maze III

There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go
through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall.
When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop
into the hole if it rolls onto the hole.

Given the m x n maze, the ball's position ball and the hole's position hole, where ball = [ballrow, ballcol]
and hole = [holerow, holecol], return a string instructions of all the instructions that the ball should follow
to drop in the hole with the shortest distance possible. If there are multiple valid instructions,
return the lexicographically minimum one. If the ball can't drop in the hole, return "impossible".

If there is a way for the ball to drop in the hole, the answer instructions should contain
the characters 'u' (i.e., up), 'd' (i.e., down), 'l' (i.e., left), and 'r' (i.e., right).

The distance is the number of empty spaces traveled by the ball from the start position (excluded)
to the destination (included).

You may assume that the borders of the maze are all walls (see examples).

Example 1:
Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], ball = [4,3], hole = [0,1]
Output: "lul"
Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller
because 'l' < 'u'. So the output is "lul".

TC : o(v+elogv)
SC: o(m*n)
 */
public class TheMazeIII {

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0,0,0,0,0},
                {1,1,0,0,1},
                {0,0,0,0,0},
                {0,1,0,0,1},
                {0,1,0,0,0}
        };
        int[] ball = new int[]{4,3}, hole = new int[]{0,1};
        System.out.println(new TheMazeIII().findShortestWay(maze,ball,hole));
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        boolean[][] visited = new boolean[m][n];
        int[] dir = new int[]{0,1,0,-1,0};
        char[] ins = new char[]{'r','d','l','u'};

        pq.offer(new Point(ball[0],ball[1],0,""));

        while(!pq.isEmpty()){
            Point current = pq.poll();

            if(visited[current.x][current.y])
                continue;
            if(current.x == hole[0] && current.y == hole[1])
                return current.direction;
            visited[current.x][current.y] = true;

            for(int i=0;i<4;i++){
                int curX = current.x, curY = current.y, dist = current.distance;
                String instruction = current.direction;

                while(curX+dir[i]>=0 && curX+dir[i]<m && curY+dir[i+1]>=0 && curY+dir[i+1]<n
                        && maze[curX+dir[i]][curY+dir[i+1]]==0){
                    curX+=dir[i];
                    curY+=dir[i+1];
                    dist++;
                    // this condition is important as hole can be anywhere.
                    // And once a hole is found, we cn stop
                    if(curX == hole[0] && curY == hole[1])
                        break;
                }
                //curX-=dir[i];
                //curY-=dir[i+1];
                //dist--;
                if(!visited[curX][curY]){
                    pq.offer(new Point(curX,curY,dist,instruction+ins[i]));
                }
            }

        }

        return "impossible";
    }
}

class Point implements Comparable<Point>{
    int x,y,distance;
    String direction;

    public Point(int x, int y, int d, String dir){
        this.x =x;
        this.y =y;
        this.distance = d;
        this.direction = dir;
    }

    public int compareTo(Point other){
        return this.distance== other.distance  ? this.direction.compareTo(other.direction) :
                this.distance- other.distance;
    }

}
