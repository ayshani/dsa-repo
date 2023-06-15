package com.twopointer;

import java.util.Arrays;

/*
942. DI String Match

A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string
s of length n where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm,
return any of them.

Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]

TC : o(n)
SC: o(1)
 */
public class DIStringMatch {

    public static void main(String[] args) {
        int[] num = new DIStringMatch().diStringMatch("IDID");
        System.out.println(Arrays.toString(num));
    }
    public int[] diStringMatch(String s) {
        int n = s.length();
        int l=0,h=n;
        int[] num = new int[n+1];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='I'){
                num[i] = l++;
            }else{
                num[i] = h--;
            }
        }
        num[n] =l;
        return num;
    }
}
