package com.string.manipulation;

import java.util.Arrays;

/*
899. Orderly Queue

You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the
end of the string..

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

Example 1:

Input: s = "cba", k = 1
Output: "acb"
Explanation:
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".

TC : o(n)
SC : o(1)
 */
public class OrderlyQueue {

    public static void main(String[] args) {
        System.out.println(new OrderlyQueue().orderlyQueue("baaca",3));
    }
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); ++i) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
