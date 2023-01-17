package com.string.manipulation;
/*
926. Flip String to Monotone Increasing

A binary string is monotone increasing if it consists of some number of 0's (possibly none),
followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

Ref :
https://medium.com/@smartsplash/flip-string-to-monotone-increasing-in-o-n-time-b9242fe2a4fb


Explanation
-----------
Initially set both the no of one’s seen so far (oneCount )and flipCount as 0
What is flipCount?
    We are not updating the zero count as we are only interested in the 0's which are coming after 1's.
    We call such counts as flipCount
Now, let's linearly iterate over the string.
If we found ‘1’, then increase oneCount by 1.
If we found '0' (not 1 means 0 here), then we will increase the flipCount if the oneCount > 0

Now, as we want the minimum number of changes,
at every iteration the number of flipCount is actually min(flipCount,oneCount). Seems logical, isn’t it 🧠

Return the flipCount at the end of the iteration

TC : o(n)
SC : o(1)
 */
public class FlipStringToMonotoneIncreasing {

    public static void main(String[] args) {
        System.out.println(new FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00011000"));
    }
    public int minFlipsMonoIncr(String s) {
        int oneCount =0, flipCount=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                oneCount++;
            else{
                if(oneCount>=1){
                    flipCount++;
                }
            }
            flipCount = Math.min(oneCount,flipCount);
        }

        return flipCount;
    }
}
