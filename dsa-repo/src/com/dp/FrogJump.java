package com.dp;

import java.util.HashMap;
import java.util.Map;

/*
403. Frog Jump

A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not
exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by
landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump
in the forward direction.



Example 1:

Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone,
then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.

TC : o(n^2)
SC: o(n^2)
 */
public class FrogJump {

    public static void main(String[] args) {
        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(new FrogJump().canCross(stones));
    }
    Map<Integer,Integer> mark;
    Integer[][] dp;
    public boolean canCross(int[] stones) {
        mark = new HashMap<>();
        dp = new Integer[2001][2001];
        // Mark stones in the map to identify if such stone exists or not.
        for(int i=0;i<stones.length;i++){
            mark.put(stones[i], i);
        }
        return backtrack(stones, stones.length, 0,0);
    }

    private boolean backtrack(int[] stones, int n, int start, int prevJump){
        // If reached the last stone, return 1.
        if(start== n-1){
            return true;
        }
        // If this subproblem has already been calculated, return it.
        if(dp[start][prevJump]!=null)
            return dp[start][prevJump] == 1;

        boolean ans = false;

        // Iterate over the three possibilities {k - 1, k, k + 1}.
        for(int nextJump = prevJump-1; nextJump <=prevJump+1; nextJump++){
            if(nextJump>0 && mark.containsKey(stones[start]+ nextJump)){
                ans = ans || backtrack(stones, n, mark.get(stones[start]+ nextJump), nextJump);
            }
        }

        dp[start][prevJump] = (ans ? 1 : 0);
        return ans;
    }
}
