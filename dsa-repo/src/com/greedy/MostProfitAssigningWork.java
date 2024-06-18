package com.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
826. Most Profit Assigning Work

You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:

difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most
worker[j]).
Every worker can be assigned at most one job, but one job can be completed multiple times.

For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker
cannot complete any job, their profit is $0.
Return the maximum profit we can achieve after assigning the workers to the jobs.



Example 1:

Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
Output: 100
Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.

TC : o(nlogn)
SC: o(n)
 */
public class MostProfitAssigningWork {

    public static void main(String[] args) {
        System.out.println(new MostProfitAssigningWork().maxProfitAssignment(
                new int[]{2,4,6,8,10}, new int[]{10,20,30,40,50}, new int[]{4,5,6,7}
        ));
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> difficultyProfit = new ArrayList<>();
        difficultyProfit.add(new int[]{0,0});
        for(int i=0;i<difficulty.length;i++){
            difficultyProfit.add(new int[]{difficulty[i],profit[i]});
        }

        Collections.sort(difficultyProfit, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<difficultyProfit.size()-1; i++){
            difficultyProfit.get(i + 1)[1] = Math.max(
                    difficultyProfit.get(i)[1],
                    difficultyProfit.get(i + 1)[1]
            );
        }
        int netProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            int ability = worker[i];
            // Find the job with just smaller or equal difficulty than ability.
            int l = 0, r = difficultyProfit.size() - 1, jobProfit = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (difficultyProfit.get(mid)[0] <= ability) {
                    jobProfit = Math.max(jobProfit, difficultyProfit.get(mid)[1]);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // Increment profit of current worker to total profit.
            netProfit += jobProfit;
        }
        return netProfit;
    }
}
