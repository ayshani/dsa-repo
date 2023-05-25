package com.dp;
/*
837. New 21 Game

Alice plays the following game, loosely based on the card game "21".

Alice starts with 0 points and draws numbers while she has less than k points.
During each draw, she gains an integer number of points randomly from the range [1, maxPts],
where maxPts is an integer. Each draw is independent and the outcomes have equal probabilities.

Alice stops drawing numbers when she gets k or more points.

Return the probability that Alice has n or fewer points.

Answers within 10-5 of the actual answer are considered accepted.



Example 1:

Input: n = 10, k = 1, maxPts = 10
Output: 1.00000
Explanation: Alice gets a single card, then stops.

TC : o(n)
SC: o(w)
 */
public class New21Game {

    public static void main(String[] args) {
        int n = 21, k = 17, maxPt = 10;
        System.out.println(new New21Game().new21Game(n,k,maxPt));
    }
    public double new21Game(int n, int k, int maxPts) {
        /*
            if k is 0i.e. there is only one propbability for each card.
            Firstly, observe that when Alice is done playing, her points can be in range    [K, K+W-1]. She can't get past K+W because she stops playing when she is at K or more.

Now, we will see how to find the probabilities to stay in the positions in the above range and store them in p[] array.

We need to know the probabilities of all elems in range [0,K] first. From there we can calculate for elems in range (K, K+W-1]
        */
        if(k==0 || n >= k+maxPts){
            return 1;
        }

        double[] dp = new double[n+1];
        dp[0] =1;
        double totalSum =1.0, result =0.0;
        for(int i=1;i<=n;i++){

            /*
            For positions x <= K,
p[x] = (p[x-1] + p[x-2] + ..... + p[x-W]) * (1/W); (Probabilities of previous possible positions to get to x, multiplied by probability of choosing an elem to get to x)

For implementation, we can keep track past values using a single variable. For each new positions, we will subtract p[x-W-1] and add p[x-1]. Look at implementation below

For positions x > K,
p[x] = (p[K-1] + p[K-2] + .... + p[x - W]) * 1/W; (Since, we can't/shouldn't reach x from >= K positions)
            */

            dp[i] = totalSum/maxPts;
            if(i<k)
                totalSum+= dp[i];
            else
                result += dp[i];

            if(i-maxPts>=0)
                totalSum -= dp[i-maxPts];
        }

        return result;

    }
}
