package com.backtracking;
/*
2305. Fair Distribution of Cookies

You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag. You are
also given an integer k that denotes the number of children to distribute all the bags of cookies to. All the
cookies in the same bag must go to the same child and cannot be split up.

The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the
distribution.

Return the minimum unfairness of all distributions.



Example 1:

Input: cookies = [8,15,10,20,8], k = 2
Output: 31
Explanation: One optimal distribution is [8,15,8] and [10,20]
- The 1st child receives [8,15,8] which has a total of 8 + 15 + 8 = 31 cookies.
- The 2nd child receives [10,20] which has a total of 10 + 20 = 30 cookies.
The unfairness of the distribution is max(31,30) = 31.
It can be shown that there is no distribution with an unfairness less than 31.
 */
public class FairDistributionOfCookies {

    int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] cookies = new int[]{8,15,10,20,8};
        System.out.println(new FairDistributionOfCookies().distributeCookies(cookies,2));
    }
    public int distributeCookies(int[] cookies, int k) {
        // setting up all necessary variables for the recursion
        int[] res = new int[k];
        // start recursion process
        backtracking(cookies, 0,k, res);
        return ans;
    }

    public void backtracking(int[] cookies, int index, int k, int[] res){
        // terminating condition for the recursion
        if(index== cookies.length){
            int max =0;
            // find the max cookie in 1 jar
            for(int portion : res){
                max = Math.max(max, portion);
            }
            // if the max coockie is smaller than ans itself, it is the most fair distribution; thus save it.
            ans = Math.min(ans, max);
            // no more cookies to distribute; hence, return and try the next posibilities
            return ;
        }
        // try all possibility of distriuting the cookie to each jar
        for(int i=0;i<k;i++){
            // backtracking algorithm
            res[i]+= cookies[index];
            backtracking(cookies,index+1,k,res);
            res[i] -= cookies[index];
        }
    }
}
