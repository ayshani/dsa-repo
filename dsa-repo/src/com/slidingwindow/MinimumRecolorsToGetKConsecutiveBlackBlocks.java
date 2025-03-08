package com.slidingwindow;
/*
2379. Minimum Recolors to Get K Consecutive Black Blocks

You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

You are also given an integer k, which is the desired number of consecutive black blocks.

In one operation, you can recolor a white block such that it becomes a black block.

Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.



Example 1:

Input: blocks = "WBBWWBBWBW", k = 7
Output: 3
Explanation:
One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
so that blocks = "BBBBBBBWBW".
It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
Therefore, we return 3.

TC : o(n)
SC: o(n)
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public static void main(String[] args) {
        System.out.println(new MinimumRecolorsToGetKConsecutiveBlackBlocks().minimumRecolors("WBBWWBBWBW",7));
    }
    public int minimumRecolors(String blocks, int k) {
        int left = 0, numWhites = 0, numRecolors = Integer.MAX_VALUE;

        // Move right pointer
        for (int right = 0; right < blocks.length(); right++) {
            // Increment numWhites if block at right pointer is white
            if (blocks.charAt(right) == 'W') {
                numWhites++;
            }

            // k consecutive elements are found
            if (right - left + 1 == k) {
                // Update minumum
                numRecolors = Math.min(numRecolors, numWhites);

                // Decrement numWhites if block at left pointer is white
                if (blocks.charAt(left) == 'W') numWhites--;

                // Move left pointer
                left++;
            }
        }
        return numRecolors;
    }
}
