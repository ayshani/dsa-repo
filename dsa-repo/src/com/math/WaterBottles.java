package com.math;
/*
1518. Water Bottles

There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water
bottles from the market with one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

Example 1:
Input: numBottles = 9, numExchange = 3
Output: 13
Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 9 + 3 + 1 = 13.

TC : o(logn)
SC: o(1)
 */
public class WaterBottles {

    public static void main(String[] args) {
        System.out.println(new WaterBottles().numWaterBottles(9,3));
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumed = 0;
        while(numBottles >= numExchange){
            int k = numBottles/numExchange;
            consumed += k*numExchange;
            numBottles -= k*numExchange;
            numBottles += k;
        }
        return consumed + numBottles;
    }
}
