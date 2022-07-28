package com.dp;
/*
 * 375. Guess Number Higher or Lower II
 *
 * We are playing the Guessing Game. The game will work as follows:
 * I pick a number between 1 and n.
 * You guess a number
 * If you guess the right number, you win the game.
 * If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you will continue guessing.
 * Every time you guess a wrong number x, you will pay x dollars. If you run out of money, you lose the game.
 *
 * Given a particular n, return the minimum amount of money you need to guarantee a win regardless of what number I pick.
 *
 * Input: n = 10
 * Output: 16
 *
 * Explanation: The winning strategy is as follows:
- The range is [1,10]. Guess 7.
    - If this is my number, your total is $0. Otherwise, you pay $7.
    - If my number is higher, the range is [8,10]. Guess 9.
        - If this is my number, your total is $7. Otherwise, you pay $9.
        - If my number is higher, it must be 10. Guess 10. Your total is $7 + $9 = $16.
        - If my number is lower, it must be 8. Guess 8. Your total is $7 + $9 = $16.
    - If my number is lower, the range is [1,6]. Guess 3.
        - If this is my number, your total is $7. Otherwise, you pay $3.
        - If my number is higher, the range is [4,6]. Guess 5.
            - If this is my number, your total is $7 + $3 = $10. Otherwise, you pay $5.
            - If my number is higher, it must be 6. Guess 6. Your total is $7 + $3 + $5 = $15.
            - If my number is lower, it must be 4. Guess 4. Your total is $7 + $3 + $5 = $15.
        - If my number is lower, the range is [1,2]. Guess 1.
            - If this is my number, your total is $7 + $3 = $10. Otherwise, you pay $1.
            - If my number is higher, it must be 2. Guess 2. Your total is $7 + $3 + $1 = $11.
The worst case in all these scenarios is that you pay $16. Hence, you only need $16 to guarantee a win.

Logic
-------
first introduce best strategy to guess:

for one number, like 1, best strategy is 0$
for two number, like 3,4, best strategy is 3$, which can be understood in this way:
you have two way to guess:
 a) start by guess 4 is the target, (the worst case is) if wrong, you get charged $4,
 then immediately you know 3 is the target number, get get charged $0 by guessing that, and finally you get charged $4.
 b) similarly, if you start by 3, (the worst case is) if wrong, you get charged $3,
 then you immediately know that 4 is the target number, and get charged $0 for guessing this, and finally you get charged $3. In summary:
 range ---------> best strategy cost
 3, 4 ---------> $3
 5, 6 ---------> $5


 for three number, the best strategy is guess the middle number first,
 and (worst case is) if wrong, you get charged that middle number money,
 and then you immediately know what target number is by using "lower" or "higher" response, so in summary:
 range ---------> best strategy cost
 3, 4, 5 ---------> $4
 7, 8, 9 ---------> $8


 for more numbers, it can simply be reduced them into smaller ranges, and here is why DP solution make more sense in solving this.
 suppose the range is [start, end]
 the strategy here is to iterate through all number possible and select it as the starting point,
 say for any k between start and end, the worst cost for this is: k+DP( start, k-1 ) + DP(k+1, end ),
 and the goal is minimize the cost, so you need the minimum one among all those k between start and end


 TC : o(n^2)
 SC : O(n^2)
 */
public class GuessNumberHigherOrLowerII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GuessNumberHigherOrLowerII obj = new GuessNumberHigherOrLowerII();
        System.out.println(obj.getMoneyAmount(10));
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];

        return helper(dp,1,n);
    }

    private int helper(int[][] dp, int start, int end){
        if(start>=end)
            return 0;
        if(dp[start][end]!=0)
            return dp[start][end];
        int res = Integer.MAX_VALUE;

        for(int i=start;i<=end;i++){
            int temp = i + Math.max(helper(dp,start,i-1) , helper(dp,i+1,end));
            res = Math.min(res,temp);
        }

        return dp[start][end] = res;
    }

}
