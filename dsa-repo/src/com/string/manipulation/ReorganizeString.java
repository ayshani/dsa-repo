package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
767. Reorganize String

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

Example 1:

Input: s = "aab"
Output: "aba"

TC : o(nlogn)
SC : o(n)
 */
public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aab"));
    }
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            if(map.get(s.charAt(i))> (n+1)/2)
                return "";
        }
        PriorityQueue<Rpair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pq.offer(new Rpair(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size()>1){
            Rpair cur = pq.poll();
            if(sb.length()==0 || sb.charAt(sb.length()-1)!= cur.c){
                sb.append(cur.c);
                cur.count--;
                if(cur.count>0){
                    pq.offer(cur);
                }
            } else{
                Rpair second = pq.poll();
                sb.append(second.c);
                second.count--;
                if(second.count>0){
                    pq.offer(second);
                }
                pq.offer(cur);
            }
        }

        if(!pq.isEmpty()){
            Rpair cur = pq.poll();
            if(sb.length()==0 || sb.charAt(sb.length()-1)!= cur.c){
                sb.append(cur.c);
            }
        }
        return sb.toString();
    }
}

class Rpair{
    char c;
    int count;
    public Rpair(char c, int count){
        this.c = c;
        this.count =count;
    }
}