package com.string.manipulation;
/*
1717. Maximum Score From Removing Substrings

You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.



Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.

TC : o(n)
SC: o(n) - for string reversal worst case
 */
public class MaximumScoreFromRemovingSubstrings {

    public static void main(String[] args) {
        System.out.println(new MaximumScoreFromRemovingSubstrings().maximumGain(
             "cdbcbbaaabab", 4,5
        ));
    }
    public int maximumGain(String s, int x, int y) {
        if(x<y){
            int temp =x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount =0, bCount =0, total =0;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur == 'a'){
                aCount++;
            } else if(cur=='b'){
                if(aCount>0){
                    aCount--;
                    total+=x;
                } else{
                    bCount++;
                }
            } else{
                total += Math.min(aCount, bCount)*y;
                aCount= bCount =0;
            }
        }
        total += Math.min(aCount, bCount)*y;
        return total;
    }
}
