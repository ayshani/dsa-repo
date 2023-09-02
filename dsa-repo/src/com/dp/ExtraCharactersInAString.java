package com.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
2707. Extra Characters in a String

You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more
non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters
in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.



Example 1:

Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is
only 1 unused character (at index 4), so we return 1.


Logic
---------
The recurrence relation in the dp function is as follows:

A. If the start index reaches the end of the string (start == n), indicating that we have considered all characters
in s, the function returns 0, as no extra characters are needed.
B. If the start index is not at the end of the string, the function considers two possibilities:
      1. Counting the current character at start as an extra character by recursively calling dp with the next
         index (start + 1). This corresponds to the case where the current character is not part of any valid word
         in the dictionary. The result is incremented by 1, as we are counting the current character as an extra.
      2. Iterating over all possible end indices from start to the end of the string. For each end, the function
         checks if the substring s[start:end+1] exists in dictionary. We can convert dictionary to a set before
         starting the DP to make these checks more efficient. If it does, the function recursively calls dp with
         the next index after the valid word's end index, end + 1. The result is updated to the minimum value
         between the current minimum and the value returned from the recursive call.

Complexity Analysis
Let N be the total characters in the string.
Let M be the average length of the strings in dictionary.
Let K be the length of the dictionary.

Time complexity: O(N^3)
. There can be N+1 unique states of the dp method. In each state of dp, we iterate over end, which
is O(N) iterations. In each of these iterations, we create a substring, which costs O(N). Hence, the overall cost
of the dp method is O(N^3)

Space complexity: O(N+M⋅K). The HashSet used to store the strings in the dictionary will incur a cost
of O(M⋅K). Additionally, the dp method will consume stack space and traverse to a depth of NNN in the worst
case scenario, resulting in a cost of O(N).


 */
public class ExtraCharactersInAString {

    public static void main(String[] args) {
        String s  = "leetscode" , dict[] = new String[]{"leet","code","leetcode"};
        System.out.println(new ExtraCharactersInAString().minExtraChar(s,dict));
    }
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));

        return solve(s,0,n,dp,set);
    }

    private int solve(String s, int start, int n, Integer[] dp, Set<String> set){
        if(start==n)
            return 0;

        if(dp[start]!= null)
            return dp[start];

        int ans = solve(s, start+1, n, dp,set) + 1;
        for(int end = start;end<n;end++){
            var currentSubString = s.substring(start, end+1);
            if(set.contains(currentSubString)){
                ans = Math.min(ans, solve(s,end+1,n,dp,set));
            }
        }
        return dp[start] = ans;
    }
}
