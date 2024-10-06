package com.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
1813. Sentence Similarity III

You are given two strings sentence1 and sentence2, each representing a sentence composed of words. A sentence is
a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of only
 uppercase and lowercase English characters.

Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty)
inside one of these sentences such that the two sentences become equal. Note that the inserted sentence must be
separated from existing words by spaces.

For example,

s1 = "Hello Jane" and s2 = "Hello my name is Jane" can be made equal by inserting "my name is" between "Hello" and
"Jane" in s1.
s1 = "Frog cool" and s2 = "Frogs are cool" are not similar, since although there is a sentence "s are" inserted into
 s1, it is not separated from "Frog" by a space.
Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return
false.



Example 1:

Input: sentence1 = "My name is Haley", sentence2 = "My Haley"

Output: true

Explanation:

sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".

TC : o(m+n)
SC: o9m+n)
 */
public class SentenceSimilarityIII {

    public static void main(String[] args) {
        System.out.println(new SentenceSimilarityIII().areSentencesSimilar(
                "My name is Haley",  "My Haley"
        ));
    }
    public boolean areSentencesSimilar(String s1, String s2) {
        Deque<String> deque1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> deque2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
        //Compare the prefixes or beginning of the strings.
        while (
                !deque1.isEmpty() &&
                        !deque2.isEmpty() &&
                        deque1.peek().equals(deque2.peek())
        ) {
            deque1.poll();
            deque2.poll();
        }
        // Compare the suffixes or ending of the strings.
        while (
                !deque1.isEmpty() &&
                        !deque2.isEmpty() &&
                        deque1.peekLast().equals(deque2.peekLast())
        ) {
            deque1.pollLast();
            deque2.pollLast();
        }
        return deque1.isEmpty() || deque2.isEmpty();
    }
}
