package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
3970. Shortest Path With At Most K Consecutive Identical Characters

You are given an integer n representing the number of nodes in a directed weighted graph, numbered from 0 to n - 1.
This is represented by a 2D integer array edges, where edges[i] = [ui, vi, wi] represents a directed edge from node ui
to node vi with weight wi.

You are also given a string labels of length n, where labels[i] is the character assigned to node i, and an integer k.

Return the minimum total edge weight of a path from node 0 to node n - 1 such that the concatenation of the labels of
the nodes along the path contains at most k consecutive identical characters. If no valid path exists, return -1.



Example 1:

Input: n = 3, edges = [[0,1,1],[1,2,1],[0,2,3]], labels = "aab", k = 1

Output: 3

Explanation:

The optimal valid path from node 0 to node 2 is as follows:

Use edges[2] = [0, 2, 3] to reach node 2 with a weight wi = 3.
The corresponding concatenation of labels is "ab", which satisfies at most k = 1 consecutive identical characters.
Thus, the answer is 3.

TC : O(nk+mklog(mk))
SC: O(nk+mk)
 */
public class ShortestPathWithAtMostKConsecutiveIdenticalCharacters {

    public static void main(String[] args) {
        System.out.println(new ShortestPathWithAtMostKConsecutiveIdenticalCharacters().shortestPath(
                3, new int[][]{{0,1,1},{1,2,1},{0,2,3}}, "aab", 1
        ));
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i-> new ArrayList<>());
        for(int[] e : edges){
            g[e[0]].add(new int[]{e[1],e[2]});
        }

        long[][] dis = new long[n][k+1];
        for(long[] row: dis){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {shortest path length, node index, number of consecutive identical letters at the end}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dis[0][1] =0;
        pq.offer(new long[]{0,0,1});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            long d = cur[0];
            int x = (int) cur[1];
            int cnt = (int)cur[2];

            if(d>dis[x][cnt]){
                continue;
            }
            if(x==n-1){
                return (int)d;
            }

            for(int[] e: g[x]){
                int y=e[0], w = e[1];
                int newCnt = labels.charAt(x)==labels.charAt(y) ? cnt+1:1;
                if(newCnt>k){
                    continue;
                }

                long nd = d+w;
                if(nd< dis[y][newCnt]){
                    dis[y][newCnt]=nd;
                    pq.offer(new long[]{nd, y, newCnt});
                }
            }
        }
        return -1;
    }
}
