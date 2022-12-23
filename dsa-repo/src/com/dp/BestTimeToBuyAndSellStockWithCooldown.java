package com.dp;
/*
309. Best Time to Buy and Sell Stock with Cooldown

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like
(i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

Intuition:
sold[i]=hold[i−1]+price[i]
held[i]=max(held[i−1],reset[i−1]−price[i])
reset[i]=max(reset[i−1],sold[i−1])

Here is how we interpret each formulas:

sold[i]: the previous state of sold can only be held. Therefore, the maximal profits of this state is the
maximal profits of the previous state plus the revenue by selling the stock at the current price.


held[i]: the previous state of held could also be held, i.e. one does no transaction.
Or its previous state could be reset, from which state, one can acquire a stock at the current price point.


reset[i]: the previous state of reset could either be reset or sold.
Both transitions do not involve any transaction with the stock.

Finally, the maximal profits that we can gain from this game would be max(sold[n],reset[n]),
i.e. at the last price point, either we sell the stock or we simply do no transaction,
to have the maximal profits. It makes no sense to acquire the stock at the last price point,
which only leads to the reduction of profits.

Complexity Analysis

Time Complexity: O(N) where N is the length of the input price list.
We have one loop over the input list, and the operation within one iteration takes constant time.

Space Complexity: O(1), constant memory is used regardless the size of the input.
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        int[] price = new int[]{1,2,3,0,2};
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(price));
    }
    public int maxProfit(int[] prices) {

        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
            int preSold = sold;

            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }

        return Math.max(sold, reset);
    }
}
