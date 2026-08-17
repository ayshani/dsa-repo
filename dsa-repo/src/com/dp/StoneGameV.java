package com.dp;
/*
1563. Stone Game V

There are several stones arranged in a row, and each stone has an associated value which is an integer
given in the array stoneValue.

In each round of the game, Alice divides the row into two non-empty rows (i.e. left row and right row),
then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob
throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row.
If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts
with the remaining row.

The game ends when there is only one stone remaining. Alice's score is initially zero.

Return the maximum score that Alice can obtain.



Example 1:

Input: stoneValue = [6,2,3,4,5,5]
Output: 18
Explanation: In the first round, Alice divides the row to [6,2,3], [4,5,5]. The left row has the value 11 and the
right row has value 14. Bob throws away the right row and Alice's score is now 11.
In the second round Alice divides the row to [6], [2,3]. This time Bob throws away the left row and Alice's score
becomes 16 (11 + 5).
The last round Alice has only one choice to divide the row which is [2], [3]. Bob throws away the right row and
Alice's score is now 18 (16 + 2). The game ends because only one stone is remaining in the row.

Time complexity: O(n^2).

Space complexity: O(n^2).


 */
public class StoneGameV {

    int[][] f;
    int[][] maxl;
    int[][] maxr;

    public static void main(String[] args) {
        System.out.println(new StoneGameV().stoneGameV(new int[]{6,2,3,4,5,5}));
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        f = new int[n][n];
        maxl = new int[n][n];
        maxr = new int[n][n];
        for (int left = n - 1; left >= 0; --left) {
            maxl[left][left] = maxr[left][left] = stoneValue[left];
            int sum = stoneValue[left],
                    suml = 0;
            for (int right = left + 1, i = left - 1; right < n; ++right) {
                sum += stoneValue[right];
                while (i + 1 < right && (suml + stoneValue[i + 1]) * 2 <= sum) {
                    suml += stoneValue[i + 1];
                    ++i;
                }
                if (left <= i) {
                    f[left][right] = Math.max(f[left][right], maxl[left][i]);
                }
                if (i + 1 < right) {
                    f[left][right] = Math.max(
                            f[left][right],
                            maxr[i + 2][right]
                    );
                }
                if (suml * 2 == sum) {
                    f[left][right] = Math.max(
                            f[left][right],
                            maxr[i + 1][right]
                    );
                }
                maxl[left][right] = Math.max(
                        maxl[left][right - 1],
                        sum + f[left][right]
                );
                maxr[left][right] = Math.max(
                        maxr[left + 1][right],
                        sum + f[left][right]
                );
            }
        }
        return f[0][n - 1];
    }
}
