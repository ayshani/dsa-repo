package com.dp;
/*
879. Profitable Schemes

There is a group of n members, and a list of various crimes they could commit.
The ith crime generates a profit[i] and requires group[i] members to participate in it. If a member
participates in one crime, that member can't participate in another crime.

Let's call a profitable scheme any subset of these crimes that generates at least minProfit profit,
and the total number of members participating in that subset of crimes is at most n.

Return the number of schemes that can be chosen. Since the answer may be very large, return it modulo 109 + 7.

Example 1:

Input: n = 5, minProfit = 3, group = [2,2], profit = [2,3]
Output: 2
Explanation: To make a profit of at least 3, the group could either commit crimes 0 and 1, or just crime 1.
In total, there are 2 schemes.


Approach
This problem is very similar to the classic knapsack problem. The difference between the two is that the classic
knapsack problem has only one capacity constraint, but this problem has two constraints: the upper limit of the
number of members n, and the lower limit of the profit generated minProfit

Through the practice of the classic knapsack problem, we know that the classic knapsack problem can be solved
using two-dimensional dynamic programming: the two dimensions represent the constraints of items and capacity
respectively. For the above two limitations of this question, we can think of using 3D dynamic programming to
solve it.

The three dimensions of the solution to this problem are: the currently available crime, the number of selected
members, and the lower limit of the current profit

According to the above analysis, we can define a three-dimensional array dp as the state of dynamic programming,
where dp[i][j][k] means that j employees are selected in the first i crime, and The total number of profitable
plans where the working profit is at least k. Assuming that the length of the group array is len, then without
considering the modulo operation, the final answer is:

∑i=0 to n, dp[len][i][minProfit]

So we can create a new three-dimensional array dp[len+1][n+1][minProfit+1] and initialize dp[0][0][0]=1.
Next, we analyze the state transition equation. For each crime i, we have two cases of being able to work
and unable to work according to the upper limit of the current number of workers j:

If the current crime i cannot be done, then obviously:
dp[i][j][k]=dp[i−1][j][k]

If the current crime i can be done, assume the current group number is group[i], and the work profit is profit[i],
then without considering the modulo operation, there are:
dp[i][j][k]=dp[i−1][j][k]+dp[i−1][j−group[i]][max(0,k−profit[i])]
Since the third dimension we defined is that the working profit is at least k rather than the working profit
is exactly k, the third dimension on the right side of the above state transition equation is max(0,k−profit[i])
and not k−profit[i].



Complexity
Time complexity:
O(len×n×minProfit), where len is the length of the array group.
The total number of states that need to be calculated by dynamic programming is O(len×n×minProfit),
and the time of each state needs O(1) time to calculate.

Space complexity:
O(n×minProfit)
To implement space optimization, we need to create a two-dimensional array dp with n+1 rows and minProfit+1 columns.


 */
public class ProfitableSchemes {

    public static void main(String[] args) {
        int[] group =  new int[]{2,2}, profit =  new int[]{2,3};
        System.out.println(new ProfitableSchemes().profitableSchemes(5,3,group,profit));
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length, mod = 1000000007;
        int[][][] dp = new int[len+1][n+1][minProfit+1];
        dp[0][0][0] = 1;
        for(int i=1;i<=len;i++){
            int members = group[i-1], earn = profit[i-1];
            for(int j=0;j<=n;j++){
                for(int k=0;k<=minProfit;k++){
                    //If the current crime i cannot be done
                    if(j<members){
                        dp[i][j][k] = dp[i-1][j][k];
                    } else{
                        //If the current crime i can be done, assume the current group number is group[i],
                        // and the work profit is profit[i]
                        //Since the third dimension we defined is that the working profit is at least k rather than
                        // the working profit is exactly k, the third dimension on the right side of the above state
                        // transition equation is max(0,k−profit[i]) and not k−profit[i]
                        dp[i][j][k] = (dp[i-1][j][k] +
                                dp[i-1][j-members][Math.max(0,k-earn)])%mod;
                    }
                }
            }
        }
        int sum =0;
        for(int j=0;j<=n;j++){
            sum = (sum+ dp[len][j][minProfit])%mod;
        }
        return sum;
    }
}
