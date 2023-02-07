package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
904. Fruit Into Baskets

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are
represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount
of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.



Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.

TC : o(n)
SC: o(n)
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] fruits = new int[]{0,1,2,2};
        System.out.println(new FruitIntoBaskets().totalFruit(fruits));
    }
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();

        int end =0, start =0, count =0;

        while(end<n){

            while(start<end && map.size()>=2 && !map.containsKey(fruits[end])){
                map.put(fruits[start], map.getOrDefault(fruits[start],0)-1);
                if(map.get(fruits[start])==0)
                    map.remove(fruits[start]);
                start++;
            }
            if(map.size()<2 || map.containsKey(fruits[end])){
                map.put(fruits[end], map.getOrDefault(fruits[end],0)+1);
                end++;
            }
            count = Math.max(count, end- start);
        }
        return count;
    }
}
