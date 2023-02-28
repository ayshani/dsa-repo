package com.graph.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
1291. Sequential Digits

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.



Example 1:

Input: low = 100, high = 300
Output: [123,234]

TC : o(klogk)
SC: o(1)
 */
public class SequentialDigits {
    List<Integer> ans;

    public static void main(String[] args) {
        System.out.println(new SequentialDigits().sequentialDigits(100,300));

    }
    public List<Integer> sequentialDigits(int low, int high) {
        ans = new ArrayList<>();
        for(int i=1;i<10;i++){
            solve(low,high,i,0);
        }
        Collections.sort(ans);
        return ans;
    }

    private void solve(int low, int high, int i, int num){
        if(num>=low && num<=high){
            ans.add(num);
        }

        if(num>=high || i>9){
            return;
        }

        solve(low,high,i+1,num*10+i);
    }
}
