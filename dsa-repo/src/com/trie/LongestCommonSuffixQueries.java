package com.trie;

import javax.naming.PartialResultException;
import java.util.Arrays;

/*
3093. Longest Common Suffix Queries

You are given two arrays of strings wordsContainer and wordsQuery.

For each wordsQuery[i], you need to find a string from wordsContainer that has the longest common suffix with
wordsQuery[i]. If there are two or more strings in wordsContainer that share the longest common suffix, find the
string that is the smallest in length. If there are two or more such strings that have the same smallest length,
find the one that occurred earlier in wordsContainer.

Return an array of integers ans, where ans[i] is the index of the string in wordsContainer that has the longest common
suffix with wordsQuery[i].



Example 1:

Input: wordsContainer = ["abcd","bcd","xbcd"], wordsQuery = ["cd","bcd","xyz"]

Output: [1,1,1]

Explanation:

Let's look at each wordsQuery[i] separately:

For wordsQuery[0] = "cd", strings from wordsContainer that share the longest common suffix "cd" are at indices 0, 1,
and 2. Among these, the answer is the string at index 1 because it has the shortest length of 3.
For wordsQuery[1] = "bcd", strings from wordsContainer that share the longest common suffix "bcd" are at indices 0, 1,
 and 2. Among these, the answer is the string at index 1 because it has the shortest length of 3.
For wordsQuery[2] = "xyz", there is no string from wordsContainer that shares a common suffix. Hence the longest common
 suffix is "", that is shared with strings at index 0, 1, and 2. Among these, the answer is the string at index 1
 because it has the shortest length of 3.

 Time complexity: O(N+M).

Space complexity: O(N).
 */
public class LongestCommonSuffixQueries {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LongestCommonSuffixQueries().stringIndices(
                new String[]{"abcd","bcd","xbcd"}, new String[]{"cd","bcd","xyz"}
        )));
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        LongestCommonSuffixQueriesTrie trie = new LongestCommonSuffixQueriesTrie();

        for (int i = 0; i < wordsContainer.length; i++) {
            String reversed = new StringBuilder(wordsContainer[i])
                    .reverse()
                    .toString();
            trie.insert(reversed, i);
        }

        int[] res = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            String reversed = new StringBuilder(query).reverse().toString();
            res[i] = trie.query(reversed);
        }

        return res;
    }
}


class LongestCommonSuffixQueriesTrieNode {

    LongestCommonSuffixQueriesTrieNode[] children = new LongestCommonSuffixQueriesTrieNode[26];
    int minLen = Integer.MAX_VALUE;
    int idx = Integer.MAX_VALUE;

    LongestCommonSuffixQueriesTrieNode() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

class LongestCommonSuffixQueriesTrie {

    LongestCommonSuffixQueriesTrieNode root = new LongestCommonSuffixQueriesTrieNode();

    void insert(String s, int idx) {
        int len = s.length();
        LongestCommonSuffixQueriesTrieNode node = root;

        if (len < node.minLen) {
            node.minLen = len;
            node.idx = idx;
        }

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            if (node.children[c] == null) {
                node.children[c] = new LongestCommonSuffixQueriesTrieNode();
            }
            node = node.children[c];

            if (len < node.minLen) {
                node.minLen = len;
                node.idx = idx;
            }
        }
    }

    int query(String s) {
        LongestCommonSuffixQueriesTrieNode node = root;

        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            if (node.children[c] != null) {
                node = node.children[c];
            } else {
                break;
            }
        }

        return node.idx;
    }
}