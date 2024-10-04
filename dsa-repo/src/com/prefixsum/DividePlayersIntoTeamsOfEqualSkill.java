package com.prefixsum;

import java.util.HashMap;
import java.util.Map;

/*
2491. Divide Players Into Teams of Equal Skill

You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player.
Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.

The chemistry of a team is equal to the product of the skills of the players on that team.

Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams
such that the total skill of each team is equal.



Example 1:

Input: skill = [3,2,5,1,3,4]
Output: 22
Explanation:
Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
 */
public class DividePlayersIntoTeamsOfEqualSkill {

    public static void main(String[] args) {
        System.out.println(new DividePlayersIntoTeamsOfEqualSkill().dividePlayers(
                new int[]{3,2,5,1,3,4}
        ));
    }

    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> skillMap = new HashMap<>();

        for (int s : skill) {
            totalSkill += s;
            skillMap.put(s, skillMap.getOrDefault(s, 0) + 1);
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetSkill = totalSkill / (n / 2);
        long totalChemistry = 0;
        // Iterate through unique skill values
        for (int currSkill : skillMap.keySet()) {
            int currFreq = skillMap.get(currSkill);
            int partnerSkill = targetSkill - currSkill;

            // Check if valid partner skill exists with matching frequency
            if (
                    !skillMap.containsKey(partnerSkill) ||
                            currFreq != skillMap.get(partnerSkill)
            ) {
                return -1;
            }

            // Calculate chemistry for all pairs with this skill
            totalChemistry +=
                    (long) currSkill * (long) partnerSkill * (long) currFreq;
        }

        // Return half of total chemistry (as each pair is counted twice)
        return totalChemistry / 2;
    }
}
