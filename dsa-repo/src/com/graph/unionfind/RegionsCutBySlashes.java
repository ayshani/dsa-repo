package com.graph.unionfind;
/*
959. Regions Cut By Slashes

An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank
space ' '. These characters divide the square into contiguous regions.

Given the grid grid represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.

Example 1:
Input: grid = ["/\\","\\/"]
Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.

TC : o(n^2)
SC: o(n^2)
 */
public class RegionsCutBySlashes {

    int count, n;
    int[] parent;

    public static void main(String[] args) {
        System.out.println(new RegionsCutBySlashes().regionsBySlashes(
                new String[]{"/\\","\\/"}
        ));
    }
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        parent = new int[n * n * 4];  //build an array to store all parents of all triangles
        count = n * n * 4;        //total number of polygons
        for (int i = 0; i < n * n * 4; ++i)    //initialize the parent array
            parent[i] = i;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) union(g(i - 1, j, 2), g(i, j, 0));   // merge triangles 2 and 0 from two squares vertically
                if (j > 0) union(g(i , j - 1, 1), g(i , j, 3)); // merge trianges 1 and 3 from two squares horizontally. These triangles are supposed to be contiguous originally
                if (grid[i].charAt(j) != '/') {                      // if it is "\\" or empty, apply common operations
                    union(g(i , j, 0), g(i , j,  1));
                    union(g(i , j, 2), g(i , j,  3));
                }
                if (grid[i].charAt(j) != '\\') {              // if it is "/" or empty, apply common operations.
                    union(g(i , j, 0), g(i , j,  3));         // These two if statements solve the repetition issue caused by traditional three if statements
                    union(g(i , j, 2), g(i , j,  1));
                }
            }
        }
        return count;
    }


    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);  //path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {     //merge two polygons to a bigger polygon will decrease number of polygons by 1
        x = find(x); y = find(y);
        if (x != y) {
            parent[x] = y;
            count--;
        }
    }

    public int g(int i, int j, int k) {    //find the corresponding position for current triangle. Thinks this 1D array as a 2D array and each element is an array of size 4.
        return (i * n + j) * 4 + k;
    }
}
