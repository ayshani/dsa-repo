package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

TC : o(n^2)
SC: o(n)
 */
public class CombinationSumII {

    List<List<Integer>> result;

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(
                new int[]{10,1,2,7,6,1,5}, 8
        ));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result= new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,0,target,new ArrayList<>());
        return result;
    }

    public void solve(int[] candidates, int s, int target, List<Integer> cur){

        if(target==0)
        {
            if(!result.contains(cur))
                result.add(new ArrayList<>(cur));
            return;
        }
        if(target<0)
            return;

        for(int i=s;i<candidates.length;i++){
            if(i>s && candidates[i]== candidates[i-1] )
                continue;
            cur.add(candidates[i]);
            solve(candidates,i+1,target-candidates[i],cur);
            cur.remove(cur.size()-1);
        }
    }
}
