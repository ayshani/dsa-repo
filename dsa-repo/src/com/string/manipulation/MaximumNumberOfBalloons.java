package com.string.manipulation;
/*
1189. Maximum Number of Balloons

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.



Example 1:



Input: text = "nlaebolko"
Output: 1

TC : o(n)
SC: o(1)
 */
public class MaximumNumberOfBalloons {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfBalloons().maxNumberOfBalloons("nlaebolko"));
    }
    public int maxNumberOfBalloons(String text) {
        int b=0;
        int a=0;
        int l=0;
        int o=0;
        int n=0;

        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }

        return Math.min(b,Math.min(a,Math.min(n,Math.min(l/2,o/2))));
    }
}
