package com.array;
/*
1128. Number of Equivalent Domino Pairs

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].



Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1

TC : o(n)
SC: o(1)
 */
public class NumberOfEquivalentDominoPairs {

    public static void main(String[] args) {
        System.out.println(new NumberOfEquivalentDominoPairs().numEquivDominoPairs(
                new int[][]{{1,2},{2,1},{3,4},{5,6}}
        ));
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret =0;
        for(int[] domino : dominoes){
            int val = domino[0] < domino[1]
                    ? domino[0]*10+domino[1]
                    : domino[1]*10 +domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
