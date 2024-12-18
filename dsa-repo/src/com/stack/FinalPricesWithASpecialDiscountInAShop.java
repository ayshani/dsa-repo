package com.stack;

import java.util.Arrays;
import java.util.Stack;

/*
1475. Final Prices With a Special Discount in a Shop

You are given an integer array prices where prices[i] is the price of the ith item in a shop.

There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.

Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.



Example 1:

Input: prices = [8,4,6,2,3]
Output: [4,2,4,2,3]
Explanation:
For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
For items 3 and 4 you will not receive any discount at all.

TC : o(n)
SC : o(n)
 */
public class FinalPricesWithASpecialDiscountInAShop {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FinalPricesWithASpecialDiscountInAShop().finalPrices(
                new int[]{8,4,6,2,3}
        )));
    }
    public int[] finalPrices(int[] prices) {
        int[] result = prices.clone();
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<prices.length;i++){
            while(!st.isEmpty() && prices[st.peek()] >= prices[i]){
                result[st.pop()] -= prices[i];
            }
            st.add(i);
        }
        return result;
    }
}
