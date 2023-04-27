package com.graph.unionfind;

import java.util.HashMap;
import java.util.Map;

/*
952. Largest Component Size by Common Factor

You are given an integer array of unique positive integers nums. Consider the following graph:

There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.



Example 1:
Input: nums = [4,6,15,35]
Output: 4

TC : o(n*sqrt(n))
SC: o(n)
 */
public class LargestComponentSizeByCommonFactor {

    public static void main(String[] args) {
        int[] nums = new int[]{20,50,9,63};
        System.out.println(new LargestComponentSizeByCommonFactor().largestComponentSize(nums));
    }
    public int largestComponentSize(int[] nums) {

        int n = nums.length;
        int max = nums[0];
        for(int num : nums){
            max = Math.max(num, max);
        }

        UnionFind uf = new UnionFind(max+1);

        for(int num : nums){
            for(int i=2;i*i<=num;i++){
                if(num%i==0){
                    uf.union(num,i);
                    uf.union(num, num/i);
                }
            }
        }

        Map<Integer,Integer> map = new HashMap<>();
        int ans =1;
        for(int num : nums){
            int parent = uf.find(num);
            map.put(parent, map.getOrDefault(parent,0)+1);
            ans = Math.max(ans, map.get(parent));
        }
        return ans;
    }
}
