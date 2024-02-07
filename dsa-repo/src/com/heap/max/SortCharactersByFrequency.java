package com.heap.max;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
451. Sort Characters By Frequency


Given a string s, sort it in decreasing order based on the frequency of the characters.
The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Logic
------
have one occurrence map which contains which character occur how many times.
create priorityQueue sorted in maximum occurrence map.entry first.
Iterate over the queue and add the character to string number of the occurrence

TC : o(nlogn)
SC : o(n)
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("cccaaa"));
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Map.Entry e = pq.poll();
            for(int i=0;i<(int)e.getValue();i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
