package com.graph.dfs;

import java.util.*;

/*
 * 1743. Restore the Array From Adjacent Pairs
 *
 * There is an integer array nums that consists of n unique elements, but you have forgotten it.
 *  However, you do remember every pair of adjacent elements in nums.
 *
 *  You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi]
 *  indicates that the elements ui and vi are adjacent in nums.
 *
 *  It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs,
 *  either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 *
 *  Return the original array nums. If there are multiple solutions, return any of them.
 *
 *
 *  Example 1:
 *  Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 *  Output: [1,2,3,4]
 *  Explanation:
 *  This array has all its adjacent pairs in adjacentPairs.
 *  Notice that adjacentPairs[i] may not be in left-to-right order.
 *
 *  Logic
 *  --------
 *  we can consider this as a graph problem. we build the graph using adjacency list concept but in a Map.
 *  where Map.key = vertex
 *  	  Map.value = List of vertices of which is it adjacent to.
 *
 *  Once it is built , we need to get the vertex which has which has only one adjacency list size.
 *  This is because, if it is one, then it is possible that it is a starting point in the resultant array.
 *  if it is more than 1( i.2), then this key is in between two elements.
 *
 *  Insight is it can't be more than 2 as we need to create the resultant array from it and any array element
 *  can be at a position below:
 *   0 th
 *   n-1 th
 *   j th s.t. i<j<k
 *   Hence, max, size() of the adjacency list for a particular vertex can be maximum 2.
 *
 *  Coming back to the problem, once we get the starting vertex, we can do a DFS to create the list.
 *  Once done, we can transform it to array.
 *
 *
 *  TC : O(N)
 *  SC : O(N)
 */
public class RestoreTheArrayFromAdjacentPairs {
    Map<Integer, List<Integer>> graph;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] adjacentPairs = new int[][] {
                {2,1},{3,4},{3,2}
        };
        RestoreTheArrayFromAdjacentPairs obj = new RestoreTheArrayFromAdjacentPairs();
        int[] res = obj.restoreArray(adjacentPairs);

        for( int  e: res) {
            System.out.print(e+" ");
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        graph = new HashMap<>();

        for(int[] pair : adjacentPairs){
            buildGraph(pair[0],pair[1]);
            buildGraph(pair[1],pair[0]);
        }

        int oneInDegreeVertex =0;
        for(int key : graph.keySet()){
            if(graph.get(key).size()==1){
                oneInDegreeVertex = key;
                break;
            }
        }

        int[] result = new int[graph.size()];
        Set<Integer> visited = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();
        dfs(visited,resultList,oneInDegreeVertex);

        for(int i=0;i<resultList.size();i++){
            result[i] = resultList.get(i);
        }

        return result;
    }

    private void buildGraph(int key, int value){
        if(graph.containsKey(key)){
            graph.get(key).add(value);
        } else{
            List<Integer> lst = new ArrayList<>();
            lst.add(value);
            graph.put(key,lst);
        }
    }

    private void dfs(Set<Integer> visited, List<Integer> resultList, int start){
        visited.add(start);
        resultList.add(start);

        for(int v : graph.get(start)){
            if(!visited.contains(v))
                dfs(visited,resultList,v);
        }
    }

}
