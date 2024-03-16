package com.heap.max;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
2300. Successful Pairs of Spells and Potions

You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i]
represents the strength of the ith spell and potions[j] represents the strength of the jth potion.

You are also given an integer success. A spell and potion pair is considered successful if the product of their
strengths is at least success.

Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair
with the ith spell.

Example 1:

Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
Output: [4,0,3]
Explanation:
- 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
Thus, [4,0,3] is returned.
TC : o(nlogn)
SC:  o(n)
 */
public class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        int[] s = new int[]{5,1,3}, p = new int[]{1,2,3,4,5};
        int succes =7;

        System.out.println(Arrays.toString(new SuccessfulPairsOfSpellsAndPotions().successfulPairs(s, p, succes)));
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;

        PriorityQueue<int[]> spellPq = new PriorityQueue<>( (a, b) -> (b[1] - a[1]) );
        PriorityQueue<Integer> potionsPq = new PriorityQueue<>();

        for(int i = 0 ;i < n ; i++){
            spellPq.add(new int[]{i, spells[i]});
        }

        for(int i = 0 ;i < potions.length ; i++){
            potionsPq.add(potions[i]);
        }
        System.out.println("potionsPq : "+potionsPq);
        while(!spellPq.isEmpty()){
            int[] spellArr = spellPq.poll();
            System.out.println("spellArr : "+ Arrays.toString(spellArr));
            int index = spellArr[0];
            long spell = spellArr[1];
            while(!potionsPq.isEmpty()){
                long product = potionsPq.peek();

                if(product * spell >= success){
                    break;
                }

                potionsPq.remove();
            }

            spells[index] = potionsPq.size();
        }

        return spells;
    }
}
