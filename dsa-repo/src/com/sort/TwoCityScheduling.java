package com.sort;

import java.util.Arrays;

/*
 * 1029. Two City Scheduling
 *
 * A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti],
 * the cost of flying the ith person to city a is aCosti,
 * and the cost of flying the ith person to city b is bCosti.
 *
 * Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
 *
 * Example 1:
 * Input: costs = [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 * Logic
 * ---------------
 * sort the array wrt city B.
 * this means we will have cost to travel B city in increasing order.
 * And another point is as there are costs.length people,
 * then it will always be costs.length/2 to go to A city and another costs.length/2 to B city.
 * so, we will iterate over the whole whole costs array/2
 * and sum up one from left side for city B and another from right side for city A.
 *
 * TC : o(nlogn)
 * SC : o(1)
 */
public class TwoCityScheduling {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] costs = new int[][] {
                {10,20},{30,200},{400,50},{30,20}
        };
        TwoCityScheduling obj = new TwoCityScheduling();
        System.out.println(obj.twoCitySchedCost(costs));
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) ->((a[1]-a[0])-(b[1]-b[0])));

        int cost = 0, n = costs.length;

        for(int i=0; i<n/2; i++){
            cost += costs[i][1] + costs[n-1-i][0];
        }

        return cost;
    }
}

