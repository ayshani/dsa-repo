package com.graph.dfs;

import java.util.Arrays;

/*
733. Flood Fill

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from
the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting
pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
(also with the same color), and so on. Replace the color of all the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels
connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

TC : o(m*n)
SC: o(m*n)
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1,1,1},{1,1,0},{1,0,1}
        };
        System.out.println(Arrays.toString(new FloodFill().floodFill(image,1,1,2)));
    }
    int[] dir = new int[]{0,1,0,-1,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int oldColor =0;
        if(sr<m && sc<n){
            oldColor = image[sr][sc];
        } else{
            return new int[][]{};
        }
        if(oldColor == color)
            return image;

        floorFillUtil(image, sr,sc,m,n,oldColor,color);
        return image;
    }

    private void floorFillUtil(int[][] image,int sr,int sc,int m, int n,int oldColor,int newColor)   {
        image[sr][sc]=newColor;
        for(int i=0;i<4;i++){
            int x = sr+dir[i], y = sc + dir[i+1];
            if(x>=0 && x<m && y>=0 && y<n && image[x][y]== oldColor){
                floorFillUtil(image, x,y,m,n,oldColor,newColor);
            }
        }
    }
}
