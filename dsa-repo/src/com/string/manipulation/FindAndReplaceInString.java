package com.string.manipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
833. Find And Replace in String

You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.

To complete the ith replacement operation:

Check if the substring sources[i] occurs at index indices[i] in the original string s.
If it does not occur, do nothing.
Otherwise if it does occur, replace that substring with targets[i].
For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".

All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.

For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
Return the resulting string after performing all replacement operations on s.

A substring is a contiguous sequence of characters in a string.
Example 1:
Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
Output: "eeebffff"
Explanation:
"a" occurs at index 0 in s, so we replace it with "eee".
"cd" occurs at index 2 in s, so we replace it with "ffff".

Logic
-----
start from right to left
Descending indexes[] with tracking its index.
Verify equality of subring in S source and source.
Replace S if necessay.
Time Complexity: O(SN)
SC : O(n)

 */
public class FindAndReplaceInString {
    public static void main(String[] args) {
        FindAndReplaceInString obj = new FindAndReplaceInString();
        String s = "abcd";
        int[] indices = new int[]{0, 2};
        String[] sources =  new String[]{"a", "cd"}, targets= new String[]{"eee", "ffff"};
        System.out.println(obj.findReplaceString(s,indices,sources,targets));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        if(s==null || s.length()==0)
            return null;
        List<int[]> sorted = new ArrayList<>();

        for(int i=0;i<indices.length;i++){
            sorted.add(new int[]{indices[i],i});
        }

        Collections.sort(sorted,(a, b)-> b[0]-a[0]);
        String aux = s;
        for(int[] index : sorted){
            int i =index[0], j =index[1];
            if(s.length()<(i+sources[j].length()))
                return aux;
            if(s.substring(i,i+sources[j].length()).equals(sources[j]))
                s = s.substring(0,i)+ targets[j]+ s.substring(i+sources[j].length());

        }

        return s;
    }
}
