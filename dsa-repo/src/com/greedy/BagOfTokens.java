package com.greedy;

import java.util.Arrays;

/*
948. Bag of Tokens

You have an initial power of power, an initial score of 0, and a bag of tokens where tokens[i] is
the value of the ith token (0-indexed).

Your goal is to maximize your total score by potentially playing each token in one of two ways:

If your current power is at least tokens[i], you may play the ith token face up,
losing tokens[i] power and gaining 1 score.
If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1
score.
Each token may be played at most once and in any order. You do not have to play all the tokens.

Return the largest possible score you can achieve after playing any number of tokens.

Example 1:

Input: tokens = [100,200,300,400], power = 200
Output: 2
Explanation: Play the tokens in this order to get a score of 2:
1. Play the 0th token (100) face up, your power becomes 100 and score becomes 1.
2. Play the 3rd token (400) face down, your power becomes 500 and score becomes 0.
3. Play the 1st token (200) face up, your power becomes 300 and score becomes 1.
4. Play the 2nd token (300) face up, your power becomes 0 and score becomes 2.

Intuition

If we play a token face up, we might as well play the one with the smallest value. Similarly, if we play a token
face down, we might as well play the one with the largest value.

Algorithm

We don't need to play anything until absolutely necessary. Let's play tokens face up until we can't,
then play a token face down and continue.

We must be careful, as it is easy for our implementation to be incorrect if we do not handle corner cases correctly.
We should always play tokens face up until exhaustion, then play one token face down and continue.

Our loop must be constructed with the right termination condition: we can either play a token face up or face down.

Our final answer could be any of the intermediate answers we got after playing tokens face up
(but before playing them face down.)

Complexity Analysis
--------------
Time Complexity: O(NlogN), where NN is the length of tokens.

Space complexity : O(logN)
                   In Java, the Arrays.sort() is implemented as a variant of quicksort algorithm
                   whose space complexity is O(logN).
 */
public class BagOfTokens {

    public static void main(String[] args) {
        int tokens[] = new int[]{100,200,300,400}, power = 200;
        System.out.println(new BagOfTokens().bagOfTokensScore(tokens,power));
    }
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int low =0, high = tokens.length-1;
        int currentScore =0, maxScore =0;
        while(low<=high && (power>= tokens[low] || currentScore>0)){
            while(low<=high && power>= tokens[low])
            {
                power-=tokens[low++];
                currentScore++;
            }
            maxScore = Math.max(maxScore, currentScore);
            if(low<=high && currentScore>0){
                power+=tokens[high--];
                currentScore--;
            }

        }

        return maxScore;
    }
}
