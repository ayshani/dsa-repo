package com.array;
/*
2147. Number of Ways to Divide a Long Corridor

Along a long library corridor, there is a line of seats and decorative plants. You are given a 0-indexed string
corridor of length n consisting of letters 'S' and 'P' where each 'S' represents a seat and each 'P' represents a
plant.

One room divider has already been installed to the left of index 0, and another to the right of index n - 1.
Additional room dividers can be installed. For each position between indices i - 1 and i (1 <= i <= n - 1), at
most one divider can be installed.

Divide the corridor into non-overlapping sections, where each section has exactly two seats with any number of
plants. There may be multiple ways to perform the division. Two ways are different if there is a position with a
room divider installed in the first way but not in the second way.

Return the number of ways to divide the corridor. Since the answer may be very large, return it modulo 109 + 7.
If there is no way, return 0.

Example 1:
Input: corridor = "SSPPSPS"
Output: 3
Explanation: There are 3 different ways to divide the corridor.
The black bars in the above image indicate the two room dividers already installed.
Note that in each of the ways, each section has exactly two seats.

TC : o(n)
SC: o(1)

Explanation
---------
Assume a[i] is the index of ith seat,
there are a[i+1] - a[i] ways to put a divider between ith and i+1th seats.
We only needs to calculate the produit of all these a[i+1] - a[i].

If the number of seat is odd or is less than 2, then no way to divide the corridor.
 */
public class NumberOfWaysToDivideALongCorridor {

    public static void main(String[] args) {
        System.out.println(new NumberOfWaysToDivideALongCorridor().numberOfWays("SSPPSPS"));
    }
    public int numberOfWays(String s) {
        long res = 1, j = 0, k = 0, mod = (long)1e9 + 7;


        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'S') {
                if (++k > 2 && k % 2 == 1)
                    res = res * (i - j) % mod;
                j = i;
            }
        }

        return k % 2 == 0 && k > 0 ? (int)res : 0;
    }
}
