package com.greedy;

import java.util.Arrays;

/*
1833. Maximum Ice Cream Bars

It is a sweltering summer day, and a boy wants to buy some ice cream bars.

At the store, there are n ice cream bars. You are given an array costs of length n,
where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins
to spend, and he wants to buy as many ice cream bars as possible.

Return the maximum number of ice cream bars the boy can buy with coins coins.

Note: The boy can buy the ice cream bars in any order.



Example 1:

Input: costs = [1,3,2,4,1], coins = 7
Output: 4
Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.

TC : o(nlogn)
SC : o(1)
 */
public class MaximumIceCreamBars {

    public static void main(String[] args) {
        int[] costs = new int[]{1,6,3,1,2,5};
        System.out.println(new MaximumIceCreamBars().maxIceCream(costs,20));
    }
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum =0, count=0;
        for(int i=0;i<costs.length;i++){
            if(sum+costs[i]<=coins){
                sum+= costs[i];
                //System.out.println(sum);
                count++;
            }
            //System.out.println(sum +" coins "+coins);
            if(sum==coins){
                //System.out.println(sum +" iiiiii");
                break;
            }
        }

        if(sum<=coins)
            return count;
        return 0;
    }
}
