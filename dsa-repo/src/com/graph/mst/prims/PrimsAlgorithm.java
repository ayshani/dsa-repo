package com.graph.mst.prims;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Finding cost of a minimum spanning tree
Key points of Prim’s algorithm

Prim’s algorithm finds the cost of a minimum spanning tree from a weighted undirected graph.
Prim’s algorithm begins by randomly selecting a vertex and adding the least expensive edge from this vertex
to the spanning tree. The algorithm continues to add the least expensive edge from the vertices already added
to the spanning tree to make it grow and terminates when all the vertices are added to the spanning tree.
The algorithm is greedy in nature as it selects the least expensive edge from the vertices already added
to the spanning tree.

Algorithm : Prims minimum spanning tree ( Graph G, Souce_Node S )

1.  Create a priority queue Q of NodeCost objects ( node, cost ).
2.  Push [ S, 0 ] ( node, cost ) in the priority queue Q i.e Cost of reaching the node S from source node S is zero.
3.  While ( ! Q.empty() )
4.       Object = Q.top(); Q.pop()
5.       Node N = Object.Node and Cost C = Object.Cost
6.       If the node N is not present in the spanning tree
7.           Add node N to the spanning tree.
8.           Cost of the spanning tree += Cost C
9.           For all the nodes adjacent to node N that are not in the spanning tree.
10.               Push object ( adjacent node, cost ) into the Q

Explanation - https://www.algotree.org/algorithms/minimum_spanning_tree/prims_java/

Time complexity of Prim’s algorithm : O((E+V)log(V))
1. The time required to fetch the least expensive pair(cost, node) from the priority_queue is log V.
    This happens for every node V in the queue. Thus the time complexity for this operation is V(log(V)).
2. The for loop only iterates through all the outgoing edges of every node. Since the graph is undirected,
    the total number of edges is 2E. Also, for every edge the pair (cost, node) is pushed into the
    priority-queue which takes log(V) time. Thus the maximum number of push operations can happen
    only 2E times giving the time-complexity of 2E(log(V)).
3. From Operation 1. and Operation 2. the overall time complexity is O(V(log(V))) + O(2E(log(V))) = O((E+V)log(V)).

Space Complexity : O(2E) + O(V) = O(E)+ O(V)
 */
public class PrimsAlgorithm {

    public static void main(String[] args) {
        int sourceNode = 0, n =6;
        int[][] edges = new int[][]{
                {0,1,4},{0,2,1},{0,3,5},
                {1,3,2},{1,4,3},{1,5,3},
                {2,3,2},{2,4,8},
                {3,4,1},
                {4,5,4}
        };
        System.out.println(new PrimsAlgorithm().getMinCost(edges,sourceNode,n));
    }
    public int getMinCost(int[][] edges, int sourceNode, int n){

        List<List<NodeCost>> graph = generateGraph(n, edges);
        // Comparator lambda function that enables the priority queue to store the nodes
        // based on the cost in the ascending order.
        // the smallest cost node at the top.
        PriorityQueue<NodeCost> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);

        // The cost of the source node to itself is 0
        pq.offer(new NodeCost(sourceNode,0));

        // used for keeping track which node is considered for the minimum cost path
        boolean[] visited = new boolean[graph.size()];

        int minCost =0;

        while(!pq.isEmpty()){
            // Select the item <node, cost> with minimum cost
            NodeCost current = pq.poll();

            // Incase we have already considered a node for minimum cost path
            // we can ignore the node
            if(visited[current.node]) {
                continue;
            }
            // mark the current node as considered one
            visited[current.node] = true;
            System.out.print(current.node + " ->");
            // increment the minimum cost
            minCost += current.cost;

            // Iterate through all the nodes adjacent to the node taken out of priority queue.
            // Push only those nodes (node, cost) that are not yet present in the minumum spanning tree.
            for (NodeCost neighbour : graph.get(current.node)) {
                if (!visited[neighbour.node]) {
                    pq.offer(neighbour);
                }
            }
        }
        System.out.println();
        return minCost;
    }

    private List<List<NodeCost>> generateGraph(int n, int[][] edges) {

        List<List<NodeCost>> nodeLists = new ArrayList<>();
        for(int i=0;i<n;i++){
            nodeLists.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            nodeLists.get(edge[0]).add(new NodeCost(edge[1], edge[2]));
            nodeLists.get(edge[1]).add(new NodeCost(edge[0], edge[2]));
        }
        return nodeLists;
    }
}

class NodeCost{
    int node, cost;
    public NodeCost(int n, int c){
        this.node=n;
        this.cost = c;
    }

}
