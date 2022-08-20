package com.heap.min;

import java.util.*;

/*
692. Top K Frequent Words

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same
frequency by their lexicographical order.

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
with the number of occurrence being 4, 3, 2 and 1 respectively.

TC : o(nlogn)
SC : o(n)
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        // have the frequency map of inividual word
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        /*
        create min Heap.
        if frequency of two string is same then have in descending order
        else have in increasing order of the frequency
         */
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()== b.getValue() ? b.getKey().compareTo(a.getKey()) :
                        a.getValue()-b.getValue());

        /*
        add to priority queue and if the size become > k
        then poll the min elements
         */
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        /*
        we have now the top k elements.
        As it's a min heap, add the elements by 0th position always.
        so, we can get most frequent element first in result.
         */
        while(!pq.isEmpty()){
            result.add(0,pq.poll().getKey());
        }

        return result;
    }
}
