package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
MakePalindrome

https://practice.geeksforgeeks.org/contest/weekly-interview-series-71/problems/#

You are given an array of size n. You have to find out if it is possible to make a palindrome string by concatenating
the strings in any order. Provided all the strings given are of equal length.

Example 1:
Input:
n = 4
arr = {"djfh", "gadt", "hfjd", "tdag"}
Output:
YES
Explanation:
You can make the string "djfhgadttdaghfjd", by concatenating the given strings which is a palindrome.

TC : o(n)
SC : o(n)
 */
public class MakePalindrome {

    public static void main(String[] args) {
        String[] ar = new String []{"jhjdf", "sftas", "fgsdf"};
        System.out.println(MakePalindrome.makePalindrome(3,ar));
    }
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
        Map<String,Integer> map = new HashMap<>();

        for(String s : arr){
            if(map.containsKey(s)){
                map.put(s,map.getOrDefault(s,0)+1);
            } else{
                StringBuilder sb = new StringBuilder(s);
                String rev = sb.reverse().toString();
                if(map.containsKey(rev)){
                    map.put(rev,map.get(rev)-1);
                    if(map.get(rev)==0)
                        map.remove(rev);
                } else{
                    map.put(s,1);
                }
            }
        }

        if(map.isEmpty())
            return true;

        if(map.size()==1){
            for(String v : map.keySet()){
                StringBuilder sb = new StringBuilder(v);
                String rev = sb.reverse().toString();

                if(rev.equals(v))
                    return true;
            }
        }

        return false;
    }
}
