package com.array;

import java.util.Arrays;

/*
3494. Find the Minimum Amount of Time to Brew Potions

You are given two integer arrays, skill and mana, of length n and m, respectively.

In a laboratory, n wizards must brew m potions in order. Each potion has a mana capacity mana[j] and must pass through all the wizards sequentially to be brewed properly. The time taken by the ith wizard on the jth potion is timeij = skill[i] * mana[j].

Since the brewing process is delicate, a potion must be passed to the next wizard immediately after the current wizard completes their work. This means the timing must be synchronized so that each wizard begins working on a potion exactly when it arrives. ​

Return the minimum amount of time required for the potions to be brewed properly.



Example 1:

Input: skill = [1,5,2,4], mana = [5,1,4,2]

Output: 110
Explanation:

Potion Number	Start time	Wizard 0 done by	Wizard 1 done by	Wizard 2 done by	Wizard 3 done by
0	0	5	30	40	60
1	52	53	58	60	64
2	54	58	78	86	102
3	86	88	98	102	110
As an example for why wizard 0 cannot start working on the 1st potion before time t = 52, consider the case where the wizards started preparing the 1st potion at time t = 50. At time t = 58, wizard 2 is done with the 1st potion, but wizard 3 will still be working on the 0th potion till time t = 60.

TC : o(m*n)
SC: o(n)

Intuition
Each potion must pass through all wizards in order, and each wizard takes skill [ i ] * mana [ j ] time for potion j.
Because potions must move synchronously through wizards.
We simulate the process while ensuring that each wizard starts only when both they and the potion are ready.

Approach
Maintain an array done [ i ] where done [ i ] represents the time when wizard i finishes the last potion processed so far.
For each potion j (from 0 to m-1):
Update the time for each wizard sequentially using:
done [ i + 1 ] = max ( done [ i + 1 ], done [ i ] ) + skill [ i ] * mana [ j ]
This ensures wizard i+1 starts only when both the previous wizard and potion are ready.
Then adjust backward to synchronize potion passing between wizards.
After processing all potions, done[n] gives the total minimum time required.
 */
public class FindTheMinimumAmountOfTimeToBrewPotions {

    public static void main(String[] args) {
        System.out.println(new FindTheMinimumAmountOfTimeToBrewPotions().minTime(
                new int[]{1,5,2,4}, new int[]{5,1,4,2}
        ));
    }
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] done = new long[n + 1];

        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                done[i + 1] = Math.max(done[i + 1], done[i]) + (long) mana[j] * skill[i];
            }
            for (int i = n - 1; i > 0; --i) {
                done[i] = done[i + 1] - (long) mana[j] * skill[i];
            }
        }
        return done[n];
    }
}
