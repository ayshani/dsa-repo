package com.dp;

import java.util.Arrays;

/*
1626. Best Team With No Conflicts

You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the
highest overall score. The score of the team is the sum of scores of all the players in the team.

However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has
a strictly higher score than an older player. A conflict does not occur between players of the same age.

Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player,
respectively, return the highest overall score of all possible basketball teams.



Example 1:

Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
Output: 34
Explanation: You can choose all the players.

TC : o(n^2)
SC: o(n)
 */
public class BestTeamWithNoConflicts {

    public static void main(String[] args) {
        int[] scores = new int[]{1,3,5,10,15}, ages = new int[]{1,2,3,4,5};
        System.out.println(new BestTeamWithNoConflicts().bestTeamScore(scores,ages));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] scoreAge = new int[n][2];

        for(int i=0;i<n;i++){
            scoreAge[i][0]= ages[i];
            scoreAge[i][1] = scores[i];
        }
        // Sort in ascending order of age and then by score.
        Arrays.sort(scoreAge, (a, b) -> a[0]==b[0] ? a[1] - b[1] : a[0] - b[0]);
        return findTotalScore(scoreAge);
    }

    private int findTotalScore(int[][] scoreAge){
        int n = scoreAge.length;
        int[] dp = new int[n];
        int answer =0;
        // Initially, the maximum score for each player will be equal to the individual scores.
        for(int i=0;i<n;i++){
            dp[i] = scoreAge[i][1];
            answer = Math.max(answer, dp[i]);
        }

        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                // If the players j and i could be in the same team.
                if(scoreAge[i][1]>= scoreAge[j][1]) {
                    // Update the maximum score for the ith player.
                    dp[i] = Math.max(dp[i], dp[j] + scoreAge[i][1]);
                }
            }
            // Maximum score among all the players.
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
