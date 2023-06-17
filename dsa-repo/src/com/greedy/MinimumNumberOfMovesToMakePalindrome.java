package com.greedy;
/*
2193. Minimum Number of Moves to Make Palindrome

You are given a string s consisting only of lowercase English letters.

In one move, you can select any two adjacent characters of s and swap them.

Return the minimum number of moves needed to make s a palindrome.

Note that the input will be generated such that s can always be converted to a palindrome.



Example 1:

Input: s = "aabb"
Output: 2
Explanation:
We can obtain two palindromes from s, "abba" and "baab".
- We can obtain "abba" from s in 2 moves: "aabb" -> "abab" -> "abba".
- We can obtain "baab" from s in 2 moves: "aabb" -> "abab" -> "baab".
Thus, the minimum number of moves needed to make s a palindrome is 2.

https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-min-swaps-to-make-palindrome-e931689f8cae

TC : o(n^2)
SC : o(26)
 */
public class MinimumNumberOfMovesToMakePalindrome {

    public static void main(String[] args) {
        MinimumNumberOfMovesToMakePalindrome movesToMakePalindrome =  new MinimumNumberOfMovesToMakePalindrome();
        System.out.println(movesToMakePalindrome.minMovesToMakePalindrome_1("aabb"));
        System.out.println(movesToMakePalindrome.minMovesToMakePalindrome_2("aabb"));
    }
    public int minMovesToMakePalindrome_1(String s) {
        int res = 0;
        while (s.length() > 0) {
            int i = s.indexOf(s.charAt(s.length() - 1));
            if (i == s.length() - 1)
                res += i / 2;
            else {
                res += i;
                s = s.substring(0, i) + s.substring(i + 1);
            }
            s = s.substring(0, s.length() - 1);
        }
        return res;
    }


    public int minMovesToMakePalindrome_2(String s) {
        int minMoves =0;

        // if string is empty or it is not a palindrome return -1
        if(s.length()==0 || !isShuffledPalindrome(s))
            return -1;

        int end = s.length()-1, start =0;
        while(start<end){
            // if s[start] == s[end] shrink the processing window
            if(s.charAt(start)== s.charAt(end)){
                start++;
                end--;
            } else{
                // if we found different chars

                // make an additional iterator from the end
                int i = end;

                // move toward the start until we found the same char
                while(i>start && s.charAt(i) != s.charAt(start)){
                    i--;
                }

                // if we scanned whole the string and found
                // no one, the same char swap char on the
                // start with adjacent char it needs for
                // case when the first char is not on it's
                // right place all other parts of the
                // algorithm don't process a char on the start
                if(i==start){
                    s = swap(s, start,start+1);
                    minMoves++;
                } else{
                    // if the same character found swap all
                    // chars from i to the end
                    while(i<end){
                        s = swap(s,i,i+1);
                        minMoves++;
                        i++;
                    }
                    start++;
                    end--;
                }
            }
        }
        return minMoves;
    }

    private String swap(String s, int start, int i) {
        char c = s.charAt(start);
        s = s.substring(0,start) + s.charAt(i) + s.substring(start+1,i)+ s.charAt(start) + s.substring(i+1);
        return s;
    }

    private boolean isShuffledPalindrome(String s){
        int[] occurence = new int[26];
        for(int i=0;i<s.length();i++){
            occurence[s.charAt(i) -'a']++;
        }
        int oddCount =0;
        for(int value : occurence){
            if(value%2 !=0)
                oddCount++;
        }
        return oddCount<=1;
    }
}
