package com.math;

import java.util.HashMap;
import java.util.Map;

/*
447. Number of Boomerangs

You are given n points in the plane that are all distinct, where points[i] = [xi, yi].
A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals
the distance between i and k (the order of the tuple matters).

Return the number of boomerangs.

Example 1:

Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].

TC : o(n^2)
SC : o(n)
 */
public class NumberOfBoomerangs {

    public static void main(String[] args) {
        int[][] p = new int[][]{
                {0,0},{1,0},{2,0}
        };

        System.out.println(new NumberOfBoomerangs().numberOfBoomerangs(p));
    }
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j)
                    continue;

                // Get distance between two points
                int distance = getDistance(points[i],points[j]);

                // coutn the occurrence of the same distance
                map.put(distance, map.getOrDefault(distance,0)+1);

            }
            /*
            For every i, we capture the number of points equidistant from i.
            Now for this i, we have to calculate all possible permutations of (j,k) from these equidistant points.
            Total number of permutations of size 2 from n different points is nP2 = n!/(n-2)! = n * (n-1).
             */
            for(int val : map.values()){
                res+= val*(val-1);
            }

            map.clear();
        }

        return res;
    }

    private int getDistance(int[] pointi, int[] pointj){
        int dx = pointi[0]- pointj[0];
        int dy = pointi[1] - pointj[1];

        int distance = dx*dx + dy*dy;

        return distance;
    }
}
