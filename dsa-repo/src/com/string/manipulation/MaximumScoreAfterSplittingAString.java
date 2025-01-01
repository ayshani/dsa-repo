package com.string.manipulation;
/*
1422. Maximum Score After Splitting a String

Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings
(i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right
substring.



Example 1:

Input: s = "011101"
Output: 5
Explanation:
All possible ways of splitting s into two non-empty substrings are:
left = "0" and right = "11101", score = 1 + 4 = 5
left = "01" and right = "1101", score = 1 + 3 = 4
left = "011" and right = "101", score = 1 + 2 = 3
left = "0111" and right = "01", score = 1 + 1 = 2
left = "01110" and right = "1", score = 2 + 1 = 3

TC : o(n)
SC: o(1)
 */
public class MaximumScoreAfterSplittingAString {

    public static void main(String[] args) {
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore("0010011"));
    }
    public int maxScore(String s) {
        int one =0, zero= 0;
        int best = Integer.MIN_VALUE;

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1'){
                one++;
            } else{
                zero++;
            }
            best = Math.max(best, zero - one);
        }
        if(s.charAt(s.length()-1) == '1')
            one++;
        System.out.println(best + " "+ zero +" "+ one);
        return best + one;
    }
}
