package com.graph.representation;
/*
3047. Find the Largest Area of Square Inside Two Rectangles

There exist n rectangles in a 2D plane with edges parallel to the x and y axis. You are given two 2D integer arrays
bottomLeft and topRight where bottomLeft[i] = [a_i, b_i] and topRight[i] = [c_i, d_i] represent the bottom-left and
 top-right coordinates of the ith rectangle, respectively.

You need to find the maximum area of a square that can fit inside the intersecting region of at least two rectangles.
 Return 0 if such a square does not exist.



Example 1:
Input: bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]

Output: 1

Explanation:

A square with side length 1 can fit inside either the intersecting region of rectangles 0 and 1 or the intersecting
region of rectangles 1 and 2. Hence the maximum area is 1. It can be shown that a square with a greater side length
can not fit inside any intersecting region of two rectangles.

TC : o (n^2)
SC: o(n*4)
 */
public class FindTheLargestAreaOfSquareInsideTwoRectangles {

    public static void main(String[] args) {
        System.out.println(new FindTheLargestAreaOfSquareInsideTwoRectangles().largestSquareArea(
                new int[][]{
                        {1,1},{2,2},{3,1}
                },
                new int[][]{
                        {3,3},{4,4},{6,6}
                }
        ));
    }
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int maxArea =0, n = bottomLeft.length;
        int[][] coord = new int[n][4];
        for(int i=0;i<n;i++){
            coord[i] = new int[]{bottomLeft[i][0], bottomLeft[i][1], topRight[i][0], topRight[i][1]};
        }

        //Arrays.sort(coord, (a,b) -> (a[0]== b[0]? a[1]-b[1] : a[0]-b[0]));

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(coord[j][0]>=coord[i][2] || coord[j][2]<=coord[i][0])
                    continue;
                if(coord[j][3] <= coord[i][1] || coord[j][1] >= coord[i][3])
                    continue;
                int bottomX = Math.max(coord[i][0], coord[j][0]) ;
                int bottomY = Math.max(coord[i][1], coord[j][1]) ;
                int topX = Math.min(coord[i][2], coord[j][2]) ;
                int topY = Math.min(coord[i][3], coord[j][3]) ;
                int areaX = topX-bottomX, areaY = topY-bottomY;
                int area = Math.min(areaX, areaY);
                maxArea = Math.max(maxArea, area);
            }
        }
        return (long)maxArea*maxArea;
    }
}
