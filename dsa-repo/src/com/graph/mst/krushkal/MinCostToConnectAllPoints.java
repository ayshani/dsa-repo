package com.graph.mst.krushkal;

import java.util.PriorityQueue;

/*
1584. Min Cost to Connect All Points

You are given an array points representing integer coordinates of some points on a 2D-plane,
where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them:
|xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one
simple path between any two points.

Example 1:
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation:
We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.

TC: o(e*e + elogV)
SC: o(e)
 */
public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0,0},{2,2},{3,10},{5,2},{7,0}
        };
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(points));
    }
    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length==0)
            return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        int n = points.length;
        for(int i=0;i<n;i++){
            int[] pointX = points[i];
            for(int j=i+1;j<n;j++){
                int[] pointY = points[j];
                int distance = Math.abs(pointX[0] - pointY[0])  +
                        Math.abs(pointX[1] - pointY[1]);
                pq.offer(new int[]{i, j, distance});
            }
        }

        int edgeCount =0, minCost =0;
        UnionFind uf = new UnionFind(n);
        while(!pq.isEmpty() && edgeCount<n-1){
            int[] cur = pq.poll();

            int x = uf.find(cur[0]), y = uf.find(cur[1]);
            if(x!=y){
                uf.union(x,y);
                edgeCount++;
                minCost+= cur[2];
            }
        }
        return minCost;
    }
}
