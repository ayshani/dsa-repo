package com.matrix;

import java.util.Arrays;

/*
885. Spiral Matrix III

You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first
row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the
grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually,
we reach all rows * cols spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.

Example 1:
Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],
[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

TC : o(max(roe,col)^2)
SC:o(rows*col)
 */
public class SpiralMatrixIII {

    public static void main(String[] args) {
        int[][] res = new SpiralMatrixIII().spiralMatrixIII(5,6,1,4);
        Arrays.stream(res).forEach(e -> {
            System.out.println(Arrays.toString(e));
            System.out.println();
        });
    }
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        //int[] dir = new int[]{0,1,0,-1,0};
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int[][] traversed = new int[rows*cols][2];
        int idx =0;

        for(int step =1, direction =0; idx<rows*cols;){
            // direction = 0 -> East, direction = 1 -> South
            // direction = 2 -> West, direction = 3 -> North
            for(int i=0;i<2;i++){
                for(int j=0; j<step; j++){
                    if (
                            rStart >= 0 &&
                                    rStart < rows &&
                                    cStart >= 0 &&
                                    cStart < cols
                    ) {
                        traversed[idx][0] = rStart;
                        traversed[idx][1] = cStart;
                        idx++;
                    }
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }
                direction = (direction+1)%4;
            }
            step++;
        }
        return traversed;
    }
}
