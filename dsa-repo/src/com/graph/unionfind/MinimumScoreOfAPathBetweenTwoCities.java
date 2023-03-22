package com.graph.unionfind;
/*
2492. Minimum Score of a Path Between Two Cities

You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads
where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a
distance equal to distancei. The cities graph is not necessarily connected.

The score of a path between two cities is defined as the minimum distance of a road in this path.

Return the minimum possible score of a path between cities 1 and n.

Note:

A path is a sequence of roads between two cities.
It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple
times along the path.
The test cases are generated such that there is at least one path between 1 and n.


Example 1:

Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
Output: 5
Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
It can be shown that no other path has less score.

TC : o(n)
SC: o(n)
 */
public class MinimumScoreOfAPathBetweenTwoCities {

    public static void main(String[] args) {
        int[][] roads = new int[][]{
                {1,2,9},{2,3,6},{2,4,5},{1,4,7}
        };
        System.out.println(new MinimumScoreOfAPathBetweenTwoCities().minScore(4, roads));
    }

    public int minScore(int n, int[][] roads) {
        UnionFindScore uf = new UnionFindScore(n);
        for(int[] road : roads){
            uf.union(road[0], road[1], road[2]);
        }
        return uf.getMinScore(n);
    }
}

class UnionFindScore{
    int[] parent, minScore;

    public UnionFindScore(int n){
        parent = new int[n+1];
        minScore = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i] =i;
        }
    }

    public int find(int x){
        if(parent[x]==x)
            return x;
        parent[x]= find(parent[x]);
        return parent[x];
    }

    public void union(int a, int b, int len){
        int parentA = find(a), parentB = find(b);
        int minA = minScore[parentA] ==0 ? Integer.MAX_VALUE : minScore[parentA];
        int minB = minScore[parentB] ==0 ? Integer.MAX_VALUE : minScore[parentB];

        minScore[parentA] = Math.min(len, Math.min(minA,minB));
        if(parentA==parentB)
            return;
        parent[parentB] = parentA;

    }

    public int getMinScore(int a){
        int parentA = find(a);
        return minScore[parentA];
    }

}
