package com.graph.mst.krushkal;

import java.util.Arrays;

/*
1579. Remove Max Number of Edges to Keep Graph Fully Traversable

Alice and Bob have an undirected graph of n nodes and three types of edges:

Type 1: Can be traversed by Alice only.
Type 2: Can be traversed by Bob only.
Type 3: Can be traversed by both Alice and Bob.
Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes
ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still
be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node,
they can reach all other nodes.

Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

Example 1:
Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
Output: 2
Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob.
Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.

TC : o(E*alpha(E)) == o(E)
SC: o(n)
 */
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

    public static void main(String[] args) {
        int n = 4, edges[][] = new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};

        System.out.println(new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable().maxNumEdgesToRemove(n,edges));
    }

    //Intuition
    //Add Type3 first, then check Type 1 and Type 2.
    //
    //
    //Explanation
    //Go through all edges of type 3 (Alice and Bob)
    //If not necessary to add, increment res.
    //Otherwith increment e1 and e2.
    //
    //Go through all edges of type 1 (Alice)
    //If not necessary to add, increment res.
    //Otherwith increment e1.
    //
    //Go through all edges of type 2 (Bob)
    //If not necessary to add, increment res.
    //Otherwith increment e2.
    //
    //If Alice's'graph is connected, e1 == n - 1 should valid.
    //If Bob's graph is connected, e2 == n - 1 should valid.
    //In this case we return res,
    //otherwise return -1.
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind1579 aliceUnionFind = new UnionFind1579(n+1), bobUnionFInd = new UnionFind1579(n+1);
        int canRemoveEdge =0, aliceEdges =0, bobEdges =0;

        // This Imp. will greedily check for Type 3 first
        Arrays.sort(edges, (a, b) -> b[0]-a[0]);

        for(int[] edge : edges){
            int edgeType = edge[0], vertexA = edge[1], vertexB = edge[2];
            if(edgeType== 3){
                boolean unionAliceGraph = aliceUnionFind.union(vertexA, vertexB);
                boolean unionBobGraph = bobUnionFInd.union(vertexA, vertexB);

                if(unionAliceGraph){
                    aliceEdges++;
                }
                if(unionBobGraph){
                    bobEdges++;
                }

                // edges already connected by Alice and Bob individually .
                // we can Remove the edge
                if(!unionAliceGraph && !unionBobGraph){
                    canRemoveEdge++;
                }
            } else if(edgeType== 1){
                boolean unionAliceGraph = aliceUnionFind.union(vertexA, vertexB);
                if(unionAliceGraph){
                    aliceEdges++;
                } else{

                    // edges already connected by Alice and can be removed
                    canRemoveEdge++;
                }
            } else if(edgeType== 2){
                boolean unionBobGraph = bobUnionFInd.union(vertexA, vertexB);
                if(unionBobGraph){
                    bobEdges++;
                } else{

                    // edges already connected by Bob and can be removed
                    canRemoveEdge++;
                }
            }
        }

        //It takes minimum  (N -1) to connect a graph with N node . MST concept
        return (aliceEdges == n-1 && bobEdges == n-1) ? canRemoveEdge : -1;
    }
}

class  UnionFind1579{
    int[] parent, rank;

    public UnionFind1579(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x]==x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px==py)
            return false;
        if(rank[px]>rank[py]){
            parent[py] =px;
        } else if(rank[py]>rank[px]){
            parent[px] =py;
        } else{
            parent[py] =px;
            rank[px]++;
        }
        return true;
    }
}
