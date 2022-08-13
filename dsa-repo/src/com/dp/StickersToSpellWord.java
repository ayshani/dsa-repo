package com.dp;

import java.util.Arrays;

/*
691. Stickers to Spell Word

We are given n different types of stickers. Each sticker has a lowercase English word on it.

You would like to spell out the given string target by cutting individual letters from your collection
of stickers and rearranging them. You can use each sticker more than once if you want,
and you have infinite quantities of each sticker.

Return the minimum number of stickers that you need to spell out target. If the task is impossible, return -1.

Note: In all test cases, all words were chosen randomly from the 1000 most common US English words,
and target was chosen as a concatenation of two random words.



Example 1:

Input: stickers = ["with","example","science"], target = "thehat"
Output: 3
Explanation:
We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary to form the target string.

TC : o(2^n*stickers*stickerLength*target)
SC : o(2^n)

 */
public class StickersToSpellWord {

    public static void main(String[] args) {
        String[] stickers = new String[]{"with","example","science"};
        String target = "thehat";

        System.out.println(new StickersToSpellWord().minStickers(stickers,target));
    }
    public int minStickers(String[] stickers, String target) {
        if(stickers== null || stickers.length==0 || target == null || target.length()==0)
            return 0;

        int n = target.length();
        // We use bitmap to represent each subset, each subset will contains different characters from target
        int totalSubsets = 1<<n;
        // dp[i] means the minimum number of stickers we need to get the ith subset
        int[] dp = new int[totalSubsets];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Initialize empty subset
        dp[0]=0;
        for(int i=0;i<totalSubsets;i++){
            // There is no way to construct the subset starting from the current one, so skip it
            if(dp[i]== Integer.MAX_VALUE)
                continue;
            for(String sticker : stickers){
                int currentSubset =i;

                for(char currentCharacter : sticker.toCharArray()){
                    for(int targetIndex =0; targetIndex<n;targetIndex++){
                        // When target contains the current character and the
                        // current subset doesn't contain the character
                        // Add that character and form a new subset
                        if(target.charAt(targetIndex)==currentCharacter &&
                                ((currentSubset >> targetIndex)&1)==0 )
                        {
                            currentSubset = currentSubset|(1<<targetIndex);
                            break;
                        }
                    }
                }
                // dp[i] + 1 means the using the minimum number of stickers
                // to form subset i and plus one more sticker, since we
                // can form current subset from i with one sticker
                dp[currentSubset] = Math.min(dp[currentSubset], dp[i]+1);
            }
        }

        return dp[totalSubsets-1] == Integer.MAX_VALUE? -1: dp[totalSubsets-1];
    }
}
