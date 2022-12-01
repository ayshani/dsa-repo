package com.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
187. Repeated DNA Sequences

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings)
that occur more than once in a DNA molecule. You may return the answer in any order.

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

TC : o(n)
SC : o(No of unique 10 characters from S)
 */
public class RepeatedDNASequences {

    public static void main(String[] args) {
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
    public List<String> findRepeatedDnaSequences(String s) {


        List<String> values = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        if(s.length()<=10){
            return values;
        }
        for(int i=0;i<=s.length()-10;i++){
            String current = s.substring(i,i+10);
            map.put(current,map.getOrDefault(current,0)+1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()>1)
                values.add(entry.getKey());
        }

        return values;
    }
}
