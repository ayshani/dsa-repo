package com.string.manipulation;
/*
1513. Number of Substrings With Only 1s

Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.

TC : o(n)
SC: o(1)
 */
public class NumberOfSubstringsWithOnly1s {

    public static void main(String[] args) {
        System.out.println(new NumberOfSubstringsWithOnly1s().numSub("0110111"));
    }
    public int numSub(String s) {
        int modulo = 1000000007;
        long total =0, consecutive =0;
        int length = s.length();

        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            if(c=='0'){
                total += (consecutive * (consecutive+1))/2;
                total %= modulo;
                consecutive =0;
            } else{
                consecutive++;
            }
        }
        total += (consecutive * (consecutive+1))/2;
        total %= modulo;
        return (int) total;
    }
}
