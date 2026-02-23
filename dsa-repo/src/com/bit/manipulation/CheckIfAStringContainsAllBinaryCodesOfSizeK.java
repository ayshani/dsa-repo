package com.bit.manipulation;

import java.util.HashSet;

/*
1461. Check If a String Contains All Binary Codes of Size K

Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.



Example 1:

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.


TC : o(n)
SC: o(k!)
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

    public static void main(String[] args) {
        System.out.println(new CheckIfAStringContainsAllBinaryCodesOfSizeK().hasAllCodes("00110110", 2));
    }
    public boolean hasAllCodes(String s, int k) {
        if(s==null)
            return false;

        HashSet<String> hs = new HashSet<>();

        int total = 1<<k;

        for(int i=0;i+k<=s.length();i++){
            hs.add(s.substring(i,i+k));
            if(hs.size()==total)
                return true;
        }

        return false;
    }
}
