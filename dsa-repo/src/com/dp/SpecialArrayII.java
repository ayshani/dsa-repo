package com.dp;

import java.util.Arrays;

/*
3152. Special Array II

An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that
subarray
 nums[fromi..toi] is special or not.

Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.



Example 1:

Input: nums = [3,4,1,2,6], queries = [[0,4]]

Output: [false]

Explanation:

The subarray is [3,4,1,2,6]. 2 and 6 are both even.

TC : o(n)
SC: o(n)
 */
public class SpecialArrayII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SpecialArrayII().isArraySpecial(
                new int[]{3,4,1,2,6}, new int[][]{{0,4}}
        )));
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        int[] count = new int[n];
        boolean[] res = new boolean[queries.length];
        dp[0] = true;

        for(int i=1; i<n;i++){
            if(getParity(nums[i-1]) != getParity(nums[i])){
                dp[i] = dp[i-1] && true;
                count[i] = count[i-1];
            } else{
                if(!dp[i-1]){
                    dp[i] = true;
                } else{
                    dp[i] = dp[i-1] && false;
                }
                count[i] = count[i-1] + 1;
            }
        }



        int index =0;
        for(int[] q : queries){
            if(dp[q[0]] == dp[q[1]] && count[q[0]]==count[q[1]]){
                res[index] = true;
            }
            index++;
        }

        return res;
    }

    private boolean getParity(int num){
        return num%2==0;
    }
}
