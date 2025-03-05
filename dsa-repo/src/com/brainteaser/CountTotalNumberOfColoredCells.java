package com.brainteaser;
/*
2579. Count Total Number of Colored Cells

There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:

At the first minute, color any arbitrary unit cell blue.
Every minute thereafter, color blue every uncolored cell that touches a blue cell.
Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.

Return the number of colored cells at the end of n minutes.



Example 1:

Input: n = 1
Output: 1
Explanation: After 1 minute, there is only 1 blue cell, so we return 1.
Example 2:

Input: n = 2
Output: 5
Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5.

Intuition
In the previous approach, we iterated n - 1 times and added an increasing multiple of 4 in each step.
This resulted in a linear time complexity, which is efficient for moderate values of n but can be avoided with
a direct formula. Instead of looping, we want to express the total count of blue cells as a mathematical equation.

From our earlier observations, we know that we start with a single blue cell and then successively add multiples
of 4: first 4 × 1, then 4 × 2, then 4 × 3, and so on, continuing for n - 1 steps. This means the total count
follows the sum:

1+(4×1)+(4×2)+...+(4×(n−1))

Recognizing that the sum inside the parentheses is simply the arithmetic series 1+2+...+(n−1), we use the formula
for the sum of the first m natural numbers:

1+4×(n−1)×n/2

Expanding and simplifying, we get:

1+2×(n−1)×n

This formula allows us to immediately compute the answer, eliminating the need for iteration.
We can now directly return the result in constant time using this equation.



TC : o(1)
SC: o(1)
 */
public class CountTotalNumberOfColoredCells {

    public static void main(String[] args) {
        System.out.println(new CountTotalNumberOfColoredCells().coloredCells(2));
    }
    public long coloredCells(int n) {
        return 1 + (long) n * (n - 1) * 2;
    }
}
