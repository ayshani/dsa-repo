package com.string.manipulation;
/*
3612. Process String with Special Operations I

You are given a string s consisting of lowercase English letters and the special characters: *, #, and %.

Build a new string result by processing s according to the following rules from left to right:

If the letter is a lowercase English letter append it to result.
A '*' removes the last character from result, if it exists.
A '#' duplicates the current result and appends it to itself.
A '%' reverses the current result.
Return the final string result after processing all characters in s.



Example 1:

Input: s = "a#b%*"

Output: "ba"

Explanation:

i	s[i]	Operation	Current result
0	'a'	Append 'a'	"a"
1	'#'	Duplicate result	"aa"
2	'b'	Append 'b'	"aab"
3	'%'	Reverse result	"baa"
4	'*'	Remove the last character	"ba"
Thus, the final result is "ba".

TC : o(2^n)
SC: o(2^n)
 */
public class ProcessStringWithSpecialOperationsI {

    public static void main(String[] args) {
        System.out.println(new ProcessStringWithSpecialOperationsI().processStr("a#b%*"));
    }
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(result.length()>0){
                    result.deleteCharAt(result.length()-1);
                }
            } else if(ch == '#'){
                result.append(result.toString());
            } else if(ch == '%'){
                result.reverse();
            } else{
                result.append(ch);
            }
        }
        return result.toString();
    }
}
