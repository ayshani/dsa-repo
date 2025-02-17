package com.recursion.memoization;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
1079. Letter Tile Possibilities

You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.



Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

TC : o(2^n * n)
SC: o(2^n * n)
 */
public class LetterTilePossibilities {

    public static void main(String[] args) {
        System.out.println(new LetterTilePossibilities().numTilePossibilities("AAB"));
    }
    public int numTilePossibilities(String tiles) {
        Set<String> seen = new HashSet<>();

        // Sort characters to handle duplicates efficiently
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        String sortedTiles = new String(chars);

        // Find all unique sequences and their permutations
        return generateSequences(sortedTiles, "", 0, seen) - 1;
    }

    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        int result = 1;
        for (int num = 2; num <= n; num++) {
            result *= num;
        }
        return result;
    }

    private int generateSequences(
            String tiles,
            String current,
            int pos,
            Set<String> seen
    ) {
        if (pos >= tiles.length()) {
            // If new sequence found, count its unique permutations
            if (seen.add(current)) {
                return countPermutations(current);
            }
            return 0;
        }

        // Try including and excluding current character
        return (
                generateSequences(tiles, current, pos + 1, seen) +
                        generateSequences(tiles, current + tiles.charAt(pos), pos + 1, seen)
        );
    }

    private int countPermutations(String seq) {
        // Count frequency of each character
        int[] charCount = new int[26];
        for (char ch : seq.toCharArray()) {
            charCount[ch - 'A']++;
        }

        // Calculate permutations using factorial formula
        int total = factorial(seq.length());
        for (int count : charCount) {
            total /= factorial(count);
        }
        return total;
    }
}
