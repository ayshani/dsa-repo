package com.gametheory;
/*
2785. Sort Vowels in a String

Alice and Bob are playing a game on a string.

You are given a string s, Alice and Bob will take turns playing the following game where Alice starts first:

On Alice's turn, she has to remove any non-empty substring from s that contains an odd number of vowels.
On Bob's turn, he has to remove any non-empty substring from s that contains an even number of vowels.
The first player who cannot make a move on their turn loses the game. We assume that both Alice and Bob play optimally.

Return true if Alice wins the game, and false otherwise.

The English vowels are: a, e, i, o, and u.



Example 1:

Input: s = "leetcoder"

Output: true

Explanation:
Alice can win the game as follows:

Alice plays first, she can delete the underlined substring in s = "leetcoder" which contains 3 vowels. The resulting string is s = "der".
Bob plays second, he can delete the underlined substring in s = "der" which contains 0 vowels. The resulting string is s = "er".
Alice plays third, she can delete the whole string s = "er" which contains 1 vowel.
Bob plays fourth, since the string is empty, there is no valid play for Bob. So Alice wins the game.

Intuition :
Alice always removes a non-empty substring containing an odd number of vowel letters, while Bob removes a non-empty substring containing an even number of vowel letters. Assuming both play optimally, we can classify the outcomes as follows:

If there are no vowel letters in s, Alice cannot make a move in the first round and will lose the game.

If there is at least one vowel letter in s, Alice can always guarantee a win, regardless of whether the total number of vowels is odd or even.

If s contains an odd number of vowel letters, Alice can remove the entire string s in her first move and win immediately.

If s contains an even number of vowel letters, Alice first removes a substring with an odd number of vowels. Bob then removes a substring with an even number of vowels, leaving an odd number of vowels in the string. At this point, Alice can remove the remainder of the string in subsequent turns and win.

Therefore, the only condition we need to check is whether the string contains at least one vowel letter.

TC : o(n)
SC: o(1)
 */
public class SortVowelsInAString {

    public static void main(String[] args) {
        System.out.println(new SortVowelsInAString().doesAliceWin("leetcoder"));
    }
    public boolean doesAliceWin(String s) {
        return s.chars().
                anyMatch(c -> {
                    return "aeiou".indexOf(c) !=-1;
                });
    }
}
