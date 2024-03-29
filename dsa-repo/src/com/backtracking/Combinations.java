package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

TC : o(nCr * n)
SC: o(k)
 */
public class Combinations {

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4,2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1,k,n,result, new ArrayList<Integer>());
        return result;
    }

    private void backtrack(int start, int k, int n, List<List<Integer>> result, ArrayList<Integer> temp){
        if(temp.size()==k){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i= start;i<=n;i++){
            temp.add(i);
            backtrack(i+1, k,n,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}
