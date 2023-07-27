package com.binarysearch;
/*
2141. Maximum Running Time of N Computers


You have n computers. You are given the integer n and a 0-indexed integer array batteries where the ith battery can
run a computer for batteries[i] minutes. You are interested in running all n computers simultaneously using the given
batteries.

Initially, you can insert at most one battery into each computer. After that and at any integer time moment, you can
remove a battery from a computer and insert another battery any number of times. The inserted battery can be a totally
new battery or a battery from another computer. You may assume that the removing and inserting processes take no time.

Note that the batteries cannot be recharged.

Return the maximum number of minutes you can run all the n computers simultaneously.

Example 1:

Input: n = 2, batteries = [3,3,3]
Output: 4
Explanation:
Initially, insert battery 0 into the first computer and battery 1 into the second computer.
After two minutes, remove battery 1 from the second computer and insert battery 2 instead. Note that battery 1
can still run for one minute.
At the end of the third minute, battery 0 is drained, and you need to remove it from the first computer and insert
battery 1 instead.
By the end of the fourth minute, battery 1 is also drained, and the first computer is no longer running.
We can run the two computers simultaneously for at most 4 minutes, so we return 4.

Intuition
In the previous approach, we began by selecting the largest n batteries (one for each computer) and then assigning
the remaining power extra to these computers using a greedy approach until we reach the longest running time.

Alternatively, we can first set a target running time, target, then try to reach this running time using all
batteries.
Here we still take advantage of the conclusion we reached at the end of the previous approach :

If the power of a battery is smaller than target, we can use all of its power.
If the power of a battery is larger than target, we can only use target power from it.

Therefore, we can traverse through batteries and collect all the power that can be used. If the sum of collected
power is larger than or equal to target * n, all computers can run for target time.

suppose we set a running time target, then we collect power from all batteries
(colored in green). Finally, we check if the sum of the collected power is larger than or equals to target * 2.

How to find the largest running time?

Instead of trying every target from 1 until finding the largest possible running time, we can take advantage of
binary search to locate the largest target faster than linear search.

Initially, we set the left boundary as 1 as the minimum possible running time. Assuming we can use all the power perfectly, the maximum running time is sum(batteries) / n, so we set the right boundary as sum(batteries) / n. As a result, the largest target is limited to the inclusive range [left, right], and we can apply binary search in this range to find it.


Algorithm
Initialize the boundaries of the search space as left = 1, and right = sum(batteries) / n.

While left < right:

Find the middle value target = right - (right - left) / 2.
Check if batteries can support n computers run target time. Iterate over batteries and record extra, the
accumulative sum of min(batteries[i], target).
Check if extra >= n * target:

If so, set left = target and repeat step 2.
Otherwise, set right = target - 1 and repate step 2.
Once the binary search ends, return left.


Complexity Analysis
Let mmm be the length of the input array batteries and kkk be the maximum power of one battery.

Time complexity: O(m⋅logk)

Initially, we set 1 as the left boundary and sum(batteries) / n as the right boundary. Thus it takes
O(log(m⋅k/n))
steps to locate the maximum running time in the worst-case scenario.

At each step, we need to iterate over batteries to add up the power that can be used, which takes O(m) time.

Therefore, the overall time complexity is O(m⋅log(m⋅k/n))=O(m⋅logk)
,k≫m,n
Space complexity: O(1)

During the binary search, we only need to record the boundaries of the searching space and the power extra,
and the accumulative sum of extra, which only takes constant space.
 */
public class MaximumRunningTimeOfNComputers {

    public static void main(String[] args) {
        int[] bat = new int[]{3,3,3};
        System.out.println(new MaximumRunningTimeOfNComputers().maxRunTime(2,bat));
    }
    public long maxRunTime(int n, int[] batteries) {
        //Arrays.sort(batteries);
        long sumPower =0;
        for(int power : batteries){
            sumPower += power;
        }

        long left =1, right = sumPower/n;

        while(left<right){
            long mid = right - (right-left)/2;
            long extra =0;
            for(int power : batteries){
                extra += Math.min(power, mid);
            }

            if(extra >= (long)(n*mid)){
                left = mid;
            } else{
                right = mid-1;
            }
        }
        return left;
    }
}
