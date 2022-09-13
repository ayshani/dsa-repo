package com.math;
/*
1232. Check If It Is a Straight Line

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.

Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
 // find slope from point 1 and point 2
    // compare the slopes of all other points wrt to the original slope
    //
    // Slope of points (x1, y1) and (x2, y2) is:
    // (y2 - y1) / (x2 - x1)
    //
    // Slope of points (x1, y1) and (x3, y3) is:
    // (y3 - y1) / (x3 - x1)
    //
    // for all three points to be on the same line, the slopes should be equal, in other words:
    // (x3 - x1)*(y2 - y1) = (y3 - y1)*(x2 - x1)
    //
    // to avoid running into divide by zero error, use multiplication to find slope

    TC : o(n)
    SC : o(1)
 */
public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        int[][] cood = new int[][]{
                {1,2},{2,3},{5,8}
        };

        System.out.println(new CheckIfItIsAStraightLine().checkStraightLine(cood));
    }
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates == null || coordinates.length<3 || coordinates[0].length==0)
            return true;

        int p[] = coordinates[0];
        int q[] = coordinates[1];

        for(int i=2;i<coordinates.length;i++){
            int[] cur = coordinates[i];

            if((cur[0]-p[0])*(q[1]-p[1]) != (cur[1]-p[1])*(q[0]-p[0]))
                return false;
        }

        return true;
    }
}
