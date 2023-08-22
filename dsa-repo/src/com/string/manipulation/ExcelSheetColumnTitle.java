package com.string.manipulation;
/*
168. Excel Sheet Column Title

Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...


Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"

TC : o(logn)
SC: o(1)
 */
public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(29));
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            int leastNum = columnNumber%26;
            res.append((char)(leastNum+'A'));
            columnNumber /= 26;
        }

        return res.reverse().toString();
    }
}
