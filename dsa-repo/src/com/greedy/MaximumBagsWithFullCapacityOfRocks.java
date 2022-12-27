package com.greedy;

import java.util.Arrays;

/*
2279. Maximum Bags With Full Capacity of Rocks

You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks.
The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks.
You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.

Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.

Example 1:

Input: capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
Output: 3
Explanation:
Place 1 rock in bag 0 and 1 rock in bag 1.
The number of rocks in each bag are now [2,3,4,4].
Bags 0, 1, and 2 have full capacity.
There are 3 bags at full capacity, so we return 3.
It can be shown that it is not possible to have more than 3 bags at full capacity.
Note that there may be other ways of placing the rocks that result in an answer of 3.

Intuition
Since we want to fill the bags, thus we only care about the remaining capacity of each bag. For example:

Bag 1 has a capacity of 5 and currently contains 3 rocks.
Bag 2 has a capacity of 20 and currently contians 18 rocks.
It takes the same amount of rocks (2) to fill both bags, so for us there is no difference between
the two bags: they both have 2 remaining capacity.

Therefore, we need to calculate the remaining capacity of each bag i, by letting its
capacity capacity[i] substract the number of rocks it currently has rocks[i].
That is: remaining capacity of bag i = capacity[i] - rocks[i].

As we would like to full as many bags as possible, we will fill the bag with the smallest remaining capacity first.

Therefore, we should sort all the bags by the order of remaining capacity, then start to fill them using
additionalRocks from the bag with the smallest remaining capacity. This process stops when we don't
have enough rocks to fill the current bag. Since we sort by remaining capacity, all subsequent bags will
have no less remaining capacity than the current one, so if we can't fill this bag, it means we can't fill
any of the bags after it.


Complexity Analysis
Let nnn be the size of the input array capacity.

Time complexity: O(n⋅logn)

We use an array remaining_capacity to store the remaining capacity of each bag and it takes O(n) time.
Sorting remaining_capacity requires O(n⋅logn) time.
We iterate over the sorted array remaining_capacity and it takes O(n) time.
To sum up, the overall time complexity is O(n⋅logn).
Space complexity: O(n)

We use an array of size nnn to store the remaining capacity of each bag.
 */
public class MaximumBagsWithFullCapacityOfRocks {

    public static void main(String[] args) {
        int[] capacity = new int[]{2,3,4,5}, rocks = new int[]{1,2,4,4};
        int additionalRocks=2;

        System.out.println(new MaximumBagsWithFullCapacityOfRocks().maximumBags(capacity,rocks,additionalRocks));
    }
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length, fullBag =0;
        int[] remainingCapacity = new int[n];
        // Sort bags by the remaining capacity.
        for(int i=0;i<n;i++){
            remainingCapacity[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(remainingCapacity);
        // Iterate over sorted bags and fill them using additional rocks.
        for(int i=0;i<n;i++){
            // If we can fill the current one, fill it and move on.
            // Otherwise, stop the iteration.
            if(additionalRocks>=remainingCapacity[i]){
                additionalRocks-= remainingCapacity[i];
                fullBag++;
            } else
                break;
        }

        // Return `fullBags` after the iteration stops.
        return fullBag;
    }
}
