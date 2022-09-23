package com.greedy;
/*
1217. Minimum Cost to Move Chips to The Same Position

We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step,
we can change the position of the ith chip from position[i] to:

position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.

Example 1:
Input: position = [2,2,2,3,3]
Output: 2
Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.

Intuition
------------
Notice that we have two types of costs:

Costs 0 when moving to position[i] + 2 or position[i] - 2.
Costs 1 when moving to position[i] + 1 or position[i] - 1.
Since move to position[i] + 2 or position[i] - 2 is free, it is natural to think that firstly
moving chips as close as possible, with 0 cost.

In fact, we can move all chips at even positions to position 0, and move all chips at the odd positions to position 1.
Then, we only have many chips at position 0 and other chips at position 1.
Next, we only need to move those two piles together.
Given two piles of chips located at 0 and 1 respectively, intuitively it would be less effort-taking
(i.e. less cost) to move the smaller pile to the larger one, which makes the total cost to:
Cost=min(even_cnt,odd_cnt)

where even_cnt represents the number of chips at the even positions,
and odd_cnt represents the number of chips at the odd positions.

Good, now we have a not bad cost. Can we do better?
Well, now we will prove that this cost is the smallest possible one.
As for the final position of those chips pile, there are only two possibilities:

The final position is at the even position, or
The final position is at the odd position.
In the first case, we at least need to cost odd_cnt to move all the chips at the odd positions to t
he even positions. Similarly, in the second case, we at least need to cost even_cnt.

Therefore, min(even_cnt, odd_cnt) is the smallest possible cost.

In conclusion, the policy we gave above will achieve the smallest possible cost.
What we need to return is just min(even_cnt, odd_cnt).

Algorithm

We just need to count the number of chips at the even positions and the number of chips at the odd
positions and return the smaller one.

TC : o(n)
SC : o(1)
 */
public class MinimumCostToMoveChipsToTheSamePosition {
    public static void main(String[] args) {
        int[] pos = new int[]{2,2,2,3,3};
        System.out.println(new MinimumCostToMoveChipsToTheSamePosition().minCostToMoveChips(pos));
    }
    public int minCostToMoveChips(int[] position) {
        int evenCount=0, oddCount =0;
        for(int i : position){
            if(i%2==0)
                evenCount++;
            else
                oddCount++;
        }

        return Math.min(evenCount,oddCount);
    }

}
