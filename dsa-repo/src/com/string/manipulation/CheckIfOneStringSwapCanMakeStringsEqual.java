package com.string.manipulation;
/*
1790. Check if One String Swap Can Make Strings Equal

You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.



Example 1:

Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".

TC : o(n)
SC: o(1)
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public static void main(String[] args) {
        System.out.println(new CheckIfOneStringSwapCanMakeStringsEqual().areAlmostEqual("bank","kanb"));
    }
    public boolean areAlmostEqual(String s1, String s2) {
        int firstDiffIndex =0, secondDiffIndex =0;
        int numDif =0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                numDif++;
                if(numDif>2)
                    return false;
                else if(numDif ==1){
                    firstDiffIndex = i;
                } else{
                    secondDiffIndex =i;
                }
            }
        }
        return (s1.charAt(firstDiffIndex) == s2.charAt(secondDiffIndex) &&
                s2.charAt(firstDiffIndex) == s1.charAt(secondDiffIndex));
    }
}
