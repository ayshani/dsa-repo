package com.heap.max;

import java.util.PriorityQueue;

/*
1405. Longest Happy String

A string s is called happy if it satisfies the following conditions:

s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy
strings, return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.

TC : o(nlogn)
SC : o(n)
 */
public class LongestHappyString {

    public static void main(String[] args) {
        System.out.println(new LongestHappyString().longestDiverseString(1,1,7));
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((m, n)-> n.count-m.count);

        StringBuilder sb = new StringBuilder();

        if(a>0)
            pq.add(new Pair('a',a));
        if(b>0)
            pq.add(new Pair('b',b));
        if(c>0)
            pq.add(new Pair('c',c));

        while(pq.size()>1){
            Pair most = pq.poll();
            if(most.count>=2){
                sb.append(most.c);
                sb.append(most.c);
                most.count-=2;
            } else
            {
                sb.append(most.c);
                most.count-=1;
            }

            Pair secmost = pq.poll();
            if(secmost.count>=2 && most.count<secmost.count){
                sb.append(secmost.c);
                sb.append(secmost.c);
                secmost.count-=2;
            } else
            {
                sb.append(secmost.c);
                secmost.count-=1;
            }

            if(most.count>0)
                pq.add(most);
            if(secmost.count>0)
                pq.add(secmost);

        }

        if(!pq.isEmpty()){
            if(sb.length() ==0  || sb.charAt(sb.length() - 1) != pq.peek().c){
                if(pq.peek().count>=2){
                    sb.append(pq.peek().c);
                    sb.append(pq.peek().c);
                } else
                    sb.append(pq.peek().c);
            }
        }

        return sb.toString();
    }

}

class Pair{
    char c;
    int count;
    Pair(char c, int count){
        this.c = c;
        this.count = count;
    }
}
