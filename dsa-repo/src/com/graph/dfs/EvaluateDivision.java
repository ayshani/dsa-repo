package com.graph.dfs;

import java.util.*;

/*
399. Evaluate Division

You are given an array of variable pairs equations and an array of real numbers values,
where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the
answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero
and that there is no contradiction.



Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0],
queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

TC: o(q*n)
SC: o(n)
 */
public class EvaluateDivision {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(0,List.of("a","b"));
        equations.add(1,List.of("b","c"));
        double[] values = new double[]{2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(0,List.of("a","c"));
        queries.add(1,List.of("b","a"));
        queries.add(2,List.of("a","e"));
        queries.add(3,List.of("a","a"));
        queries.add(4,List.of("x","x"));

        double[] result = new EvaluateDivision().calcEquation(equations,values,queries);
        Arrays.stream(result).forEach(System.out::println);
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String,Double>> graph = makeGraph(equations, values);

        double[] ans = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            ans[i] = dfs(queries.get(i).get(0),queries.get(i).get(1),new HashSet<>(), graph);
        }

        return ans;
    }

    private Map<String, Map<String,Double>> makeGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String,Double>> graph  =  new HashMap<String, Map<String,Double>>();

        for(int i=0;i<equations.size();i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            graph.putIfAbsent(u,new HashMap<>());
            graph.get(u).put(v,values[i]);

            graph.putIfAbsent(v,new HashMap<>());
            graph.get(v).put(u,1/values[i]);
        }

        return graph;
    }

    private double dfs(String src, String dest, HashSet<String> visited, Map<String, Map<String,Double>> graph){
        if(!graph.containsKey(src)){
            return -1.0;
        }
        if(graph.get(src).containsKey(dest))
            return graph.get(src).get(dest);

        visited.add(src);

        for(Map.Entry<String,Double> nbr : graph.get(src).entrySet()){
            if(!visited.contains(nbr.getKey())){
                double weight = dfs(nbr.getKey(),dest,visited,graph);

                if(weight != -1.0){
                    return nbr.getValue()*weight;
                }
            }
        }

        return -1.0;
    }
}
