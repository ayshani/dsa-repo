package com.string.manipulation;

import java.util.*;

/*
1807. Evaluate the Bracket Pairs of a String

You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.

For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
You know the values of a wide range of keys. This is represented by a 2D string array knowledge
where each knowledge[i] = [keyi, valuei] indicates that key keyi has a value of valuei.

You are tasked to evaluate all of the bracket pairs. When you evaluate a bracket pair that contains
some key keyi, you will:

Replace keyi and the bracket pair with the key's corresponding valuei.
If you do not know the value of the key, you will replace keyi and the bracket pair with a question mark "?"
(without the quotation marks).
Each key will appear at most once in your knowledge. There will not be any nested brackets in s.

Return the resulting string after evaluating all of the bracket pairs.



Example 1:

Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
Output: "bobistwoyearsold"
Explanation:
The key "name" has a value of "bob", so replace "(name)" with "bob".
The key "age" has a value of "two", so replace "(age)" with "two".

TC : o(n)
SC : o(n)
 */
public class EvaluateTheBracketPairsOfAString {

    public static void main(String[] args) {
        List<List<String>> pair = new ArrayList<>();
        pair.add(Arrays.asList("name","bob"));
        pair.add(Arrays.asList("age","two"));

        System.out.println(new EvaluateTheBracketPairsOfAString().evaluate("(name)is(age)yearsold",pair));
    }
    public String evaluate(String s, List<List<String>> knowledge) {
        if(s == null)
            return "";

        //build the map
        Map<String,String> map = new HashMap<>();
        for(List<String> pair : knowledge){
            map.put(pair.get(0),pair.get(1));
        }

        int i=0;
        //to avoid String concatenation
        StringBuilder sb = new StringBuilder();
        while(i<s.length()){
            //add all characters until '('
            while(i<s.length() && s.charAt(i)!='('){
                sb.append(s.charAt(i++));
            }
            //no bracket pair
            if(i==s.length()){
                return sb.toString();
            }
            //store the index after '('
            int start =i+1;
            //find the closing bracket ')'
            while(i<s.length() && s.charAt(i)!=')'){
                i++;
            }
            //make key
            String key = s.substring(start,i++);
            //add value to res
            sb.append(map.getOrDefault(key,"?"));

        }
        return sb.toString();
    }
}
