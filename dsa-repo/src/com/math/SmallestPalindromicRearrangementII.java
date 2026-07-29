package com.math;
/*
3518. Smallest Palindromic Rearrangement II

You are given a palindromic string s and an integer k.

Return the k-th lexicographically smallest palindromic permutation of s. If there are fewer than k distinct palindromic permutations, return an empty string.

Note: Different rearrangements that yield the same palindromic string are considered identical and are counted once.



Example 1:

Input: s = "abba", k = 2

Output: "baab"

Explanation:

The two distinct palindromic rearrangements of "abba" are "abba" and "baab".
Lexicographically, "abba" comes before "baab". Since k = 2, the output is "baab".

Time complexity: O(n⋅σ⋅(σ+min(n,logk))).

For each position in the left half, we enumerate all candidate characters, which costs O(σ).
For every candidate, computing the number of remaining permutations takes O(σ+min(n,logk)).
Therefore, the total time complexity is
O(n⋅σ⋅(σ+min(n,logk))).
The analysis of the permutation-counting procedure is given above.

Space complexity: O(1) or O(n).
 */
public class SmallestPalindromicRearrangementII {

    public static void main(String[] args) {
        System.out.println(new SmallestPalindromicRearrangementII().smallestPalindrome("abba",2));
    }
    private long comb(long n, long m, long k) {
        long res = 1;
        m = Math.min(m, n - m);

        for (long i = 1; i <= m; i++) {
            res = (res * (n - i + 1)) / i;
            if (res > k) {
                return k + 1;
            }
        }
        return res;
    }

    private long permutations(int rem, int[] bucket, long k) {
        long ways = 1;
        for (int i = 0; i < 26; i++) {
            if (bucket[i] == 0) {
                continue;
            }

            ways *= comb(rem, bucket[i], k);
            if (ways > k) {
                break;
            }
            rem -= bucket[i];
        }
        return ways;
    }

    public String smallestPalindrome(String s, long k) {
        int partition = s.length() / 2;
        int[] bucket = new int[26];

        for (int i = 0; i < partition; i++) {
            bucket[s.charAt(i) - 97] += 1;
        }

        StringBuilder left = new StringBuilder();
        long startIndex = 1;

        for (int pos = 0; pos < partition; pos++) {
            for (int i = 0; i < 26; i++) {
                if (bucket[i] == 0) {
                    continue;
                }

                bucket[i] -= 1;

                long ways = permutations(partition - pos - 1, bucket, k);
                if (startIndex + ways > k) {
                    left.append((char) (i + 97));
                    break;
                }

                bucket[i] += 1;
                startIndex += ways;
            }
        }

        if (left.length() < partition) {
            return "";
        }

        if (s.length() % 2 != 0) {
            left.append(s.charAt(partition));
        }

        for (int i = partition - 1; i >= 0; i--) {
            left.append(left.charAt(i));
        }

        return left.toString();
    }
}
