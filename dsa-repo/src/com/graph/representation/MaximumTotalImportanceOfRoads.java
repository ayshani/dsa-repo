package com.graph.representation;

import java.util.Arrays;

/*
2285. Maximum Total Importance of Roads

You are given an integer n denoting the number of cities in a country. The cities are numbered from 0 to n - 1.

You are also given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional
road connecting cities ai and bi.

You need to assign each city with an integer value from 1 to n, where each value can only be used once.
The importance of a road is then defined as the sum of the values of the two cities it connects.

Return the maximum total importance of all roads possible after assigning the values optimally.

Example 1:
Input: n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
Output: 43
Explanation: The figure above shows the country and the assigned values of [2,4,5,3,1].
- The road (0,1) has an importance of 2 + 4 = 6.
- The road (1,2) has an importance of 4 + 5 = 9.
- The road (2,3) has an importance of 5 + 3 = 8.
- The road (0,2) has an importance of 2 + 5 = 7.
- The road (1,3) has an importance of 4 + 3 = 7.
- The road (2,4) has an importance of 5 + 1 = 6.
The total importance of all roads is 6 + 9 + 8 + 7 + 7 + 6 = 43.
It can be shown that we cannot obtain a greater total importance than 43.

TC : o(nlogn)
SC: o(n)
 */
public class MaximumTotalImportanceOfRoads {

    public static void main(String[] args) {
        System.out.println(new MaximumTotalImportanceOfRoads()
                .maximumImportance(5, new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
    }
    /*
    Steps :
    1. get degrees of each city
    2. Sort it in ascending order
    3. start giving value from 1 to cities and compute total importance
     */
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        for(int[] edge : roads){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Arrays.sort(degree);
        long value = 1, totalImportance = 0;
        for(long d : degree){
            totalImportance += (value*d);
            value++;
        }
        return totalImportance;
    }
}
