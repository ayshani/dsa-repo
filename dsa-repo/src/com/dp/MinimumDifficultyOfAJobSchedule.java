package com.dp;
/*
1335. Minimum Difficulty of a Job Schedule

You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have
to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of
difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.

You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

Example 1:
Input: jobDifficulty = [6,5,4,3,2,1], d = 2
Output: 7
Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
Second day you can finish the last job, total difficulty = 1.
The difficulty of the schedule = 6 + 1 = 7

TC : o(n*n)
SC : o(n*d)
 */
public class MinimumDifficultyOfAJobSchedule {

    Integer[][] dp;
    int n;

    public static void main(String[] args) {
        int[] diff = new int[]{
                6,5,4,3,2,1
        };
        System.out.println(new MinimumDifficultyOfAJobSchedule().minDifficulty(diff,2));
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        dp = new Integer[n][d+1];

        if(n<d)
            return -1;

        return helper(0,jobDifficulty,d);
    }

    private int helper(int index, int[] jobDifficulty, int d){
        if(n==index && d==0)
            return 0;
        if(n-index<d || d<0)
            return (int)1e5;

        if(dp[index][d]!=null)
            return dp[index][d];

        int res=Integer.MAX_VALUE, max =0;

        for(int i=index; i<n;i++){
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min( res, max+ helper(i+1,jobDifficulty,d-1));
        }

        return dp[index][d] = res;

    }
}
