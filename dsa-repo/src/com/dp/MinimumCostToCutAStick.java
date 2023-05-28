package com.dp;

import java.util.Arrays;

/*
1547. Minimum Cost to Cut a Stick

Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6
Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.

You should perform the cuts in order, you can change the order of the cuts as you wish.

The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts.
When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of
the stick before the cut). Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.

Example 1:
Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:
The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of length 6
(i.e. the second part of the first cut), the third is done to a rod of length 4 and the last cut is to a rod
of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16
(as shown in the example photo 7 + 4 + 3 + 2 = 16).

Complexity Analysis

Time: O(n ^ 3), where n is the number of cuts. It takes O(n) to calculate each case,
and we have O(n ^ 2) distinct cases.
Memory: O(n ^ 2) for memoisation/tabulation.

Exp:
To make it simpler, we add two sentinel values to cuts - left and right edges of the stick. Then, we sort
the cuts so we can easily identify all cuts between two points. DFS can help us find the most efficient
sequence of cuts. To avoid recomputation, we memoise the best answer for stick between cuts[i] and cuts[j]
 in dp[i][j].
 */
public class MinimumCostToCutAStick {

    public static void main(String[] args) {
        int[] cuts = new int[]{1,3,4,5};
        System.out.println(new MinimumCostToCutAStick().minCost(7,cuts));
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] temp = new int[cuts.length+2];
        for(int i=1;i<temp.length-1;i++){
            temp[i] = cuts[i-1];
        }

        temp[temp.length-1] = n;
        cuts = temp;
        Integer[][] dp =  new Integer[cuts.length][cuts.length];
        return util(0,cuts.length-1,cuts,dp);
    }

    private int util(int start, int end, int[] cuts, Integer[][] dp){
        if(end - start<=1){
            return 0;
        }
        if(dp[start][end] != null)
            return dp[start][end];

        int minCost = Integer.MAX_VALUE;

        for(int i= start+1; i<end;i++){
            int cost = util(start,i,cuts,dp) + util(i,end,cuts,dp);
            minCost = Math.min(minCost, cost);
        }

        int ans = minCost  + cuts[end] - cuts[start];
        return dp[start][end] = ans;
    }
}
