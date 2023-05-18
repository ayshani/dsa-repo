package com.binarysearch;
/*
744. Find Smallest Letter Greater Than Target

You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character
does not exist, return the first character in letters.

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

TC: o(logn)
SC: o(1)
 */
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = new char[]{'c','f','j'};
        char target = 'a';
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters,target));
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int low =0, high = letters.length-1;
        while(low<high){
            int mid = low +(high-low)/2;

            if(letters[mid]<= target){
                low = mid+1;
            } else{
                high = mid;
            }
        }
        return letters[high]<= target ? letters[0] : letters[high];
    }
}
