package com.dp;
/*
1639. Number of Ways to Form a Target String Given a Dictionary

You are given a list of strings of the same length words and a string target.

Your task is to form target using the given words under the following rules:

target should be formed from left to right.
To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words
if target[i] = words[j][k].
Once you use the kth character of the jth string of words, you can no longer use the xth character of any string
in words where x <= k. In other words, all characters to the left of or at index k become unusuable for every string.
Repeat the process until you form the string target.
Notice that you can use multiple characters from the same string in words provided the conditions above are met.

Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: words = ["acca","bbbb","caca"], target = "aba"
Output: 6
Explanation: There are 6 ways to form target.
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")

Explanation
res[j] means the number of ways to form target j first characters.
exp -https://www.youtube.com/watch?v=ff4Bz49oyag

Complexity
Time O(S(W + N)),
Space O(N + S)
where N = target.length,
S = words[i].length,
W = words.length


 */
public class NumberOfWaysToFormATargetStringGivenADictionary {

    public static void main(String[] args) {
        String target = "aba", words[] = new String[]{"acca","bbbb","caca"};
        System.out.println(new NumberOfWaysToFormATargetStringGivenADictionary().numWays(words,target));
    }
    public int numWays(String[] words, String target) {
        int n = target.length();
        long mod = 1000000007, res[] = new long[n+1];

        res[0]=1;
        for(int i=0;i<words[0].length();i++){
            // take a count of 26 characters for ith index across all words
            int[] count = new int[26];
            for(String word : words){
                count[word.charAt(i)-'a']++;
            }

            // now iterate over the length of target string and  find the count of ways till j-th one
            // and put it in j+1 - th one
            for(int j=n-1;j>=0;j--){
                res[j+1] +=res[j] * count[target.charAt(j)-'a'] % mod;
            }
        }
        return (int) (res[n]%mod);
    }
}
