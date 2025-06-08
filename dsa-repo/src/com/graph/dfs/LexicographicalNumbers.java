package com.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/*
386. Lexicographical Numbers

Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space.



Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

TC : o(n)
SC: o(logn)
 */
public class LexicographicalNumbers {

    public static void main(String[] args) {
        System.out.println(new LexicographicalNumbers().lexicalOrder(13));
        System.out.println(new LexicographicalNumbers().lexicalOrderV2(20));
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();

        for(int start =1 ; start<=9; start++){
            generate(start, n, lexicographicalNumbers);
        }
        return lexicographicalNumbers;
    }

    private void generate(int cur, int n, List<Integer> result){
        if(cur > n){
            return;
        }
        result.add(cur);
        for(int next = 0; next <=9; next++){
            int nextNum = cur *10 + next;
            if(nextNum<=n){
                generate(nextNum, n, result);
            } else{
                break;
            }
        }
    }

    // TC : o(n) SC : o(1)
    public List<Integer> lexicalOrderV2(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        int currentNumber = 1;

        // Generate numbers from 1 to n
        for (int i = 0; i < n; ++i) {
            lexicographicalNumbers.add(currentNumber);

            // If multiplying the current number by 10 is within the limit, do it
            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                // Adjust the current number by moving up one digit
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10; // Remove the last digit
                }
                currentNumber += 1; // Increment the number
            }
        }
        return lexicographicalNumbers;
    }
}
