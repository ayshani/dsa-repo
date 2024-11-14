package com.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
2064. Minimized Maximum of Products Distributed to Any Store

You are given an integer n indicating there are n specialty retail stores. There are m product types of varying amounts, which are given as a 0-indexed integer array quantities, where quantities[i] represents the number of products of the ith product type.

You need to distribute all products to the retail stores following these rules:

A store can only be given at most one product type but can be given any amount of it.
After distribution, each store will have been given some number of products (possibly 0). Let x represent the maximum number of products given to any store. You want x to be as small as possible, i.e., you want to minimize the maximum number of products that are given to any store.
Return the minimum possible x.



Example 1:

Input: n = 6, quantities = [11,6]
Output: 3
Explanation: One optimal way is:
- The 11 products of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3
- The 6 products of type 1 are distributed to the other two stores in these amounts: 3, 3
The maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.

TC : o(nlogn)
SC : o(n)
 */
public class MinimizedMaximumOfProductsDistributedToAnyStore {

    public static void main(String[] args) {
        System.out.println(new MinimizedMaximumOfProductsDistributedToAnyStore().minimizedMaximum(
                6, new int[]{11,6}
        ));
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;

        // Helper arrays - useful for the efficient initialization of the
        // priority queue
        List<int[]> typeStorePairsArray = new ArrayList<>();

        // Push all product types to the list, after assigning one store to each of them
        for (int i = 0; i < m; i++) {
            typeStorePairsArray.add(new int[] { quantities[i], 1 });
        }

        PriorityQueue<int[]> typeStorePairs = new PriorityQueue<>((a, b) ->
                Long.compare((long) b[0] * a[1], (long) a[0] * b[1])
        );

        // Initialize the priority queue
        typeStorePairs.addAll(typeStorePairsArray);

        // Iterate over the remaining n - m stores.
        for (int i = 0; i < n - m; i++) {
            // Pop the first element
            int[] pairWithMaxRatio = typeStorePairs.poll();
            int totalQuantityOfType = pairWithMaxRatio[0];
            int storesAssignedToType = pairWithMaxRatio[1];

            // Push the same element after assigning one more store to its product type
            typeStorePairs.offer(
                    new int[] { totalQuantityOfType, storesAssignedToType + 1 }
            );
        }

        // Pop the first element
        int[] pairWithMaxRatio = typeStorePairs.poll();
        int totalQuantityOfType = pairWithMaxRatio[0];
        int storesAssignedToType = pairWithMaxRatio[1];

        // Return the maximum minimum ratio
        return (int) Math.ceil(
                (double) totalQuantityOfType / storesAssignedToType
        );
    }
}
