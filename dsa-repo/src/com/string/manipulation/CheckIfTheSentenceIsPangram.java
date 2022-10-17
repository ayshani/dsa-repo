package com.string.manipulation;
/*
1832. Check if the Sentence Is Pangram

A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram,
or false otherwise.



Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.

TC : o(n)
We need to iterate over sentence for 26 times.
Each iteration takes at most O(n) time.
To sum up, the overall time complexity is O(n)
SC : o(1)
 */
public class CheckIfTheSentenceIsPangram {

    public static void main(String[] args) {
        System.out.println(new CheckIfTheSentenceIsPangram().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
    public boolean checkIfPangram(String sentence) {

        for(int i=0;i<26;i++){
            char currentChar = (char) ('a'+i);
            if(sentence.indexOf(currentChar)==-1)
                return false;
        }

        return true;
    }
}
