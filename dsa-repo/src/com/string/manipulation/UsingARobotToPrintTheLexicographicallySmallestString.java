package com.string.manipulation;
/*
2434. Using a Robot to Print the Lexicographically Smallest String

You are given a string s and a robot that currently holds an empty string t.
Apply one of the following operations until s and t are both empty:

Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
Return the lexicographically smallest string that can be written on the paper.



Example 1:

Input: s = "zza"
Output: "azz"
Explanation: Let p denote the written string.
Initially p="", s="zza", t="".
Perform first operation three times p="", s="", t="zza".
Perform second operation three times p="azz", s="", t="".

TC : o(n)
SC : o(1)
 */
public class UsingARobotToPrintTheLexicographicallySmallestString {

    public static void main(String[] args) {
        System.out.println(new UsingARobotToPrintTheLexicographicallySmallestString().robotWithString("badd"));
    }
    public String robotWithString(String s) {
        int n = s.length();
        char min = s.charAt(n-1);

        char[] minChar = new char[n];

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) < min)
                min = s.charAt(i);

            minChar[i] = min;
        }

        StringBuilder t= new StringBuilder(), paper = new StringBuilder();

        for(int i=0;i<n;i++){
            while(t.length()>0 && t.charAt(t.length()-1) <= minChar[i]){
                paper.append(t.charAt(t.length()-1) );
                t.deleteCharAt(t.length()-1);
            }
            t.append(s.charAt(i));
        }

        return paper.toString() + t.reverse().toString();
    }
}
