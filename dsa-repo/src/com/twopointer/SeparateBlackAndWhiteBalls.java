package com.twopointer;
/*
2938. Separate Black and White Balls

There are n balls on a table, each ball has a color black or white.

You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.

In each step, you can choose two adjacent balls and swap them.

Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.



Example 1:

Input: s = "101"
Output: 1
Explanation: We can group all the black balls to the right in the following way:
- Swap s[0] and s[1], s = "011".
Initially, 1s are not grouped together, requiring at least 1 step to group them to the right.

Intuition
Our job is to move all the white balls to the front of the string. Each move forward requires one swap. The number
of swaps needed for a white ball equals the gap between its current and final positions. Once the white balls are
in place, the black balls will naturally move to the back.

To find out where each white ball should go, we use a pointer, whitePosition. When we find a white ball,
we calculate how many swaps it needs to reach the position marked by whitePosition. After calculating,
we update whitePosition to the next available spot.

We track the total number of swaps with a counter, totalSwaps. For each white ball, we add its swaps to the counter.
This approach counts all the necessary moves without physically making them.

By the end, totalSwaps will hold the minimum number of swaps required to move the white balls to the front.


TC : o(n)
SC: o(1)
 */
public class SeparateBlackAndWhiteBalls {

    public static void main(String[] args) {
        System.out.println(new SeparateBlackAndWhiteBalls().minimumSteps("101"));
    }
    public long minimumSteps(String s) {
        long whitePosition =0 , totalSwap =0;
        for(int currentPos =0; currentPos < s.length(); currentPos++){
            if(s.charAt(currentPos) == '0'){
                totalSwap += currentPos - whitePosition;
                whitePosition++;
            }
        }
        return totalSwap;
    }
}
