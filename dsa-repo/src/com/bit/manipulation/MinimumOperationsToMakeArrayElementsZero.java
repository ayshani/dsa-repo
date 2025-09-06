package com.bit.manipulation;
/*
3495. Minimum Operations to Make Array Elements Zero

You are given a 2D array queries, where queries[i] is of the form [l, r]. Each queries[i] defines an array of integers nums consisting of elements ranging from l to r, both inclusive.

In one operation, you can:

Select two integers a and b from the array.
Replace them with floor(a / 4) and floor(b / 4).
Your task is to determine the minimum number of operations required to reduce all elements of the array to zero for each query. Return the sum of the results for all queries.



Example 1:

Input: queries = [[1,2],[2,4]]

Output: 3

Explanation:

For queries[0]:

The initial array is nums = [1, 2].
In the first operation, select nums[0] and nums[1]. The array becomes [0, 0].
The minimum number of operations required is 1.
For queries[1]:

The initial array is nums = [2, 3, 4].
In the first operation, select nums[0] and nums[2]. The array becomes [0, 3, 1].
In the second operation, select nums[1] and nums[2]. The array becomes [0, 0, 0].
The minimum number of operations required is 2.
The output is 1 + 2 = 3.

TC : o(nlogr)
SC: o(1)
 */
public class MinimumOperationsToMakeArrayElementsZero {

    public static void main(String[] args) {
        System.out.println(new MinimumOperationsToMakeArrayElementsZero().minOperations(
                new int[][]{
                        {1,2},
                        {2,4}
                }
        ));
    }
    public long minOperations(int[][] queries) {
        long res =0;
        for(int[] q : queries){
            long count1 = get(q[1]);
            long count2 = get(q[0]-1);
            res += (count1-count2 +1)/2;
        }
        return res;
    }

    private long get ( int num){
        long count =0;
        int i=1, base =1;
        System.out.println("num :::: "+ num);
        while(base <= num){
            System.out.println("i : " + i + ", bas : "+ base);
            int end = Math.min(base * 2 -1, num);
            count +=(long) ((i+1)/2)* (end - base +1);
            i++;
            base *=2;
        }
        return count;
    }
}
