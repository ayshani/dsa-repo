package com.string.manipulation;
/*
3863. Minimum Operations to Sort a String

You are given a string s consisting of lowercase English letters.

In one operation, you can select any substring of s that is not the entire string and sort it in non-descending alphabetical order.

Return the minimum number of operations required to make s sorted in non-descending order. If it is not possible, return -1.



Example 1:

Input: s = "dog"

Output: 1

Explanation:

Sort substring "og" to "go".

TC : o(n)
SC: o(n)
 */
public class MinimumOperationsToSortAString {

    public static void main(String[] args) {
        System.out.println(new MinimumOperationsToSortAString().minOperations("dog"));
    }
    public int minOperations(String s) {
        int n = s.length();
        char mx = 'a',
                mn = 'z';
        boolean sorted = true;
        for (int i = 0; i < n; i++) {
            mx = (char) Math.max(mx, s.charAt(i));
            mn = (char) Math.min(mn, s.charAt(i));
            if (i > 0 && s.charAt(i - 1) > s.charAt(i)) {
                sorted = false;
            }
        }
        if (sorted) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) {
                return 2;
            }
        }
        return 3;
    }
}
