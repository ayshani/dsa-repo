package com.graph.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
886. Possible Bipartition

We want to split a group of n people (labeled from 1 to n) into two groups of any size.
Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that
the person labeled ai does not like the person labeled bi, return true if it is possible
to split everyone into two groups in this way.



Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].

Complexity Analysis
Let EEE be the size of dislikes and NNN be the number of people.

Time complexity: O(N+E)

For TTT operations, the amortized time complexity of the union-find algorithm
(using path compression with union by rank) is O(alpha(T)). Here, alpha(T) is the inverse Ackermann function
that grows so slowly, that it doesn't exceed 4 for all reasonable T (approximately T<10^600).
You can read more about the complexity of union-find here.
 Because the function grows so slowly, we consider it to be O(1). Thus,
 the E operations (iterating over each edge) we perform results in O(E) time.
We are intializing parent and rank arrays, which each need O(N) time.
We also loop through all of the nodes, which takes O(N) time.
Space complexity: O(N+E)

We are using parent and rank arrays, which take up O(N) space each.
O(E) space is also required for the adjancency list.
 */
public class PossibleBipartition {

    public static void main(String[] args) {
        int n = 4, dislikes[][] = new int[][]{{1,2},{1,3},{2,4}};
        System.out.println(new PossibleBipartition().possibleBipartition(n,dislikes));
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] e : dislikes){
            map.computeIfAbsent(e[0], value -> new ArrayList<Integer>()).add(e[1]);
            map.computeIfAbsent(e[1], value -> new ArrayList<Integer>()).add(e[0]);
        }
        UnionFind uf = new UnionFind(n+1);
        for(int node=0;node<=n;node++){
            if(!map.containsKey(node)){
                continue;
            }
            for(int neighbour : map.get(node)){
                if(uf.find(node)== uf.find(neighbour))
                    return false;
                uf.union(map.get(node).get(0),neighbour);
            }
        }
        return true;
    }
}
