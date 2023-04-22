package com.graph.mst.krushkal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
1168. Optimize Water Distribution in a Village

There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

For each house i, we can either build a well inside it directly with cost wells[i - 1]
(note the -1 due to 0-indexing), or pipe in water from another well to it. The costs to lay pipes between houses
are given by the array pipes where each pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j
and house2j together using a pipe. Connections are bidirectional, and there could be multiple valid connections
between the same two houses with different costs.

Return the minimum total cost to supply water to all houses.

Example 1:
Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
Output: 3
Explanation: The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with
cost 2 so the total cost is 3.

Intuition
I take it this way:
We cannot build any well.
There is one and only one hidding well in my house (house 0).
The cost to lay pipe between house[i] and my house is wells[i].

In order to supply water to the whole village,
we need to make the village a coonected graph.


Explanation
Merge all costs of pipes together and sort by key.
Greedily lay the pipes if it can connect two seperate union.
Appply union find to record which houses are connected.


Complexity
Time O(ElogE)
Space O(N)
 */
public class OptimizeWaterDistributionInAVillage {

    public static void main(String[] args) {
        int n =3, wells[] = new int[]{1,2,2}, edges[][] = new int[][]{{1,2,1},{2,3,1}};
        System.out.println(new OptimizeWaterDistributionInAVillage().minCostToSupplyWater(n,wells,edges));
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<wells.length;i++){
            edges.add(new int[]{0,i+1,wells[i]});
        }

        for(int[] pipe : pipes){
            edges.add(pipe);
        }

        Collections.sort(edges, (a, b) -> a[2]-b[2]);
        UnionFind uf = new UnionFind(n+1);
        int minCost =0;
        for(int[] edge : edges){
            int x = uf.find(edge[0]), y = uf.find(edge[1]);
            if(x!=y){
                uf.union(x,y);
                minCost+=edge[2];
            }
        }
        return minCost;
    }
}
