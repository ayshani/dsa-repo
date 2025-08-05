package com.greedy;
/*
3477. Fruits Into Baskets II

You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.

From left to right, place the fruits according to these rules:

Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
Each basket can hold only one type of fruit.
If a fruit type cannot be placed in any basket, it remains unplaced.
Return the number of fruit types that remain unplaced after all possible allocations are made.



Example 1:

Input: fruits = [4,2,5], baskets = [3,5,4]

Output: 1

Explanation:

fruits[0] = 4 is placed in baskets[1] = 5.
fruits[1] = 2 is placed in baskets[0] = 3.
fruits[2] = 5 cannot be placed in baskets[2] = 4.
Since one fruit type remains unplaced, we return 1.

TC : o(n^2)
SC: o(n)
 */
public class FruitsIntoBasketsII {

    public static void main(String[] args) {
        System.out.println(new FruitsIntoBasketsII().numOfUnplacedFruits(
                new int[]{4,2,5}, new int[]{3,5,4}
        ));
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        int n = baskets.length;
        for(int fruit : fruits){
            int unset = 1;
            for(int i=0;i<n;i++){
                if(fruit <= baskets[i]){
                    baskets[i] = 0;
                    unset =0;
                    break;
                }
            }
            count += unset;
        }
        return count;
    }
}
