package com.graph.dfs;

import java.util.*;

/*
947. Most Stones Removed with Same Row or Column

On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone,
return the largest possible number of stones that can be removed.



Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.

TC : o(E)
SC : o(V)
 */
public class MostStonesRemovedWithSameRowOrColumn {

    Map<Integer, List<Integer>> graph;

    public static void main(String[] args) {
        int[][] stones = new int[][]{
                {0,0},{0,2},{1,1},{2,0},{2,2}
        };

        System.out.println(new MostStonesRemovedWithSameRowOrColumn().removeStones(stones));

        System.out.println(new MostStonesRemovedWithSameRowOrColumn().removeStonesV2(stones));
    }
    public int removeStones(int[][] stones) {
        graph = new HashMap<>();

        for(int[] stone : stones){
            graph.computeIfAbsent(stone[0], k-> new ArrayList<>()).add(~stone[1]);
            graph.computeIfAbsent(~stone[1], k-> new ArrayList<>()).add(stone[0]);
        }

        int numberOfIslands =0;
        Set<Integer> visited = new HashSet<>();

        for(int[] stone : stones){
            for(int i=0;i<2;i++){
                int s = i==0 ? stone[0] : ~stone[1];
                if(!visited.contains(s)){
                    numberOfIslands++;
                    dfs(s,visited);
                }
            }
        }
        return stones.length - numberOfIslands;
    }

    private void dfs(int start, Set<Integer> visited){
        if(visited.add(start)){
            for(int next : graph.get(start)){
                dfs(next,visited);
            }
        }
    }

    public int removeStonesV2(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int numberOfIslands =0;

        for(int[] stone : stones){
            if(!visited.contains(stone)){
                numberOfIslands++;
                dfsV2(stone,visited, stones);
            }
        }


        return stones.length - numberOfIslands;
    }

    private void dfsV2(int[] stone, Set<int[]> visited, int[][] stones){
        visited.add(stone);

        for(int[] next : stones){
            if(!visited.contains(next)){
                if( next[0]==stone[0] || next[1]==stone[1]){
                    dfsV2(next,visited,stones);
                }
            }
        }
    }
}
