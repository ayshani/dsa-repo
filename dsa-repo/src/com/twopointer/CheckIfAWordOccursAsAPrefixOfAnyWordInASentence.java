package com.twopointer;
/*
1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence

Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.

Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.

A prefix of a string s is any leading contiguous substring of s.



Example 1:

Input: sentence = "i love eating burger", searchWord = "burg"
Output: 4
Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.

TC : o(n)
SC: o(n)
 */
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

    public static void main(String[] args) {
        System.out.println(new CheckIfAWordOccursAsAPrefixOfAnyWordInASentence().isPrefixOfWord(
                "i love eating burger", "burg"
        ));
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Check for invalid input
        if (
                sentence == null ||
                        searchWord == null ||
                        searchWord.length() > sentence.length()
        ) {
            return -1;
        }

        // Initialize the word position counter
        int currentWordPosition = 1;
        // Initialize the current index in the sentence
        int currentIndex = 0;
        // Get the length of the sentence
        int sentenceLength = sentence.length();

        // Loop through the sentence
        while (currentIndex < sentenceLength) {
            // Skip leading spaces
            while (
                    currentIndex < sentenceLength &&
                            sentence.charAt(currentIndex) == ' '
            ) {
                currentWordPosition++;
                while (
                        currentIndex < sentenceLength &&
                                sentence.charAt(currentIndex) == ' '
                ) {
                    currentIndex++;
                }
            }

            // Check if the current word starts with searchWord
            int matchCount = 0;
            while (
                    currentIndex < sentenceLength &&
                            matchCount < searchWord.length() &&
                            sentence.charAt(currentIndex) == searchWord.charAt(matchCount)
            ) {
                currentIndex++;
                matchCount++;
            }

            // If the entire searchWord matches, return the current word position
            if (matchCount == searchWord.length()) {
                return currentWordPosition;
            }

            // Move to the end of the current word
            while (
                    currentIndex < sentenceLength &&
                            sentence.charAt(currentIndex) != ' '
            ) {
                currentIndex++;
            }
        }

        // If no match is found, return -1
        return -1;
    }
}
