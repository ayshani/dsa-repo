package com.string.manipulation;
/*
1328. Break a Palindrome

Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any
lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically
smallest one possible.

Return the resulting string. If there is no way to replace a character to make it not a palindrome,
return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where
a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc"
is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and
'c' is smaller than 'd'.

Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
Of all the ways, "aaccba" is the lexicographically smallest.

TC : o(n*26) == o(n)
SC : o(n)
 */
public class BreakAPalindrome {
    public static void main(String[] args) {
        System.out.println(new BreakAPalindrome().breakPalindrome("abccba"));
    }
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();

        // if  1 character return empty
        if(n==1)
            return "";

        char[] st = palindrome.toCharArray();

        for(int i=0;i<n;i++){
            // check condition by replacing current char to range 'a' - (currentChar-1)
            // Ex  "acca"  for first char we dont have any lower char then 'a' we move to index 1 with
            // range a-b trials and check each case if it is not palindrom
            char last = i==n-1? 'z'+1 : st[i];

            for(char c = 'a'; c<last;c++){
                if(st[i]==c)
                    continue;
                char oldChar = st[i];
                st[i] = c;
                if(!isPalindrome(st)){
                    return new String(st);
                }
                // reverting to old char if condition not success.
                st[i] = oldChar;
            }
        }
        // return blank if not possible
        return "";
    }

    private boolean isPalindrome(char[] st){
        int i=0,j = st.length-1;
        while(i<=j){
            if(st[i++]!=st[j--])
                return false;
        }

        return true;
    }
}
