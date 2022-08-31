package com.math;

import java.util.HashMap;
import java.util.Map;

/*
914. X of a Kind in a Deck of Cards

In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that
it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.


Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.

Logic
----
Counts all occurrence of all numbers.
Return if the greatest common divisor of counts > 1.

Time Complexity O(N).
SC : o(n)
 */
public class XOfAKindInADeckOfCards {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,3,2,1};
        System.out.println(new XOfAKindInADeckOfCards().hasGroupsSizeX(nums));
    }
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : deck)
            map.put(num, map.getOrDefault(num,0)+1);
        int greatestCommonDivisor =0;
        for(int i: map.values()){
            greatestCommonDivisor = gcd(i,greatestCommonDivisor);
        }

        return greatestCommonDivisor>1;
    }

    private int gcd(int a, int b){
        return b>0 ? gcd(b, a%b) : a;
    }
}
