package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
967. Numbers With Same Consecutive Differences

Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.

Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Explanation
We initial the current result with all 1-digit numbers,
like cur = [1, 2, 3, 4, 5, 6, 7, 8, 9].

Each turn, for each x in cur,
we get its last digit y = x % 10.
If y + K < 10, we add x * 10 + y + K to the new list.
If y - K >= 0, we add x * 10 + y - K to the new list.

We repeat this step N - 1 times and return the final result.


Complexity
If K >= 5, time and Space O(N)
If K <= 4, time and space O(2^N)
 */
public class NumbersWithSameConsecutiveDifferences {

    public static void main(String[] args) {
        int[] res = new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(3,2);
        Arrays.stream(res).forEach(e-> System.out.print(e+" "));
    }
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> cur = Arrays.asList(1,2,3,4,5,6,7,8,9);

        for(int i=2;i<=n;i++){
            List<Integer> cur2 = new ArrayList<>();
            for(int x: cur){
                int y = x%10;
                if(y+k<10){
                    cur2.add(x*10+y+k);
                }
                if(k>0 && (y-k)>=0){
                    cur2.add(x*10+y-k);
                }
            }
            cur = cur2;
        }

        return cur.stream().mapToInt(j->j).toArray();
    }
}
