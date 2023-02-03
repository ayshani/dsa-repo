package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
6. Zigzag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

TC : o(n)
SC: o(n)
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING",3));
    }
    public String convert(String s, int numRows) {
        int n = s.length();
        if(n==1 || numRows>n)
            return s;

        Map<Integer,StringBuilder> map = new HashMap<>();
        int count =1, offset =1;
        for(int i=0;i<n;i++){
            map.computeIfAbsent(count,value -> new StringBuilder()).append(s.substring(i,i+1));
            offset = count==numRows? -1 : count==1 ? 1 : offset;
            if(numRows>1)
                count+= offset;
        }
        String str ="";
        for(int i=1;i<=numRows;i++){
            str+= map.get(i);
        }

        return str;
    }
}
