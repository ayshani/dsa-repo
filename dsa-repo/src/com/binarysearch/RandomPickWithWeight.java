package com.binarysearch;

import java.util.Random;

/*
 * 528 Random Pick with Weight
 *
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1]
 (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%),
and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).


Example 2:

Input
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output
[null,1,1,1,1,0]

Explanation
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.

Since this is a randomization problem, multiple answers are allowed.
All of the following outputs can be considered correct:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
and so on.


TC/SC : O(N)
 */
public class RandomPickWithWeight {

    Random random;
    int[] sum;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] w = new int[] {1,3};
        RandomPickWithWeight obj = new RandomPickWithWeight(w);
        for(int i=0;i<5;i++) {
            System.out.print(obj.pickIndex() + " ");
        }
    }

    public RandomPickWithWeight(int[] w) {
        this.random = new Random();
        int n = w.length;
        for(int i=1;i<n;i++){
            w[i]+=w[i-1];

        }
        this.sum = w;
    }


    public int pickIndex() {
        int n = sum.length;
        int idx = random.nextInt(sum[n-1])+1;

        int l =0, r =n-1;

        while(l<r){
            int mid = l+(r-l)/2;
            if(sum[mid]==idx)
                return mid;
            else if(sum[mid]<idx){
                l= mid+1;
            }else
                r = mid;;
        }

        return l;
    }

}

