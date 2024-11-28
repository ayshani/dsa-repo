package com.map;

import java.util.HashMap;
import java.util.Map;

/*You are given an m x n binary matrix matrix.

You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).

Return the maximum number of rows that have all values equal after some number of flips.



Example 1:

Input: matrix = [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.
1072. Flip Columns For Maximum Number of Equal Rows


 */
public class FlipColumnsForMaximumNumberOfEqualRows {

    public static void main(String[] args) {
        System.out.println(new FlipColumnsForMaximumNumberOfEqualRows().maxEqualRowsAfterFlips(
                new int[][]{{0,1},{1,1}}
        ));
    }
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // Map to store frequency of each pattern
        Map<String, Integer> patternFrequency = new HashMap<>();

        for (int[] currentRow : matrix) {
            StringBuilder patternBuilder = new StringBuilder("");

            // Convert row to pattern relative to its first element
            for (int col = 0; col < currentRow.length; col++) {
                // 'T' if current element matches first element, 'F' otherwise
                if (currentRow[0] == currentRow[col]) {
                    patternBuilder.append("T");
                } else {
                    patternBuilder.append("F");
                }
            }

            // Convert pattern to string and update its frequency in map
            String rowPattern = patternBuilder.toString();
            patternFrequency.put(
                    rowPattern,
                    patternFrequency.getOrDefault(rowPattern, 0) + 1
            );
        }

        // Find the pattern with maximum frequency
        int maxFrequency = 0;
        for (int frequency : patternFrequency.values()) {
            maxFrequency = Math.max(frequency, maxFrequency);
        }

        return maxFrequency;
    }
}
