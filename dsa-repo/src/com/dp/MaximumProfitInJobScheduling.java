package com.dp;

import java.util.Arrays;
import java.util.TreeMap;

/*
 * 1235. Maximum Profit in Job Scheduling
 *
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i],
 * obtaining a profit of profit[i].
 * You're given the startTime, endTime and profit arrays,
 * return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 * Example:
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 *
 * Logic
 * ---------------
 * Sort the array wrt job end time
 * dp[time] = profit means within first time duration,
 * we can make atmost profit money
 * Initial dp[0] = 0;
 *
 * for each jobs[s,e,p], where s,e,p are its start time, end time and profit,
 * Then the logic is similar to the knapsack problem.
 * If we don't do this job, nothing will be changed.
 * If we do this job, binary search in the dp to find the largest profit we can make before start time s.
 * So we also know the maximum cuurent profit that we can make doing this job.
 *
 * Compare with last element in the dp,
 * If we make more money,
 * 		it worth doing this job,
 * 		then we add the pair of [e, cur] to the back of dp.
 * Otherwise, we'd like not to do this job.
 *
 * Complexity
 * Time O(NlogN) for sorting
 * Time O(NlogN) for binary search for each job
 * Space O(N)
 */
public class MaximumProfitInJobScheduling {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] startTime = new int[] {1,2,3,3}, endTime=  new int[] {3,4,5,6}, profit = new int[] {50,10,40,70};
        MaximumProfitInJobScheduling obj = new MaximumProfitInJobScheduling();
        System.out.println(obj.jobScheduling(startTime, endTime, profit));
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Integer[][] jobs = new Integer[n][3];
        for(int i=0;i<n;i++){
            jobs[i] = new Integer[]{startTime[i],endTime[i],profit[i]};
        }
        Arrays.sort(jobs, (a, b)-> a[1]-b[1]);

        TreeMap<Integer,Integer> dp = new TreeMap<>();

        for(Integer[] job : jobs){
            Integer prevJobEndTime = dp.floorKey(job[0]);
            Integer currentProfit = job[2] + (prevJobEndTime== null ? 0 : dp.get(prevJobEndTime) );

            if(dp.lastEntry()==null || currentProfit>dp.lastEntry().getValue()){
                dp.put(job[1],currentProfit);
            }
        }

        return dp.lastEntry().getValue();
    }

}
