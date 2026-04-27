package com.graph.unionfind;
/*
1391. Check if There is a Valid Path in a Grid

You are given an m x n grid. Each cell of grid represents a street. The street of grid[i][j] can be:

1 which means a street connecting the left cell and the right cell.
2 which means a street connecting the upper cell and the lower cell.
3 which means a street connecting the left cell and the lower cell.
4 which means a street connecting the right cell and the lower cell.
5 which means a street connecting the left cell and the upper cell.
6 which means a street connecting the right cell and the upper cell.

You will initially start at the street of the upper-left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.

Notice that you are not allowed to change any street.

Return true if there is a valid path in the grid or false otherwise.

Example 1:

Input: grid = [[2,4,3],[6,5,2]]
Output: true
Explanation: As shown you can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).

 */
public class CheckIfThereIsAValidPathInAGrid {

    int[][] grid;
    int m;
    int n;
    DisjointSet ds;

    public static void main(String[] args) {
        System.out.println(new CheckIfThereIsAValidPathInAGrid().hasValidPath(
                new int[][]{{2,4,3},{6,5,2}}
        ));
    }
    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        ds = new DisjointSet(m, n);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                handler(i, j);
            }
        }

        return ds.find(getId(0, 0)) == ds.find(getId(m - 1, n - 1));
    }

    public int getId(int x, int y) {
        return x * n + y;
    }

    public void detectL(int x, int y) {
        if (
                y - 1 >= 0 &&
                        (grid[x][y - 1] == 4 || grid[x][y - 1] == 6 || grid[x][y - 1] == 1)
        ) {
            ds.merge(getId(x, y), getId(x, y - 1));
        }
    }

    public void detectR(int x, int y) {
        if (
                y + 1 < n &&
                        (grid[x][y + 1] == 3 || grid[x][y + 1] == 5 || grid[x][y + 1] == 1)
        ) {
            ds.merge(getId(x, y), getId(x, y + 1));
        }
    }

    public void detectU(int x, int y) {
        if (
                x - 1 >= 0 &&
                        (grid[x - 1][y] == 3 || grid[x - 1][y] == 4 || grid[x - 1][y] == 2)
        ) {
            ds.merge(getId(x, y), getId(x - 1, y));
        }
    }

    public void detectD(int x, int y) {
        if (
                x + 1 < m &&
                        (grid[x + 1][y] == 5 || grid[x + 1][y] == 6 || grid[x + 1][y] == 2)
        ) {
            ds.merge(getId(x, y), getId(x + 1, y));
        }
    }

    public void handler(int x, int y) {
        switch (grid[x][y]) {
            case 1:
                detectL(x, y);
                detectR(x, y);
                break;
            case 2:
                detectU(x, y);
                detectD(x, y);
                break;
            case 3:
                detectL(x, y);
                detectD(x, y);
                break;
            case 4:
                detectR(x, y);
                detectD(x, y);
                break;
            case 5:
                detectL(x, y);
                detectU(x, y);
                break;
            case 6:
                detectR(x, y);
                detectU(x, y);
        }
    }
}

class DisjointSet {

    int[] f;

    public DisjointSet(int m, int n) {
        f = new int[m * n];
        for (int i = 0; i < m * n; ++i) {
            f[i] = i;
        }
    }

    public int find(int x) {
        return x == f[x] ? x : (f[x] = find(f[x]));
    }

    public void merge(int x, int y) {
        f[find(x)] = find(y);
    }
}