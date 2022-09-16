package com.graph.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
TC : o(elogv)
SC : o(e)
 */
public class DijkstraAlgorithm {

    int V;
    int[] distance;
    int[] parent;
    boolean[] visited;


    public  DijkstraAlgorithm(int V){
        this.V = V;
        distance = new int[V];
        parent = new int[V];
        visited = new boolean[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
    }

    public int findShortestPath(Graph graph, int source, int destination){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance-b.distance);

        distance[source] =0;
        pq.offer(new Pair(0,source));

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            if(current.node == destination)
                return distance[current.node];
            if(visited[current.node])
                continue;
            visited[current.node] = true;
            for(Node neighbour : graph.adjList.get(current.node)){
                int nextNode = neighbour.destination;
                int nextWeight = neighbour.weight;
                int nextDistance = current.distance + nextWeight;
                if(!visited[nextNode] && nextDistance < distance[nextNode])
                {
                    distance[nextNode] = nextDistance;
                    parent[nextNode] = current.node;
                    pq.offer(new Pair(nextDistance,nextNode));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1,1, false);
        graph.addEdge(1,2,1, false);
        graph.addEdge(0,2,4, false);
        graph.addEdge(0,3,7, false);
        graph.addEdge(3,2,2, false);
        graph.addEdge(3,4,3, false);

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(5);

        System.out.println(dijkstra.findShortestPath(graph,0,4));

    }
}

class Node{
    int destination, weight;
    public Node(int d, int w){
        this.destination = d;
        this.weight = w;
    }
}

class Pair{
    int distance, node;
    public Pair(int d, int node){
        this.distance = d;
        this.node = node;
    }
}

class Graph {
    int V;
    List<List<Node>> adjList;

    public Graph(int V){
        this.V = V;
        adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight, boolean isDirected){
        adjList.get(source).add(new Node(destination,weight));
        if(!isDirected){
            adjList.get(destination).add(new Node(source,weight));
        }
    }
}
