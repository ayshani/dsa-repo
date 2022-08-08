package com.sort;

import java.util.Arrays;

/*
1996. The Number of Weak Characters in the Game

You are playing a game that contains multiple characters,
and each of the characters has two main properties: attack and defense.
You are given a 2D integer array properties where properties[i] = [attacki, defensei]
represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense
levels strictly greater than this character's attack and defense levels.
More formally, a character i is said to be weak if there exists another character j
where attackj > attacki and defensej > defensei.

Return the number of weak characters.

Example 1:

Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
Example 2:

Input: properties = [[2,2],[3,3]]
Output: 1
Explanation: The first character is weak because the second character has a strictly greater attack and defense.

Logic
------
Sort the list of pairs properties in ascending order of their
attack and then in descending order of the defense value. We can achieve it using the custom comparator.

Initialize the maximum defense value achieved maxDefense to 0.

Iterate over the pairs from right to left and for each pair:

a. If the maxDefense is greater than the defense value of the current character,
increment the value weakCharacters.

b. Update the value of maxDefense if it's smaller than the current defense value.

Return weakCharacters.

TC: o(nlogn)
SC : o(logn)

 */
public class TheNumberOfWeakCharactersInTheGame {

    public static void main(String[] args) {
        int[][] properties = new int[][]{
                {5,5},{6,3},{3,6}
        };

        System.out.println(new TheNumberOfWeakCharactersInTheGame().numberOfWeakCharacters(properties));
    }
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties , (a, b) -> a[0]==b[0] ? b[1] -a[1] : a[0]-b[0]);
        int weakCharacter =0, maxDefence =0;

        for(int i=properties.length-1;i>=0;i--){
            if(properties[i][1]< maxDefence ){
                weakCharacter++;
            }
            maxDefence = Math.max(maxDefence, properties[i][1]);
        }

        return weakCharacter;
    }
}
