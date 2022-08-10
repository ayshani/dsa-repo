package com.array;

import java.util.HashMap;
import java.util.Map;

/*
1711. Count Good Meals

A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal
to a power of two.

You can pick any two different foods to make a good meal.

Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the ith item of food,
return the number of different good meals you can make from this list modulo 109 + 7.

Note that items with different indices are considered different even if they have the same deliciousness value.

Example 1:

Input: deliciousness = [1,3,5,7,9]
Output: 4
Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.

Constraints:

1 <= deliciousness.length <= 10^5
0 <= deliciousness[i] <= 2^20

Logic
------
In this question, we can use the brute force to check pair by pair, and count.
But this O(n^2) solution will give you a TLE.

We can find that we only care about the number of pairs, not what are the pairs.
So we can use a HashMap to reduce the search time by O(1).
We also need to notice that the number in arr is less than or equal to 2^20,
so we can use this info to reduce our search space!

Also since 2^20 + 2^20 = 2^21, so we need to search until 2^21, rather 2^20.
That is the testcase [1048576, 1048576]. Here is the code:

Time Complexity: O(22n) = O(n)
Space Complexity: O(n)
 */
public class CountGoodMeals {

    public static void main(String[] args) {
        int[] delic = new int[]{1,3,5,7,9};
        System.out.println(new CountGoodMeals().countPairs(delic));
    }

    public int countPairs(int[] deliciousness) {
        Map<Integer,Integer> map = new HashMap<>();
        int MOD = 1000000007, answer =0;

        for(int num : deliciousness){
            int sum =1;
            for(int i=0;i<=21;i++){
                if(sum>= num && map.containsKey(sum-num)){
                    answer+= map.get(sum-num);
                    answer%=MOD;
                }
                sum*=2;
            }
            map.put(num , map.getOrDefault(num,0)+1);
        }

        return answer;
    }
}
