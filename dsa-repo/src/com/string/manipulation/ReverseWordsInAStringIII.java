package com.string.manipulation;
/*
557. Reverse Words in a String III

Given a string s, reverse the order of characters in each word within a sentence while still preserving
whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"

Logic
------
Algorithm

The variable lastSpaceIndex stores the index of space character last found. Initialize its value to -1.

Traverse over each character of the string from 0 th index to nth index using pointer strIndex.

As strIndex points to a space character, mark the start and end index of the current word in the variable
startIndex and endIndex as,

The startIndex of the current word is the value of lastSpaceIndex + 1.
The endIndex of the current word is the value of strIndex - 1.
Reverse the characters in the current word using two pointer approach.

Update the lastSpaceIndex to the value of strIndex i.e the index of current space character.
The next iteration will refer to this variable to identify the start position of the next word.

Repeat the process for all the words in the string.

Complexity Analysis

Let NN be the length of string s.

Time Complexity: O(N) The outer loop iterates over N characters to find the start
and end index of every word. The algorithm to reverse the word also iterates N times to perform N/2 swaps.
Thus, the time complexity is O(N+N)=O(N).

Space Complexity: O(1) We use constant extra space to track the last space index.

Report Article Iss
 */
public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"));
    }
    public String reverseWords(String s) {
        int lastSpaceIndex = -1;
        char[] chArray = s.toCharArray();
        int len = s.length();
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                while (startIndex < endIndex) {
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }
}
