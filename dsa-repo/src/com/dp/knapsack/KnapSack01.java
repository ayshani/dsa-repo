package com.dp.knapsack;

/*
the 0/1 Knapsack Problem

Statement
Suppose you have a list of weights and corresponding values for n items. You have a knapsack that can carry items
up to a specific maximum weight, known as the capacity of the knapsack.

You want to maximize the sum of values of the items in your knapsack while ensuring that the sum of the weights of
the items remains less than or equal to the knapsack’s capacity.

If all the combinations exceed the given knapsack’s capacity, then return
0
0
.

Note: While adding items in the knapsack, we either add the complete item or don’t add it. Moreover, we can’t add
an item again that is already in the bag.

Let’s say you have a knapsack capacity of 5 and a list of items with weights and values as follows:

weights = [1, 2, 3, 5]

values = [10, 5, 4, 8]

There are four ways of storing items in the knapsack, such that the combined weight of stored items is less than
or equal to the knapsack’s capacity.

Item of weight 1 and weight 2, with a total value of 15.
Item of weight 1 and weight 3, with a total value of 14.
Item of weight 2 and weight 3, with a total value of 9.
Item of weight 5, with a value of 8.
Though all of the combinations described above are valid, we need to select the one with the maximum value. Hence,
we will select items with weights 1 and 2, as they give us the maximum value of 15.

TC : o(n*capacity)
SC: o(n*capacity)
 */
public class KnapSack01 {

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3, 5}, values = new int[]{10, 5, 4, 8};
        System.out.println(new KnapSack01().findKnapsack(5, weights,values,4));
    }
    public  int findKnapsack(int capacity, int[] weights, int[] values, int n){
        // Write your code here
        Integer[][] dp=  new Integer[n+1][capacity+1];
        // your code will replace the placeholder return statement below
        return knapSack(capacity, weights, values, n, dp);
    }

    private  int knapSack(int capacity, int[] weights, int[] values, int n, Integer[][] dp) {
        if(n==0 || capacity==0)
            return 0;
        if(dp[n][capacity]!= null)
            return dp[n][capacity];

        if(weights[n-1]<=capacity){
            dp[n][capacity] = Math.max(values[n-1] + knapSack(capacity-weights[n-1], weights,values,n-1,dp),
                    knapSack(capacity, weights,values,n-1,dp));
        } else {
            dp[n][capacity] = knapSack(capacity, weights,values,n-1,dp);
        }
        return dp[n][capacity];
    }
}
