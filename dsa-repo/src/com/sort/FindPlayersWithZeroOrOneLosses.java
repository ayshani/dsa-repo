package com.sort;

import java.util.*;

/*
2225. Find Players With Zero or One Losses

You are given an integer array matches where matches[i] = [winneri, loseri]
indicates that the player winneri defeated player loseri in a match.

Return a list answer of size 2 where:

answer[0] is a list of all players that have not lost any matches.
answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.

Note:

You should only consider the players that have played at least one match.
The testcases will be generated such that no two matches will have the same outcome.

Example 1:
Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
Output: [[1,2,10],[4,5,7,8]]
Explanation:
Players 1, 2, and 10 have not lost any matches.
Players 4, 5, 7, and 8 each have lost one match.
Players 3, 6, and 9 each have lost two matches.
Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].

Logic
------
build the graph with (vertex, count(indegree)) in sorted manner
then iterate over the map.
    if(value==0)
        put it in list of winner
    if(value==1)
        put it in AtmostOneLost list

TC : O(nlogn)
SC : o(n)
 */
public class FindPlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        int[][] matches = new int[][]{
                {1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}
        };
        List<List<Integer>> res = new FindPlayersWithZeroOrOneLosses().findWinners(matches);
        for(List<Integer> entry : res){
            System.out.println(entry);
        }
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int[] match : matches){
            int winner = match[0], loser = match[1];
            map.put(winner,map.getOrDefault(winner,0));
            map.put(loser,map.getOrDefault(loser,0)+1);
        }
        List<List<Integer>> answerList = Arrays.asList(new ArrayList<Integer>(),new ArrayList<Integer>());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==0){
                answerList.get(0).add(entry.getKey());
            }
            else if(entry.getValue()==1){
                answerList.get(1).add(entry.getKey());
            }
        }
        return answerList;
    }
}
