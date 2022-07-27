package com.binarysearch;
/*
 * 374. Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 *
 * Return the number that I picked.
 *
 * Example:
 * Input: n = 10, pick = 6
 * Output: 6
 *
 * TC : o(logn)
 * SC : o(1)
 *
 */
public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GuessNumberHigherOrLower obj = new GuessNumberHigherOrLower();
        System.out.println(obj.guessNumber(10));
    }

    public int guessNumber(int n) {
        int l =1, r = n;
        while(l<=r){
            int mid = l+(r-l)/2;
            int verdict = guess(mid);
            if(verdict==0)
                return mid;
            else if(verdict == -1)
                r = mid-1;
            else
                l = mid+1;
        }

        return -1;
    }

    private int guess(int mid) {
        // TODO Auto-generated method stub
        if(mid==6)
            return 0;
        else if(mid>6)
            return -1;
        else
            return 1;
    }

}

