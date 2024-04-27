package com.dp;

import java.util.Arrays;

/*
514. Freedom Trail

In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the
"Freedom Trail Ring" and use the dial to spell a specific keyword to open the door.

Given a string ring that represents the code engraved on the outer ring and another string key that represents
the keyword that needs to be spelled, return the minimum number of steps to spell all the characters in the keyword.

Initially, the first character of the ring is aligned at the "12:00" direction. You should spell all the characters
in key one by one by rotating ring clockwise or anticlockwise to make each character of the string key aligned at
the "12:00" direction and then by pressing the center button.

At the stage of rotating the ring to spell the key character key[i]:

You can rotate the ring clockwise or anticlockwise by one place, which counts as one step. The final purpose of
the rotation is to align one of ring's characters at the "12:00" direction, where this character must equal key[i].
If the character key[i] has been aligned at the "12:00" direction, press the center button to spell, which also
counts as one step. After the pressing, you could begin to spell the next character in the key (next stage).
Otherwise, you have finished all the spelling.


Example 1:
Input: ring = "godding", key = "gd"
Output: 4
Explanation:
For the first key character 'g', since it is already in place, we just need 1 step to spell this character.
For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make
it become "ddinggo".
Also, we need 1 more step for spelling.
So the final output is 4.

TC : o(k*r^2)
SC: o(k*r)
 */
public class FreedomTrail {

    public static void main(String[] args) {
        System.out.println(new FreedomTrail().findRotateSteps(
                "godding",  "gd"
        ));
    }
    public int findRotateSteps(String ring, String key) {
        int ringLen = ring.length();
        int keyLen = key.length();
        int[][] bestSteps = new int[ringLen][keyLen + 1];
        // Initialize values of best_steps to largest integer
        for (int[] row : bestSteps) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // Initialize last column to zero to represent the word has been spelled
        for (int i = 0; i < ring.length(); i++) {
            bestSteps[i][keyLen] = 0;
        }
        // For each occurrence of the character at keyIndex of key in ring
        // Stores minimum steps to the character from ringIndex of ring
        for (int keyIndex = keyLen - 1; keyIndex >= 0; keyIndex--) {
            for (int ringIndex = 0; ringIndex < ringLen; ringIndex++) {
                for (int charIndex = 0; charIndex < ringLen; charIndex++) {
                    if (ring.charAt(charIndex) == key.charAt(keyIndex)) {
                        /*
                        The recurrence relation calculates the minimum number of steps to find the character at
                        keyIndex of key when the ringIndex of ring is aligned with the "12:00" position.
                        Our recurrence relation is:

                        bestSteps[r][k] = min(bestSteps[r][k], 1 +
                                               countSteps[r, charIndex] + bestSteps[charIndex][key_index + 1])

                        The terms in the recurrence relation represent:

                        bestSteps[ringIndex][keyIndex]: the previous minimum number of steps to that
                                                        occurrence of that character.
                        countSteps[ringIndex, charIndex]: the minimum number of steps between the ringIndex aligned
                                                           with the "12:00" position of ring, and the index of
                                                           charIndex, the next character of the key.
                        1: represents selecting the character by pressing the center button.
                        bestSteps[charIndex][keyIndex + 1]: the number of steps it took to reach charIndex from
                                                            the last character key[keyIndex + 1] the ring spelled.
                         */
                        bestSteps[ringIndex][keyIndex] =
                                Math.min(bestSteps[ringIndex][keyIndex],
                                        1 + countSteps(ringIndex, charIndex, ringLen)
                                                + bestSteps[charIndex][keyIndex + 1]);
                    }
                }
            }
        }
        return bestSteps[0][0];
    }

    // Find the minimum steps between two indexes of ring
    private int countSteps(int curr, int next, int ringLength) {
        int stepsBetween = Math.abs(curr - next);
        int stepsAround = ringLength - stepsBetween;
        return Math.min(stepsBetween, stepsAround);
    }
}
