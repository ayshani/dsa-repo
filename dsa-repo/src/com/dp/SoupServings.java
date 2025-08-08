package com.dp;

import java.util.HashMap;
import java.util.Map;

/*
808. Soup Servings

There are two types of soup: type A and type B. Initially, we have n ml of each type of soup. There are four kinds
of operations:

Serve 100 ml of soup A and 0 ml of soup B,
Serve 75 ml of soup A and 25 ml of soup B,
Serve 50 ml of soup A and 50 ml of soup B, and
Serve 25 ml of soup A and 75 ml of soup B.
When we serve some soup, we give it to someone, and we no longer have it. Each turn, we will choose from the four
operations with an equal probability 0.25. If the remaining volume of soup is not enough to complete the operation,
we will serve as much as possible. We stop once we no longer have some quantity of both types of soup.

Note that we do not have an operation where all 100 ml's of soup B are used first.

Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the
same time. Answers within 10-5 of the actual answer will be accepted.



Example 1:

Input: n = 50
Output: 0.62500
Explanation: If we choose the first two operations, A will become empty first.
For the third operation, A and B will become empty at the same time.
For the fourth operation, B will become empty first.
So the total probability of A becoming empty first plus half the probability that A and B become empty at the same
time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.


 */
public class SoupServings {

    public static void main(String[] args) {
        System.out.println(new SoupServings().soupServings(50));
    }
    public double soupServings(int n) {
        // max number of serving in 25 ml each. there can be extra some after last 25 ml.
        // so we need to add one more serving. hence taking ceil
        int m = (int)Math.ceil(n/25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
        for(int k=1;k<=m;k++){
            // this has been seen from the law of large numbers
            // that the more large the number is, the probability becomes near to 1.0 always. ie.
            // number of probability getting to 1 is maximum than rest of the probability.
            if(calculateDP(k,k,dp) > 1-1e-5){
                return 1.0;
            }
        }
        return calculateDP(m,m,dp);
    }

    private double calculateDP(int i, int j, Map<Integer,Map<Integer, Double>> dp){

        // incase both are 0 or less, then the prob is 1/2 for A to be empty
        if(i<=0 && j<=0)
            return 0.5;
        // incase i becomes zero, so its a prob of 1 for A to be empty
        if(i<=0)
            return 1.0;
        // incase j becomes zero, so its a prob of 0 for A to be empty
        // as its a prob is 1 for B
        if(j<=0)
            return 0.0;

        if(dp.containsKey(i) && dp.get(i).containsKey(j))
            return dp.get(i).get(j);


        // these are the cases for 4 cases mentioned in statements
        double result = (calculateDP(i-4,j,dp) + calculateDP(i-3,j-1,dp) +
                calculateDP(i-2,j-2,dp) + calculateDP(i-1,j-3,dp))/4.0;
        dp.computeIfAbsent(i, value -> new HashMap<>())
                .put(j, result);
        return result;
    }
}
