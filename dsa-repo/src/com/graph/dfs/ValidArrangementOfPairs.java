package com.graph.dfs;

import java.util.*;

/*
2097. Valid Arrangement of Pairs

You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi].
An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.

Return any valid arrangement of pairs.

Note: The inputs will be generated such that there exists a valid arrangement of pairs.



Example 1:

Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
Output: [[11,9],[9,4],[4,5],[5,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 9 == 9 = start1
end1 = 4 == 4 = start2
end2 = 5 == 5 = start3

TC : o(m+n)
SC : o(m+n)
 */
public class ValidArrangementOfPairs {

    public static void main(String[] args) {
        int[][] pairs = new int[][]{
                {5,1},{4,5},{11,9},{9,4}
        };
        pairs = new ValidArrangementOfPairs().validArrangement(pairs);
        Arrays.stream(pairs).forEach(e -> System.out.println(e[0] +" "+e[1]));
    }
    Map<Integer,List<Integer>> adjMap;
    Map<Integer,Integer> degreeDiff;
    int index;
    public int[][] validArrangement(int[][] pairs) {
        adjMap = new HashMap<>();
        degreeDiff = new HashMap<>();

        for(int[] e:pairs){
            adjMap.putIfAbsent(e[0],new ArrayList<>());
            adjMap.get(e[0]).add(e[1]);
            degreeDiff.put(e[0], degreeDiff.getOrDefault(e[0],0)+1);
            degreeDiff.put(e[1], degreeDiff.getOrDefault(e[1],0)-1);
        }

        int start = pairs[0][0];
        for(Map.Entry<Integer,Integer> entry : degreeDiff.entrySet()){
            if(entry.getValue()>0){
                start = entry.getKey();
                break;
            }
        }

        index = pairs.length-1;

        dfs(start, pairs);

        return pairs;
    }

    private void dfs(int start, int[][] pairs){
        while(adjMap.get(start)!=null && !adjMap.get(start).isEmpty()){
            List<Integer> neighbours = adjMap.get(start);
            int next =  neighbours.get(neighbours.size()-1);
            neighbours.remove(neighbours.size()-1);

            dfs(next, pairs);
            pairs[index][1]= next;
            pairs[index][0]= start;
            index--;
        }
    }

}
