package com.string.manipulation;
/*
3403. Find the Lexicographically Largest String From the Box I

You are given a string word, and an integer numFriends.

Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:

word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
All the split words are put into a box.
Find the lexicographically largest string from the box after all the rounds are finished.



Example 1:

Input: word = "dbca", numFriends = 2

Output: "dbc"

Explanation:

All possible splits are:

"d" and "bca".
"db" and "ca".
"dbc" and "a".

TC : o(n^2)
SC: o(1)
 */
public class FindTheLexicographicallyLargestStringFromTheBoxI {

    public static void main(String[] args) {
        System.out.println(new FindTheLexicographicallyLargestStringFromTheBoxI().answerString(
                "dbca", 2
        ));
    }
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            String s = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (res.compareTo(s) <= 0) {
                res = s;
            }
        }
        return res;
    }
}
