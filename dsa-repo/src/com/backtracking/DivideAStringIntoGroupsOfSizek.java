package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
2138. Divide a String Into Groups of Size k

A string s can be partitioned into groups of size k using the following procedure:

The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on. Each element can be a part of exactly one group.
For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order, the resultant string should be s.

Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group s has been divided into, using the above procedure.



Example 1:

Input: s = "abcdefghi", k = 3, fill = "x"
Output: ["abc","def","ghi"]
Explanation:
The first 3 characters "abc" form the first group.
The next 3 characters "def" form the second group.
The last 3 characters "ghi" form the third group.
Since all groups can be completely filled by characters from the string, we do not need to use fill.
Thus, the groups formed are "abc", "def", and "ghi".

TC : O(max(n,k))
SC : o(1)
 */
public class DivideAStringIntoGroupsOfSizek {

    public static void main(String[] args) {
        System.out.println(new DivideAStringIntoGroupsOfSizek().divideString("abcdefghi", 3, 'x'));
    }
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>(); // grouped string
        int n = s.length();
        int curr = 0; // starting index of each group
        // split string
        while (curr < n) {
            int end = Math.min(curr + k, n);
            res.add(s.substring(curr, end));
            curr += k;
        }
        // try to fill in the last group
        String last = res.get(res.size() - 1);
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            res.set(res.size() - 1, last);
        }
        return res.toArray(new String[0]);
    }
}
