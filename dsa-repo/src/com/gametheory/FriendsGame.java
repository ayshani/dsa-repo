package com.gametheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Friends Game

Ross and Rachel are playing a game. They have a tree with n nodes numbered 1 to n, rooted at 1. Each node i is
having some number of stones[i] in it .

The tree is given as an array of edges where edges[i] = [ui, vi] is a bidirectional edge between node ui and node vi.

In one move a player can choose 2 stones from some same node and move it to any of the ancestors of that node in
the tree. The player not able to make a move loses. Help them find the winner of the game if they play optimally.
Rachel starts first.

Return "Rachel" if Rachel wins the game or "Ross" if Ross is the winner.

Constraints:

1<= n <= 10^5

0<= edges.length <= n-1

1<= ui, vi <= n

1<= stones[i] <= 10^9



Example:

Input

n = 5
stones=[10, 6, 7, 19, 3]

edges = [
    [1, 2],
    [1, 3],
    [1, 4],
    [2, 5]
]
Output

Rachel

TC : o(n)
SC:  o(n)
 */
public class FriendsGame {

    public static void main(String[] args) {
        int n = 5, stones[] = new int[]{10, 6, 7, 19, 3}, edges[][] = new int[][]{{1,2},{1,3},{1,4},{2,5}};
        System.out.println(new FriendsGame().solve(n,stones,edges));
    }
    String solve(int n, int[] stones, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int x  = edge[0], y = edge[1];
            x--; y--;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int[] depth = new int[n];
        dfs(0,-1,0,depth,graph);
        //System.out.println(Arrays.toString(depth));
        for(int i=0;i<n;i++){
            if(stones[i]%2!=0)
                stones[i]--;
            stones[i] /=2;
        }
        int[] grundy = new int[n];
        for(int i=0;i<n;i++){
            if(stones[i]%2==0){
                grundy[i]=0;
                continue;
            }
            grundy[i]= depth[i];
        }
        System.out.println(Arrays.toString(grundy));
        int xor =0;
        for(int i=0;i<n;i++){
            xor^=grundy[i];
        }
        return (xor!=0) ? "Rachel" : "Ross";
    }

    private void dfs(int cur, int parent, int d, int[] depth, List<List<Integer>> graph) {
        depth[cur] = d;
        for(int next : graph.get(cur)){
            if(next!=parent){
                dfs(next, cur,d+1,depth,graph);
            }
        }
    }
}
