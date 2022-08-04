package com.dp;
/*
361. Bomb Enemy

Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall
since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:

For the given grid
0 E 0 0
E 0 W E
0 E 0 0
return 3. (Placing a bomb at (1,1) kills 3 enemies)

Logic
-----
The problem here is: while we scan each element in the same row, we calculate how many ‘E’
in this row n times (assume n is the number of columns). To save time, we simply store the calculation in a
variable every time we scan the first element in a new row. But be careful about the ‘W’. After we hit the ‘W’,
we need to recount ‘E’ and update the variable.

The same approach applies to each column. Since we are scanning through each row, we jump from one column to
another column. So we need an array to store ‘E’ counts for each column.

With those two auxiliary storages, we can just update the max ‘E’ counts when we encounter ‘0’ every time.

Time complexity:
O(height * width).
The inner-most for-loops only execute when we're at the first row / column or when we reach a wall.

SC : o(n)
 */
public class BombEnemy {

    public static void main(String[] args) {
         char[][] grid = new char[][]{
                 {'0','E','0','0'},
                 {'E','0','W','E'},
                 {'0','E','0','0'}
         };

         System.out.println(new BombEnemy().maxKilledEnemies(grid));
    }

    private int maxKilledEnemies(char[][] grid) {

        if(grid== null || grid.length==0 || grid[0].length==0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int maxCount =0, rowCount =0;
        int[] colCount = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCount=0;
                    for(int k = j;k<n && grid[i][k]!='W';k++){
                        if(grid[i][k]=='E')
                            rowCount++;
                    }
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    colCount[j]=0;
                    for(int k = i;k<m && grid[k][j]!='W';k++){
                        if(grid[k][j]=='E')
                            colCount[j]++;
                    }
                }

                if(grid[i][j]=='0'){
                    maxCount = Math.max(maxCount, rowCount+colCount[j]);
                }

            }
        }

        return maxCount;
    }
}
