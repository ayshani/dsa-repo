package com.math;
/*
223. Rectangle Area

Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.

The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).

The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

Example 1:
Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
Output: 45

TC : o(1)
SC : o(1)

 */
public class RectangleArea {

    public static void main(String[] args) {
        System.out.println(new RectangleArea().computeArea(-2,-2,2,2,-2,-2,2,2));
    }
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // Area of A and B
        int areaOfA = (ay2-ay1)*(ax2-ax1);
        int areaOfB = (by2-by1)*(bx2-bx1);

        // calculate x overlap
        int left = Math.max(ax1,bx1);
        int right = Math.min(ax2,bx2);

        int xOverlap = right - left;

        // calculate y overlap
        int bottom = Math.max(ay1,by1);
        int top = Math.min(ay2,by2);
        int yOverlap = top-bottom;

        int areaOfOverlap =0;
        // if the rectangles overlap each other, then calculate
        // the area of the overlap
        if(xOverlap>0 && yOverlap>0)
            areaOfOverlap = xOverlap*yOverlap;

        // areaOfOverlap is counted twice when in the summation of
        // areaOfA and areaOfB, so we need to subtract it from the
        // total, to get the toal area covered by both the rectangles
        int totalArea = areaOfA + areaOfB - areaOfOverlap;

        return totalArea;

    }
}
