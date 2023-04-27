package com.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
752. Open the Lock

You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around:
for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels
of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total
number of turns required to open the lock, or -1 if it is impossible.



Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".

TC: o(n)
SC ; o(n)
 */
public class OpenTheLock {

    HashSet<String> visited = new HashSet<>();
    int count;

    public static void main(String[] args) {
        String[] deadends = new String[]{
                "0201","0101","0102","1212","2002"
        };
        System.out.println(new OpenTheLock().openLock(deadends,"0202"));
    }
    public int openLock(String[] deadends, String target) {
        for(String s : deadends){
            visited.add(s);
        }
        count = 0;
        Queue<String> q = new LinkedList<>();

        q.offer("0000");
        while(!q.isEmpty()){
            int size = q.size();

            for(int j=0;j<size;j++){
                String current = q.poll();
                if(visited.contains(current)){
                    continue;
                } else{
                    visited.add(current);
                }
                if(current.equals(target))
                    return count;
                for(int i=0;i<4;i++){
                    String upString = up(current,i);
                    if(!visited.contains(upString))
                        q.offer(upString);
                    String downString = down(current,i);
                    //System.out.println(downString);
                    if(!visited.contains(downString))
                        q.offer(downString);
                }
            }
            count++;
        }

        return -1;
    }

    public String up(String s, int index){
        char c[] = s.toCharArray();
        if(c[index]=='9')
            c[index] ='0';
        else
            c[index] +=1;

        return new String(c);
    }


    public String down(String s, int index){
        char c[] = s.toCharArray();
        if(c[index]=='0')
            c[index] ='9';
        else{

            c[index] -=1;
        }

        return new String(c);
    }
}
