package com.string.manipulation;
/*
1528. Shuffle String

You are given a string s and an integer array indices of the same length.
Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

Return the shuffled string.

TC : o(n)
SC : o(n)
 */
public class ShuffleString {

    public static void main(String[] args) {
        int[] indices = new int[]{4,5,6,7,0,2,1,3};
        System.out.println(new ShuffleString().restoreString("codeleet", indices));
    }
    public String restoreString(String s, int[] indices) {
        char[] aux = s.toCharArray();

        for(int i=0;i<indices.length;i++){
            aux[indices[i]] = s.charAt(i);
        }

        return String.valueOf(aux);
    }
}
