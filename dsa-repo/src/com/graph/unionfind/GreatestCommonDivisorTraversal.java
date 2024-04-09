package com.graph.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
2709. Greatest Common Divisor Traversal

You are given a 0-indexed integer array nums, and you are allowed to traverse between its indices. You can traverse
between index i and index j, i != j, if and only if gcd(nums[i], nums[j]) > 1, where gcd is the greatest common
divisor.

Your task is to determine if for every pair of indices i and j in nums, where i < j, there exists a sequence of
traversals that can take us from i to j.

Return true if it is possible to traverse between all such pairs of indices, or false otherwise.



Example 1:

Input: nums = [2,3,6]
Output: true
Explanation: In this example, there are 3 possible pairs of indices: (0, 1), (0, 2), and (1, 2).
To go from index 0 to index 1, we can use the sequence of traversals 0 -> 2 -> 1, where we move from index 0 to
index 2 because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 > 1, and then move from index 2 to index 1 because
gcd(nums[2], nums[1]) = gcd(6, 3) = 3 > 1.
To go from index 0 to index 2, we can just go directly because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 > 1.
Likewise, to go from index 1 to index 2, we can just go directly because gcd(nums[1], nums[2]) = gcd(3, 6) = 3 > 1.

 */
public class GreatestCommonDivisorTraversal {

    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisorTraversal()
                .canTraverseAllPairs(new int[]{6,9,12}));
    }
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if(n==1)
            return true;

        UnionFind2709 uf = new UnionFind2709(n);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]==1)
                return false;
            for(int factor : getPrimeFactors(nums[i])){
                if(map.containsKey(factor)){
                    uf.union(map.get(factor) , i);
                } else{
                    map.put(factor, i);
                }
            }
        }
        return uf.count == 1;
    }

    private List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();

        for(int i=2;i*i<= num; i++){
            if(num%i==0){
                factors.add(i);
                while(num%i==0){
                    num /= i;
                }
            }
        }
        if(num!=1)
            factors.add(num);
        return factors;
    }

}

class UnionFind2709{
    int[] parent, rank;
    int count;
    public UnionFind2709(int n){
        parent =  new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        count =n;
    }

    public int find(int x){
        return parent[x]==x ? x : find(parent[x]);
    }

    public void union(int x, int y){
        int px = find(x), py = find(y);
        if(px==py){
            return;
        }
        if(rank[px]>rank[py]){
            parent[py] = px;
        } else if(rank[px]<rank[py]){
            parent[px] = py;
        } else{
            parent[py] = px;
            rank[px]++;
        }
        count--;
    }
}


