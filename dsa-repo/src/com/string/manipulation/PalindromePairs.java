package com.string.manipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
336. Palindrome Pairs

Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
so that the concatenation of the two words words[i] + words[j] is a palindrome.

Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]

Idea:
A naive approach here would attempt every possible pairing of words, but that would be inefficient.
Instead, we can figure out what possible words would pair with each word and specifically check for those.

To do this, we'll first have to store each word in a map structure (wmap), with the word as the key and the
index as the value. This way, we can look up any possible matches with the current word as we iterate through words.

The next thing we'll want to do is define a helper function (isPal) to check if a word is a palindrome.
Rather than having to pass it a substring of a word, we can define it to take a range of indexes to check,
so that we're not constantly building new strings.

As we iterate through words, then, each word will possibly match another word in one of three ways:

A blank string word will match on either side with any palindrome word. (e.g. "" will match with "abc" and vice versa)
A full word will match on either side with its backwards version. (e.g. "abc" will match with "cba", and vice versa)
A partial word will match its backwards version on the opposite side if the leftover portion of the word is a
palindrome (e.g. "abcddd" will match with "cba" because "abc" matches with "cba" and "ddd" is a palindrome)
The first check is easy to perform. If we find a blank string, we can iterate through the entire words list an
extra time searching for palindromes to match. We just need to remember not to match the blank string with itself.

For the second check, since we'll eventually iterate to the matching full word, we should only add the one pair at
this time, rather than both, as we'll be able to add the second ordering of the same pair when we get to the second word.

The third check is the most difficult. For this, we'll want to first reverse the current word to its backwards
version (bw), since we'll be matching existing frontwards words in wmap. Then we should iterate through the
indexes of the word itself, testing both sides of the dividing index (j) for being a palindrome.

If a palindrome is found, then we can attempt to lookup the other portion of the word in wmap. If a match is
found, we can push that pair to our answer array (ans). At the end of the iteration of words, we can return ans.

Time Complexity: O(N * M^2) where N is the length of words and M is the average length of the words in words
Space Complexity: O(N) for wmap
 */
public class PalindromePairs {

    public static void main(String[] args) {
        String words[] = new String[]{"abcd","dcba","lls","s","sssll"};
        System.out.println(new PalindromePairs().palindromePairs(words));
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wmap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++)
            wmap.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                for (int j = 0; j < words.length; j++) {
                    String w = words[j];
                    if (isPal(w, 0, w.length()-1) && j != i) {
                        ans.add(List.of(i, j));
                        ans.add(List.of(j, i));
                    }
                }
                continue;
            }
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            String bw = sb.toString();
            if (wmap.containsKey(bw)) {
                int res = wmap.get(bw);
                if (res != i) ans.add(List.of(i, res));
            }
            for (int j = 1; j < bw.length(); j++) {
                if (isPal(bw, 0, j-1)) {
                    String s = bw.substring(j);
                    if (wmap.containsKey(s))
                        ans.add(List.of(i, wmap.get(s)));
                }
                if (isPal(bw, j, bw.length()-1)) {
                    String s = bw.substring(0,j);
                    if (wmap.containsKey(s))
                        ans.add(List.of(wmap.get(s), i));
                }
            }
        }
        return ans;
    }

    private boolean isPal(String word, int i, int j) {
        while (i < j)
            if (word.charAt(i++) != word.charAt(j--)) return false;
        return true;
    }
}
