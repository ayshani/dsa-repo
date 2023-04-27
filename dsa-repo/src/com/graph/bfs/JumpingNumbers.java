package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
Jumping Numbers

Given a positive number X. Find the largest Jumping Number which is smaller than or equal to X.
Jumping Number: A number is called Jumping Number if all adjacent digits in it differ by only 1.
All single-digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping
numbers but 796, 677 and 89098 are not.

Example 1:

Input:
X = 10
Output:
10
Explanation:
10 is the largest Jumping Number
possible for X = 10.


Explanation
-------------
we have to consider each number and generate jumping all numbers
using BFS approach
eg: 1
10 and 12
101 and 121, 123 and it goes on

first level  1, 2, 3, 4, 5, 6, 7, 8, 9
second level 10,12,  21, 23, and so on

so as we are generating all the jumping numbers,

TC: O(K) where k is number of jumping numbers
 */
public class JumpingNumbers {

    public static void main(String[] args) {
        System.out.println(new JumpingNumbers().jumpingNums(50));
    }
    public long jumpingNums(long X) {
        // code here
        if(X<=10)
            return X;
        Queue<Long> q = new LinkedList<>();
        for(int i=1;i<=9;i++){
            q.offer((long)i);
        }

        long ans =0;

        while(!q.isEmpty()){
            long cur = q.poll();
            if(cur>X)
                continue;
            ans = Math.max(ans,cur);
            long digit = cur%10;
            if(digit!=0){
                long add = cur*10 + (digit-1);
                q.offer(add);
            }

            if(digit !=9){
                long add = cur*10 + (digit+1);
                q.offer(add);
            }
        }

        return ans;
    }
}
