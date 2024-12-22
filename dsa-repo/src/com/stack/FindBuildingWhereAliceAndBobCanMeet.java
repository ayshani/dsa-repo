package com.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2940. Find Building Where Alice and Bob Can Meet

You are given a 0-indexed array heights of positive integers, where heights[i] represents the height of the ith building.

If a person is in building i, they can move to any other building j if and only if i < j and heights[i] < heights[j].

You are also given another array queries where queries[i] = [ai, bi]. On the ith query, Alice is in building ai while Bob is in building bi.

Return an array ans where ans[i] is the index of the leftmost building where Alice and Bob can meet on the ith query. If Alice and Bob cannot move to a common building on query i, set ans[i] to -1.



Example 1:

Input: heights = [6,4,8,5,2,7], queries = [[0,1],[0,3],[2,4],[3,4],[2,2]]
Output: [2,5,-1,5,2]
Explanation: In the first query, Alice and Bob can move to building 2 since heights[0] < heights[2] and heights[1] < heights[2].
In the second query, Alice and Bob can move to building 5 since heights[0] < heights[5] and heights[3] < heights[5].
In the third query, Alice cannot meet Bob since Alice cannot move to any other building.
In the fourth query, Alice and Bob can move to building 5 since heights[3] < heights[5] and heights[4] < heights[5].
In the fifth query, Alice and Bob are already in the same building.
For ans[i] != -1, It can be shown that ans[i] is the leftmost building where Alice and Bob can meet.
For ans[i] == -1, It can be shown that there is no building where Alice and Bob can meet.

TC : o(n)
SC: o(n)
 */
public class FindBuildingWhereAliceAndBobCanMeet {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindBuildingWhereAliceAndBobCanMeet().leftmostBuildingQueries(
                new int[]{6,4,8,5,2,7} , new int[][]{{0,1},{0,3},{2,4},{3,4},{2,2}}
        )));
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<FPair> monoStack = new ArrayList<>();
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        List<List<FPair>> newQueries = new ArrayList<>(
                heights.length
        );

        for (int i = 0; i < heights.length; i++) {
            newQueries.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (heights[b] > heights[a] || a == b) {
                result[i] = b;
            } else {
                newQueries.get(b).add(new FPair(heights[a], i));
            }
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            int monoStackSize = monoStack.size();
            for (FPair pair : newQueries.get(i)) {
                int position = search(pair.x, monoStack);
                if (position < monoStackSize && position >= 0) {
                    result[pair.y] = monoStack
                            .get(position)
                            .y;
                }
            }

            while (
                    !monoStack.isEmpty() &&
                            monoStack.get(monoStack.size() - 1).x <= heights[i]
            ) {
                monoStack.remove(monoStack.size() - 1);
            }

            monoStack.add(new FPair(heights[i], i));
        }

        return result;
    }

    private int search(int height, List<FPair> monoStack) {
        int left = 0;
        int right = monoStack.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (monoStack.get(mid).x > height) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

class FPair{
    int x, y;
    public FPair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
