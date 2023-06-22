package com.greedy;
/*
714. Best Time to Buy and Sell Stock with Transaction Fee

You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee
representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay
the transaction fee for each transaction.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.


Explanation
--------------
Given any day I, its max profit status boils down to one of the two status below:

(1) buy status:
buy[i] represents the max profit at day i in buy status, given that the last action you took is a buy action
at day K, where K<=i. And you have the right to sell at day i+1, or do nothing.
(2) sell status:
sell[i] represents the max profit at day i in sell status, given that the last action you took is a
sell action at day K, where K<=i. And you have the right to buy at day i+1, or do nothing.

Let's walk through from base case.

Base case:
We can start from buy status, which means we buy stock at day 0.
buy[0]=-prices[0];
Or we can start from sell status, which means we sell stock at day 0.
Given that we don't have any stock at hand in day 0, we set sell status to be 0.
sell[0]=0;

Status transformation:
At day i, we may buy stock (from previous sell status) or do nothing (from previous buy status):
buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
Or
At day i, we may sell stock (from previous buy status) with fee or keep holding (from previous sell status):
sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] + fee);

Finally:
We will return sell[last_day] as our result, which represents the max profit at the last day, given that you took sell action at any day before the last day.

We can apply transaction fee at either buy status or sell status.
TC : o(n)
SC: o(n)
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,2,8,4,9};
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(prices,2));
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n<=1)
            return 0;
        int[] buy = new int[n], sell = new int[n];
        // we buy the stock on 0th day
        buy[0] -= prices[0];

        for(int i=1;i<n;i++){
            // keep the same stock as day i-1, or buy from sell status at day i-1
            //At day i, we may do nothing (from previous buy status)
            // or buy stock (from previous sell status)
            buy[i] = Math.max(buy[i-1], sell[i-1]-prices[i]);
            // keep the same as day i-1, or sell from buy status at day i-1
            //At day i, we may keep holding (from previous sell status)
            // or we may sell stock (from previous buy status) with fee
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]-fee);
        }
        return sell[n-1];
    }
}
