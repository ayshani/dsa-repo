package com.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/*
797. All Paths From Source to Target

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
(i.e., there is a directed edge from node i to node graph[i][j]).

Example 1:
Input: graph = [[1,2],[3],[3],[]]
            0 ----- 1
            |       |
            |       |
            |       |
            2------ 3
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

TC : o(n)
SC : o(maximum connectivity from source to target) == o(n)
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1,2},{3},{3},{}
        };
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph));
    }
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        result = new ArrayList<>();
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(0);
        dfs(graph, 0,n,cur);
        return result;
    }

    private void dfs(int[][] graph, int start, int end ,List<Integer> cur){
        if(start == end -1){
            result.add(new ArrayList<>(cur));
            return;
        }

        if(graph[start].length>0){
            for(int  i : graph[start]){
                cur.add(i);
                dfs(graph,i,end,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}
