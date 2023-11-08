package com.math;
/*
2849. Determine if a Cell Is Reachable at a Given Time

You are given four integers sx, sy, fx, fy, and a non-negative integer t.

In an infinite 2D grid, you start at the cell (sx, sy). Each second, you must move to any of its adjacent cells.

Return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise.

A cell's adjacent cells are the 8 cells around it that share at least one corner with it. You can visit the
same cell several times.

Example 1:
Input: sx = 2, sy = 4, fx = 7, fy = 7, t = 6
Output: true
Explanation: Starting at cell (2, 4), we can reach cell (7, 7) in exactly 6 seconds by going through the cells
depicted in the picture above.

TC : o(1)
SC: o(1)
 */
public class DetermineIfACellIsReachableAtAGivenTime {

    public static void main(String[] args) {
        System.out.println(new DetermineIfACellIsReachableAtAGivenTime().isReachableAtTime(2,4,7,7,6));
    }
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xdiff = Math.abs(sx-fx), ydiff = Math.abs(sy-fy);
        if(xdiff==0 && ydiff==0 && t==1)
            return false;
        return Math.min(xdiff, ydiff)+ Math.abs(xdiff- ydiff) <=t;
    }
}
