package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*

2101. Detonate the Maximum Bombs

You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt.
This area is in the shape of a circle with the center as the location of the bomb.

The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote
the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.

You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range.
These bombs will further detonate the bombs that lie in their ranges.

Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate
only one bomb.



Example 1:
Input: bombs = [[2,1,3],[6,1,4]]
Output: 2
Explanation:
The above figure shows the positions and ranges of the 2 bombs.
If we detonate the left bomb, the right bomb will not be affected.
But if we detonate the right bomb, both bombs will be detonated.
So the maximum bombs that can be detonated is max(1, 2) = 2.

TC: o(v*(v*e))
SC: o(v)
 */
public class DetonateTheMaximumBombs {

    public static void main(String[] args) {
        int[][] bombs = new int[][]{{2,1,3},{6,1,4}};
        System.out.println(new DetonateTheMaximumBombs().maximumDetonation(bombs));
    }
    public int maximumDetonation(int[][] bombs) {

        // get the max count of bombs which can be detonated from BFS
        // if we start from ith index
        int maxCount =0;
        for(int i=0;i<bombs.length;i++){
            maxCount = Math.max(maxCount, bfs(i, bombs));
        }
        return maxCount;
    }

    private int bfs(int i, int[][] bombs){
        int n = bombs.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(i);
        visited[i] =true;
        int count =1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int j=0;j<n;j++){
                if(!visited[j] && bombIsInRange(bombs[cur], bombs[j])){
                    visited[j] = true;
                    count++;
                    q.offer(j);
                }
            }
        }
        return count;
    }

    //use the distance between two points formula
    //then check if curr bomb radius is greater than the distance; meaning we can detonate the second bombs
    private boolean  bombIsInRange(int bomb1[], int bomb2[]){
        long dx = bomb1[0] -bomb2[0], dy = bomb1[1] - bomb2[1], r = bomb1[2];
        long range = dx*dx + dy*dy;
        return range <=r*r;
    }
}
