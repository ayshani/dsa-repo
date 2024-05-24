package com.backtracking;
/*
1255. Maximum Score Words Formed by Letters

Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two
or more times).

It is not necessary to use all characters in letters and each letter can only be used once. Score of letters
'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.



Example 1:

Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"],
score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
Output: 23
Explanation:
Score  a=1, c=9, d=5, g=3, o=2
Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
Words "dad" and "dog" only get a score of 21.

TC : o(2^w * L)
SC : o(w)

w : word[].length
L : words[i].length()
 */
public class MaximumScoreWordsFormedByLetters {

    public static void main(String[] args) {
        System.out.println(new MaximumScoreWordsFormedByLetters()
                .maxScoreWords(new String[]{"dog","cat","dad","good"},new char[]{'a','a','c','d','d','d','g','o','o'},
                        new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0}));
    }
    int maxScore;
    int[] frequency;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        maxScore =0;
        frequency = new int[26];

        for(char c : letters){
            frequency[c-'a']++;
        }

        util(words, score, words.length-1, 0,new int[26]);
        return maxScore;
    }

    private void util(String[] words, int[] score, int index, int totalScore, int[] subsetLetters){
        // if we reach the last index, update the max Score
        if(index== -1){
            maxScore = Math.max(maxScore, totalScore);
            return;
        }

        // don't consider the current word
        util(words, score, index-1, totalScore, subsetLetters);

        // consider the current word
        // 1. add total frequency of the current word in subsetLetters
        for(int i=0;i<words[index].length();i++){
            subsetLetters[words[index].charAt(i)-'a']++;
            totalScore += score[words[index].charAt(i)-'a'];
        }
        // 2. check if the frequencies of the considered words till now are in
        //    permissible limit of the actual frequency[] of provided letter.
        //    yes -> call for next word
        if(isValdWord(subsetLetters)){
            util(words, score, index-1, totalScore, subsetLetters);
        }
        // 3. remove the frequencies of the current word letters from subsetLetters
        for(int i=0;i<words[index].length();i++){
            subsetLetters[words[index].charAt(i)-'a']--;
            totalScore -= score[words[index].charAt(i)-'a'];
        }
    }

    private boolean isValdWord(int[] subsetLetters){
        for(int i=0;i<26;i++){
            if(subsetLetters[i]>frequency[i]){
                return false;
            }
        }
        return true;
    }
}
