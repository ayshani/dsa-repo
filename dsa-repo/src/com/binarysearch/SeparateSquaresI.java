package com.binarysearch;
/*
3453. Separate Squares I

You are given a 2D integer array squares. Each squares[i] = [xi, yi, li] represents the coordinates of the bottom-left point and the side length of a square parallel to the x-axis.

Find the minimum y-coordinate value of a horizontal line such that the total area of the squares above the line equals the total area of the squares below the line.

Answers within 10-5 of the actual answer will be accepted.

Note: Squares may overlap. Overlapping areas should be counted multiple times.



Example 1:

Input: squares = [[0,0,1],[2,2,1]]

Output: 1.00000

Explanation:
Any horizontal line between y = 1 and y = 2 will have 1 square unit above it and 1 square unit below it. The lowest option is 1.

TC : o(nlog(LU)
SC: o(1)
 */
public class SeparateSquaresI {

    public static void main(String[] args) {
        System.out.println(new SeparateSquaresI().separateSquares(
                new int[][]{
                        {0,0,1},
                        {2,2,1}
                }
        ));
    }
    public double separateSquares(int[][] squares) {
        double max_y = 0;
        double total_area = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            total_area += (double) l * l;
            max_y = Math.max(max_y, (double) (y + l));
        }

        double lo = 0;
        double hi = max_y;
        double eps = 1e-5;
        while (Math.abs(hi - lo) > eps) {
            double mid = (hi + lo) / 2;
            if (check(mid, squares, total_area)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }

    private Boolean check(double limit_y, int[][] squares, double total_area) {
        double area = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            if (y < limit_y) {
                area += (double) l * Math.min(limit_y - y, (double) l);
            }
        }
        return area >= total_area / 2;
    }
}
