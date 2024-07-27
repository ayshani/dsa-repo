package com.graph.shortestpathalgorithm.allsource;

import java.util.Arrays;

/*
2976. Minimum Cost to Convert String I

You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English letters.
You are also given two 0-indexed character arrays original and changed, and an integer array cost, where cost[i]
represents the cost of changing the character original[i] to the character changed[i].

You start with the string source. In one operation, you can pick a character x from the string and change it to the
character y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x,
and changed[j] == y.

Return the minimum cost to convert the string source to the string target using any number of operations.
If it is impossible to convert source to target, return -1.

Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].



Example 1:

Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"],
changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
Output: 28
Explanation: To convert the string "abcd" to string "acbe":
- Change value at index 1 from 'b' to 'c' at a cost of 5.
- Change value at index 2 from 'c' to 'e' at a cost of 1.
- Change value at index 2 from 'e' to 'b' at a cost of 2.
- Change value at index 3 from 'd' to 'e' at a cost of 20.
The total cost incurred is 5 + 1 + 2 + 20 = 28.
It can be shown that this is the minimum possible cost.

TC : o(m+n)
SC: o(1)
 */
public class MinimumCostToConvertStringI {

    public static void main(String[] args) {
        System.out.println(new MinimumCostToConvertStringI().minimumCost(
                "abcd","acbe", new char[]{'a','b','c','c','e','d'},
                new char[]{'b','c','b','e','b','e'}, new int[]{2,5,5,1,2,20}
        ));
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long totalCost =0;

        long[][] minCost = new long[26][26];
        for(long[] row : minCost){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Fill the initial conversion costs from the given original,
        // changed, and cost arrays
        for(int i=0;i<original.length;i++){
            int startChar = original[i] -'a';
            int endChar = changed[i] -'a';
            minCost[startChar][endChar] = Math.min(minCost[startChar][endChar],
                    (long)cost[i]);
        }

        // Use Floyd-Warshall algorithm to find the shortest path between any
        // two characters
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    minCost[i][j] = Math.min(minCost[i][j],
                            minCost[i][k]+minCost[k][j]);
                }
            }
        }

        // Calculate the total minimum cost to transform the source string to
        // the target string
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)== target.charAt(i)){
                continue;
            }

            int sourceChar = source.charAt(i) -'a';
            int targetChar = target.charAt(i) -'a';

            if(minCost[sourceChar][targetChar] >= Integer.MAX_VALUE){
                return -1;
            }
            totalCost += minCost[sourceChar][targetChar];
        }
        return totalCost;
    }
}
