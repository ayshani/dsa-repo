package com.string.manipulation;

import java.util.HashSet;
import java.util.Set;

/*
2351. First Letter to Appear Twice

Given a string s consisting of lowercase English letters, return the first letter to appear twice.

Note:

A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
s will contain at least one letter that appears twice.


Example 1:

Input: s = "abccbaacz"
Output: "c"
Explanation:
The letter 'a' appears on the indexes 0, 5 and 6.
The letter 'b' appears on the indexes 1 and 4.
The letter 'c' appears on the indexes 2, 3 and 7.
The letter 'z' appears on the index 8.
The letter 'c' is the first letter to appear twice, because out of all the letters
the index of its second occurrence is the smallest.

TC : o(n)
SC : o(n)
 */
public class FirstLetterToAppearTwice {

    public static void main(String[] args) {
        String s = "abccbaacz";
        System.out.println(new FirstLetterToAppearTwice().repeatedCharacter(s));
    }
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c))
                return c;
            set.add(c);
        }

        return '`';
    }
}
