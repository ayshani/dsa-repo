package com.graph.representation;
/*
997. Find the Town Judge

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town
judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person
labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2

Intuition:
Consider trust as a graph, all pairs are directed edge.
The point with in-degree - out-degree = N - 1 become the judge.

Explanation:
Count the degree, and check at the end.

Time Complexity:
Time O(T + N), space O(N)
 */
public class FindTheTownJudge {

    public static void main(String[] args) {
        int[][] trust = new int[][]{
                {1,2}
        };
        System.out.println(new FindTheTownJudge().findJudge(2,trust));
    }
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];
        for(int[] curr : trust){
            count[curr[0]]--;
            count[curr[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(count[i] == n-1)
                return i;
        }
        return -1;
    }
}
