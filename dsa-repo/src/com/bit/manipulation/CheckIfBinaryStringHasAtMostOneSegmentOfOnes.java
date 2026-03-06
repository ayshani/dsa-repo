package com.bit.manipulation;
/*
1784. Check if Binary String Has at Most One Segment of Ones

Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.



Example 1:

Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.

TC : o(1)
SC: o(1)
 */
public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public static void main(String[] args) {
        System.out.println(new CheckIfBinaryStringHasAtMostOneSegmentOfOnes().checkOnesSegment("1001"));
    }
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
