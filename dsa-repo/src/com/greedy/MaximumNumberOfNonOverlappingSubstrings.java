package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1520. Maximum Number of Non-Overlapping Substrings

Given a string s of lowercase letters, you need to find the maximum number of non-empty substrings of s that meet the
following conditions:

The substrings do not overlap, that is for any two substrings s[i..j] and s[x..y], either j < x or i > y is true.
A substring that contains a certain character c must also contain all occurrences of c.
Find the maximum number of substrings that meet the above conditions. If there are multiple solutions with the same
number of substrings, return the one with minimum total length. It can be shown that there exists a unique solution of
minimum total length.

Notice that you can return the substrings in any order.



Example 1:

Input: s = "adefaddaccc"
Output: ["e","f","ccc"]
Explanation: The following are all the possible substrings that meet the conditions:
[
  "adefaddaccc"
  "adefadda",
  "ef",
  "e",
  "f",
  "ccc",
]
If we choose the first string, we cannot choose anything else and we'd get only 1. If we choose "adefadda", we are
left with "ccc" which is the only one that doesn't overlap, thus obtaining 2 substrings. Notice also, that it's not
optimal to choose "ef" since it can be split into two. Therefore, the optimal way is to choose ["e","f","ccc"] which
gives us 3 substrings. No other solution of the same number of substrings exist.

TC : o(nsum  + sumlogsum)
SC: o(sum)
 */
public class MaximumNumberOfNonOverlappingSubstrings {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfNonOverlappingSubstrings().maxNumOfSubstrings("adefaddaccc"));
    }
    public List<String> maxNumOfSubstrings(String s) {
        Seg[] seg = new Seg[26];
        for (int i = 0; i < 26; ++i) {
            seg[i] = new Seg(-1, -1);
        }
        // Preprocess the left and right endpoints.
        for (int i = 0; i < s.length(); ++i) {
            int charIdx = s.charAt(i) - 'a';
            if (seg[charIdx].left == -1) {
                seg[charIdx].left = seg[charIdx].right = i;
            } else {
                seg[charIdx].right = i;
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (seg[i].left != -1) {
                for (int j = seg[i].left; j <= seg[i].right; ++j) {
                    int charIdx = s.charAt(j) - 'a';
                    if (
                            seg[i].left <= seg[charIdx].left &&
                                    seg[charIdx].right <= seg[i].right
                    ) {
                        continue;
                    }
                    seg[i].left = Math.min(seg[i].left, seg[charIdx].left);
                    seg[i].right = Math.max(seg[i].right, seg[charIdx].right);
                    j = seg[i].left;
                }
            }
        }
        // Greedily select intervals.
        Arrays.sort(seg);
        List<String> ans = new ArrayList<>();
        int end = -1;
        for (Seg segment : seg) {
            int left = segment.left,
                    right = segment.right;
            if (left == -1) {
                continue;
            }
            if (end == -1 || left > end) {
                end = right;
                ans.add(s.substring(left, right + 1));
            }
        }
        return ans;
    }

    class Seg implements Comparable<Seg> {

        int left, right;

        public Seg(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int compareTo(Seg rhs) {
            if (right == rhs.right) {
                return rhs.left - left;
            }
            return right - rhs.right;
        }
    }
}
