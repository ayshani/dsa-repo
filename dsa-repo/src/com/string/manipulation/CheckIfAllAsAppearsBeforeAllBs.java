package com.string.manipulation;
/*
2124. Check if All A's Appears Before All B's

Given a string s consisting of only the characters 'a' and 'b', return true if every 'a' appears before
every 'b' in the string. Otherwise, return false.



Example 1:

Input: s = "aaabbb"
Output: true
Explanation:
The 'a's are at indices 0, 1, and 2, while the 'b's are at indices 3, 4, and 5.
Hence, every 'a' appears before every 'b' and we return true.

TC : o(n)
SC: o(1)
 */
public class CheckIfAllAsAppearsBeforeAllBs {

    public static void main(String[] args) {
        System.out.println(new CheckIfAllAsAppearsBeforeAllBs().checkString("ababaa"));
    }
    public boolean checkString(String s) {
        int lastIndex =-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== 'a'){
                int difIndex = i-lastIndex;
                if(difIndex>1){
                    return false;
                }
                lastIndex = i;
            }
        }
        return true;
    }
}
