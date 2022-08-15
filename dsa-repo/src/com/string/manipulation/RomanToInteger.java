package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However,
the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.

The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Logic
-----
have one map of roman to integer mapping.
Iterate over the whole string. we need to store previous letter.
Incase the previous letter is less than the current letter, we subtract the value of previous from sum
and add the difference between current and previous tot eh sum.

TC : o(n)
SC : o(1)
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("LVIII"));
    }
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        if(s==null)
            return 0;

        Integer sum = 0;
        Integer prev =null;

        for(int i=0;i<s.length();i++){
            Integer current = map.get(s.charAt(i));

            if(prev!=null && prev<current){
                sum=sum-prev;
                sum+=current-prev;
            }else
                sum+=current;

            prev = current;
        }

        return sum;
    }
}
