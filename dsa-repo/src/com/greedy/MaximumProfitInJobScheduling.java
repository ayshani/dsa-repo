package com.greedy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
1235. Maximum Profit in Job Scheduling

We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays,
return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

Example 1:
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job.
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

TC : o(nlogn)
SC : o(n)
 */
public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        int[] startTime = new int[]{1,2,3,3}, endTime =  new int[]{3,4,5,6}, profit = new int[]{50,10,40,70};
        System.out.println(new MaximumProfitInJobScheduling().jobScheduling(startTime,endTime,profit));
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Integer[][] jobs = new Integer[n][3];
        // add startime, endtime, profit as a trio in jobs[i]
        for(int i=0;i<n;i++){
            jobs[i] = new Integer[]{startTime[i],endTime[i],profit[i]};
        }
        // sort wrt increaing end time
        Arrays.sort(jobs, (a, b)-> a[1]-b[1]);
        TreeMap<Integer,Integer> dp = new TreeMap<>();

        for(Integer[] job : jobs){
            // get previous max Profit entry of start time
            Map.Entry<Integer,Integer> prevMaxProfitEntry = dp.floorEntry(job[0]);
            Integer currentProfit = job[2] + (prevMaxProfitEntry== null ? 0 : prevMaxProfitEntry.getValue() );

            // either dp is empty or cuurentProfit is greater than previous one
            // in this case, add new entry (endtime, current profit)
            if(dp.lastEntry()==null || currentProfit>dp.lastEntry().getValue()){
                dp.put(job[1],currentProfit);
            }
        }
        return dp.lastEntry().getValue();
    }
}
