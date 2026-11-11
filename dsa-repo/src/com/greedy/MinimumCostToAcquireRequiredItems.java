package com.greedy;
/*
3789. Minimum Cost to Acquire Required Items

You are given five integers cost1, cost2, costBoth, need1, and need2.

There are three types of items available:

An item of type 1 costs cost1 and contributes 1 unit to the type 1 requirement only.
An item of type 2 costs cost2 and contributes 1 unit to the type 2 requirement only.
An item of type 3 costs costBoth and contributes 1 unit to both type 1 and type 2 requirements.
You must collect enough items so that the total contribution toward type 1 is at least need1 and the total
contribution toward type 2 is at least need2.

Return an integer representing the minimum possible total cost to achieve these requirements.



Example 1:

Input: cost1 = 3, cost2 = 2, costBoth = 1, need1 = 3, need2 = 2

Output: 3

Explanation:

After buying three type 3 items, which cost 3 * 1 = 3, the total contribution to type 1 is 3 (>= need1 = 3) and to
type 2 is 3 (>= need2 = 2).
Any other valid combination would cost more, so the minimum total cost is 3.

TC : o(1)
SC: o(1)
 */
public class MinimumCostToAcquireRequiredItems {

    public static void main(String[] args) {
        System.out.println(new MinimumCostToAcquireRequiredItems().minimumCost(
                3,2,1,3,2
        ));
    }
    public long minimumCost(
            int cost1,
            int cost2,
            int costBoth,
            int need1,
            int need2
    ) {
        long totalCost = 0;

        // Buying separately is cheaper; item 3 is unnecessary
        if (cost1 + cost2 <= costBoth) {
            totalCost = 1L * cost1 * need1 + 1L * cost2 * need2;
        } else {
            // Buy item 3 first until one requirement is fulfilled
            int cnt_3 = Math.min(need1, need2);
            totalCost = 1L * cnt_3 * costBoth;

            need1 -= cnt_3;
            need2 -= cnt_3;

            // Type 1 is still needed; choose the cheaper of items 1 and 3
            if (need1 > 0) {
                totalCost += 1L * need1 * Math.min(cost1, costBoth);
                // Type 2 is still needed; choose the cheaper of items 2 and 3
            } else if (need2 > 0) {
                totalCost += 1L * need2 * Math.min(cost2, costBoth);
            }
        }

        return totalCost;
    }
}
