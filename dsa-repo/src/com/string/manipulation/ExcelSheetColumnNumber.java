package com.string.manipulation;
/*
171. Excel Sheet Column Number

Given a string columnTitle that represents the column title as appears in an Excel sheet, return its
corresponding column number.

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

Input: columnTitle = "A"
Output: 1
TC : o(n)
SC: o(1)
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ABC"));
    }
    public int titleToNumber(String columnTitle) {
        int result =0;
        for(char c: columnTitle.toCharArray()){
            int delta = c-'A'+1;
            result = result*26 + delta;
        }
        return result;
    }
}
