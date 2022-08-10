package com.bit.manipulation;

import java.util.Arrays;

/*
2275. Largest Combination With Bitwise AND Greater Than Zero

The bitwise AND of an array nums is the bitwise AND of all integers in nums.

For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1.
Also, for nums = [7], the bitwise AND is 7.
You are given an array of positive integers candidates.
Evaluate the bitwise AND of every combination of numbers of candidates.
Each number in candidates may only be used once in each combination.

Return the size of the largest combination of candidates with a bitwise AND greater than 0.



Example 1:

Input: candidates = [16,17,71,62,12,24,14]
Output: 4
Explanation: The combination [16,17,62,24] has a bitwise AND of 16 & 17 & 62 & 24 = 16 > 0.
The size of the combination is 4.
It can be shown that no combination with a size greater than 4 has a bitwise AND greater than 0.
Note that more than one combination may have the largest size.
For example, the combination [62,12,24,14] has a bitwise AND of 62 & 12 & 24 & 14 = 8 > 0.

Constraints:

1 <= candidates.length <= 105
1 <= candidates[i] <= 107


index--> 6 5 4 3 2 1 0
    16 = 0 0 1 0 0 0 0
    17 = 0 0 1 0 0 0 1
    71 = 1 0 0 0 1 1 1
    62 = 0 1 1 1 1 1 0
    12 = 0 0 0 1 1 0 0
    24 = 0 0 1 1 0 0 0
    14 = 0 0 0 1 1 1 0

    If we and AND all numbers we will get 0.
    62 & 12 gives 0001100 (There are ones present at index 3 and 2)

    Approach: To maximize number of elements whose AND will result a number greater than zero find
    maximum number of ones that lie in a particular index.


    In our case 62,12,24,14 have 1 at index 3.
    Thus doing a AND operation on them will result to a number greater than zero(0001000).


    Solution: To solve this problem use a int[] array to store frequency of ones at particular index
    and return the maximum frequency as the answer.


    Time Complexity: O(nlog(range))
    log(range): Calculation of frequency of 1's and n: scanning all inputs. Where range=10^7

    Space Complexity: O(1)

 */
public class LargestCombinationWithBitwiseANDGreaterThanZero {

    public static void main(String[] args) {
        int[] candidates = new int[]{16,17,71,62,12,24,14};

        System.out.println(new LargestCombinationWithBitwiseANDGreaterThanZero().largestCombination(candidates));
    }
    public int largestCombination(int[] candidates) {
        int[] arr = new int[24]; //1_000_000_0's binary representation has length of 24

        for(int candidate : candidates){
            int index =0;

            while(candidate>0){
                if((candidate&1) == 1)
                    arr[index]++;

                candidate =  candidate>>1;
                index++;

            }
        }

        return Arrays.stream(arr).max().getAsInt();
    }
}
