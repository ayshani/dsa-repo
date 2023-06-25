package com.dp;
/*
1575. Count All Possible Routes
You are given an array of distinct positive integers locations where locations[i] represents the position of city i.
You are also given integers start, finish and fuel representing the starting city, ending city, and the initial
amount of fuel you have, respectively.

At each step, if you are at city i, you can pick any city j such that j != i and 0 <= j < locations.length and
move to city j. Moving from city i to city j reduces the amount of fuel you have by |locations[i] - locations[j]|.
Please notice that |x| denotes the absolute value of x.

Notice that fuel cannot become negative at any point in time, and that you are allowed to visit any city more than
once (including start and finish).

Return the count of all possible routes from start to finish. Since the answer may be too large, return it modulo
109 + 7.



Example 1:

Input: locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
Output: 4
Explanation: The following are all possible routes, each uses 5 units of fuel:
1 -> 3
1 -> 2 -> 3
1 -> 4 -> 3
1 -> 4 -> 2 -> 3


Explanation
-------------
Start from the start index, and visit all cities except start.
Continue this process recursively.
If you reach end index, do:
    - Now, we have atleast 1 way of reaching end so add this 1 possible way to the answer.
    - Continue recursion, since there might be more ways to get back from end to end using other cities.
If fuel < 0, there is no further way left.

If you look at this recursion, we can see that there are overlapping subproblems. If you reach a city c
with fuel f multiple times from different paths, don't recompute, just use memoised result.

TC :
At any point in time, you can be at one of the cities, 1,2...n, with fuel, 1,2,...fuel, hence, [O(fuel * n)].
While you are at those cities with that amount of fuel, you will visit each of other city, 1,2,...n,
hence O(fuel*n^2).

SC: o(N*fuel)
 */
public class CountAllPossibleRoutes {
    public static void main(String[] args) {
        int[] locations = new int[]{4,3,1};
        System.out.println(new CountAllPossibleRoutes().countRoutes(locations,1,0,6));
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        // dp[curCity][fuel] = number of ways to reach finish, when we are at city `curCity` with fuel `fuel`
        Long[][] dp = new Long[n][fuel+1];
        return (int)solve(locations,start, finish, dp, fuel);
    }

    private long solve(int[] locations, int currentCity, int finish, Long[][] dp, int fuel){
        // 4. There is no further way left.
        if(fuel<0){
            return 0;
        }
        if(dp[currentCity][fuel]!=null)
            return dp[currentCity][fuel];
        // 3. Now, if we have atleast 1 way of reaching `end`, add 1 to the answer.
        //But don't stop right here, keep going, there might be more ways :)
        long ans = (currentCity == finish) ? 1 : 0;
        for(int nextCity = 0; nextCity<locations.length;nextCity++){
            // 1. Visit all cities except `curCity`.
            if(nextCity!=currentCity){
                ans  = (ans+ solve(locations, nextCity, finish, dp,fuel- Math.abs(locations[currentCity]- locations[nextCity])))%1000000007;
            }
        }
        return dp[currentCity][fuel] = ans;
    }
}
