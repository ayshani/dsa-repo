package com.matrix;

import java.util.*;

/*
2392. Build a Matrix With Conditions

You are given a positive integer k. You are also given:

a 2D integer array rowConditions of size n where rowConditions[i] = [abovei, belowi], and
a 2D integer array colConditions of size m where colConditions[i] = [lefti, righti].
The two arrays contain integers from 1 to k.

You have to build a k x k matrix that contains each of the numbers from 1 to k exactly once. The remaining cells
should have the value 0.

The matrix should also satisfy the following conditions:

The number abovei should appear in a row that is strictly above the row at which the number belowi appears for all
i from 0 to n - 1.
The number lefti should appear in a column that is strictly left of the column at which the number righti appears
for all i from 0 to m - 1.
Return any matrix that satisfies the conditions. If no answer exists, return an empty matrix.



Example 1:
Input: k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
Output: [[3,0,0],[0,0,1],[0,2,0]]
Explanation: The diagram above shows a valid example of a matrix that satisfies all the conditions.
The row conditions are the following:
- Number 1 is in row 1, and number 2 is in row 2, so 1 is above 2 in the matrix.
- Number 3 is in row 0, and number 2 is in row 2, so 3 is above 2 in the matrix.
The column conditions are the following:
- Number 2 is in column 1, and number 1 is in column 2, so 2 is left of 1 in the matrix.
- Number 3 is in column 0, and number 2 is in column 1, so 3 is left of 2 in the matrix.
Note that there may be multiple correct answers.

TC : o(max(k*k, n))
SC: o(max(k*k, n))
 */
public class BuildAMatrixWithConditions {

    public static void main(String[] args) {
        int[][] res = new BuildAMatrixWithConditions().buildMatrix(3, new int[][]{
                {1,2},{3,2}},new int[][]{{2,1},{3,2}});

        Arrays.stream(res).forEach(e-> System.out.println(Arrays.toString(e)));
    }
    public int[][] buildMatrix(
            int k,
            int[][] rowConditions,
            int[][] colConditions
    ) {
        int[] orderRows = topoSort(rowConditions, k);
        int[] orderColumns = topoSort(colConditions, k);
        if (
                orderRows.length == 0 || orderColumns.length == 0
        ) return new int[0][0];
        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (orderRows[i] == orderColumns[j]) {
                    matrix[i][j] = orderRows[i];
                }
            }
        }
        return matrix;
    }

    private int[] topoSort(int[][] edges, int n) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        int[] deg = new int[n + 1], order = new int[n];
        int idx = 0;
        for (int[] x : edges) {
            adj[x[0]].add(x[1]);
            deg[x[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int f = q.poll();
            order[idx++] = f;
            n--;
            for (int v : adj[f]) {
                if (--deg[v] == 0) q.offer(v);
            }
        }
        if (n != 0) return new int[0];
        return order;
    }
}
