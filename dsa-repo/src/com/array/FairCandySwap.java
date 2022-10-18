package com.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
888. Fair Candy Swap

Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes
where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number
of candies of the jth box of candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have
the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each
box they have.

Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange,
and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers,
you may return any one of them. It is guaranteed that at least one answer exists.

Example 1:

Input: aliceSizes = [1,1], bobSizes = [2,2]
Output: [1,2]

Logic
-------
If Alice swaps candy x, she expects some specific quantity of candy y back.

Say Alice and Bob have total candy S_A, S_B respectively.

S_A -x + y = S_B -y + x
=> 2y - 2x = S_B - S_A
=> y = x + (S_B - S_A)/2

Our strategy is simple. For every candy xx that Alice has, if Bob has candy y = x + (S_B - S_A)/2,
we return [x,y] We use a Set structure to check whether Bob has the desired candy y in constant time.

Complexity Analysis

Time Complexity: O(A.length+B.length).

Space Complexity: O(B.length), the space used by setB.
(We can improve this to min(A.length,B.length) by using an if statement.)

 */
public class FairCandySwap {

    public static void main(String[] args) {
        int[] a = new int[]{1,2}, b = new int[]{2,3};
        int[] res = new FairCandySwap().fairCandySwap(a,b);
        Arrays.stream(res).forEach(value -> System.out.print(value +" "));
    }
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int totalA = 0, totalB =0;
        for(int x: aliceSizes)
            totalA+=x;
        Set<Integer> setBob = new HashSet<>();
        for(int y: bobSizes){
            totalB+=y;
            setBob.add(y);
        }

        int delta = (totalB -totalA)/2;

        for(int x : aliceSizes){
            if(setBob.contains(x+ delta))
                return new int[]{x,x+ delta };
        }

        return null;
    }
}
