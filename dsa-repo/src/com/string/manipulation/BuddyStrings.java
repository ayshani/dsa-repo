package com.string.manipulation;
/*
859. Buddy Strings
Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal,
otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the
characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".


Example 1:

Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

TC : o(n)
SC: o(1)
 */
public class BuddyStrings {

    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("abcaa","abcbb"));
    }
    public boolean buddyStrings(String s, String goal) {
        int count =0;
        int m = s.length(), n = goal.length();
        if(m!=n)
            return false;
        int swap =0, swapPossible =0;
        boolean[] letterCount = new boolean[26];
        char first = '.', second = '.';
        for(int i=0;i<m;i++){
            // if both character doesn't match
            if(s.charAt(i)!=goal.charAt(i)){
                //if this is the first time , it is not matching
                // so we make swap =1 and keep track of
                // the characters
                if(swap==0){
                    first = s.charAt(i);
                    second = goal.charAt(i);
                    swap=1;
                } else if(swap ==2 ||(swap==1 &&
                        (first!=goal.charAt(i) || second != s.charAt(i)) )){
                    // Incase there are already two swaps hapended before,
                    // then there is no way we cna get the answer a|c to problem.
                    // so return false.

                    // incase if thi can be a second swap but either the first characetr with goal does'nt match
                    // or another character (second) doesn't match with current character in s, we return false,
                    // as if we consider this, it ll be more 2 character swap.
                    return false;
                } else{
                    // incase we already encountered one swap, and oppositely both characetr matches,
                    // so we get our another swap.
                    swap =2;
                }
            } else if(swapPossible==0 && swap ==0){
                // if we hav ealready encountered the character,
                // we can swap it as well or may not.
                // for this reason, we are putting it in
                // swapPossible. e.g. s=aa, goal = aa
                if(letterCount[s.charAt(i)-'a'])
                    swapPossible = 1;
                else
                    // first occuring matched charcters in both s and goal
                    // so we are keeping track
                    letterCount[s.charAt(i)-'a'] = true;
            }
        }

        return (swap!=1) && (swapPossible==1 ) || swap==2;
    }
}
