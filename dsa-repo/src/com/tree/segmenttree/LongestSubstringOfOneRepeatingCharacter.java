package com.tree.segmenttree;

import java.util.Arrays;

/*
2213. Longest Substring of One Repeating Character

You are given a 0-indexed string s. You are also given a 0-indexed string queryCharacters of length k and a 0-indexed
array of integer indices queryIndices of length k, both of which are used to describe k queries.

The ith query updates the character in s at index queryIndices[i] to the character queryCharacters[i].

Return an array lengths of length k where lengths[i] is the length of the longest substring of s consisting of only
one repeating character after the ith query is performed.



Example 1:

Input: s = "babacc", queryCharacters = "bcb", queryIndices = [1,3,3]
Output: [3,3,4]
Explanation:
- 1st query updates s = "bbbacc". The longest substring consisting of one repeating character is "bbb" with length 3.
- 2nd query updates s = "bbbccc".
  The longest substring consisting of one repeating character can be "bbb" or "ccc" with length 3.
- 3rd query updates s = "bbbbcc". The longest substring consisting of one repeating character is "bbbb" with length 4.
Thus, we return [3,3,4].

Time complexity: O((n+k)logn).

Building the segment tree initially takes O(n) time. Each query performs a single-point update,
which takes O(logn) time. Therefore, the total time complexity is O(n+klogn).

Space complexity: O(n).

 */
public class LongestSubstringOfOneRepeatingCharacter {

    private char[] sArr;
    private int[] pre, suf, maxLen;
    private char[] leftChar, rightChar;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LongestSubstringOfOneRepeatingCharacter().
                longestRepeating("babacc", "bcb", new int[]{1, 3, 3})));
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();
        sArr = s.toCharArray();
        pre = new int[4 * n];
        suf = new int[4 * n];
        maxLen = new int[4 * n];
        leftChar = new char[4 * n];
        rightChar = new char[4 * n];

        build(1, 0, n - 1);
        int k = queryIndices.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = maxLen[1];
        }
        return ans;
    }

    private void pushUp(int u, int l, int r) {
        int mid = (l + r) >> 1;
        int leftLen = mid - l + 1,
                rightLen = r - mid;
        int left = u << 1,
                right = (u << 1) | 1;
        leftChar[u] = leftChar[left];
        rightChar[u] = rightChar[right];
        pre[u] = pre[left];
        if (pre[left] == leftLen && rightChar[left] == leftChar[right]) {
            pre[u] = pre[left] + pre[right];
        }
        suf[u] = suf[right];
        if (suf[right] == rightLen && rightChar[left] == leftChar[right]) {
            suf[u] = suf[right] + suf[left];
        }
        maxLen[u] = Math.max(maxLen[left], maxLen[right]);
        if (rightChar[left] == leftChar[right]) {
            maxLen[u] = Math.max(maxLen[u], suf[left] + pre[right]);
        }
    }

    private void build(int u, int l, int r) {
        if (l == r) {
            pre[u] = 1;
            suf[u] = 1;
            maxLen[u] = 1;
            leftChar[u] = sArr[l];
            rightChar[u] = sArr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build((u << 1) | 1, mid + 1, r);
        pushUp(u, l, r);
    }

    private void update(int u, int l, int r, int pos, char ch) {
        if (l == r) {
            leftChar[u] = ch;
            rightChar[u] = ch;
            return;
        }
        int mid = (l + r) >> 1;
        if (pos <= mid) {
            update(u << 1, l, mid, pos, ch);
        } else {
            update((u << 1) | 1, mid + 1, r, pos, ch);
        }
        pushUp(u, l, r);
    }
}
