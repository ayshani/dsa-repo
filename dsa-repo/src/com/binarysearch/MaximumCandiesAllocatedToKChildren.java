package com.binarysearch;
/*
2226. Maximum Candies Allocated to K Children

You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles together.

You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. Each child can be allocated candies from only one pile of candies and some piles of candies may go unused.

Return the maximum number of candies each child can get.



Example 1:

Input: candies = [5,8,6], k = 3
Output: 5
Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1. We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.

TC : o(nlogn)
SC: o(n)
 */
public class MaximumCandiesAllocatedToKChildren {

    public static void main(String[] args) {
        System.out.println(new MaximumCandiesAllocatedToKChildren().maximumCandies(
                new int[]{5,8,6}, 3
        ));
    }
    public int maximumCandies(int[] candies, long k) {
        // Find the maximum number of candies in any pile
        int maxCandiesInPile = 0;
        for (int i = 0; i < candies.length; i++) {
            maxCandiesInPile = Math.max(maxCandiesInPile, candies[i]);
        }

        // Set the initial search range for binary search
        int left = 0;
        int right = maxCandiesInPile;

        // Binary search to find the maximum number of candies each child can get
        while (left < right) {
            // Calculate the middle value of the current range
            int middle = (left + right + 1) / 2;

            // Check if it's possible to allocate candies so that each child gets 'middle' candies
            if (canAllocateCandies(candies, k, middle)) {
                // If possible, move to the upper half to search for a larger number
                left = middle;
            } else {
                // Otherwise, move to the lower half
                right = middle - 1;
            }
        }

        return left;
    }

    private boolean canAllocateCandies(
            int[] candies,
            long k,
            int numOfCandies
    ) {
        // Initialize the total number of children that can be served
        long maxNumOfChildren = 0;

        // Iterate over all piles to calculate how many children each pile can serve
        for (int pileIndex = 0; pileIndex < candies.length; pileIndex++) {
            maxNumOfChildren += candies[pileIndex] / numOfCandies;
        }

        return maxNumOfChildren >= k;
    }
}
