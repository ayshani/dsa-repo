package com.stack;

import java.util.Arrays;
import java.util.Stack;

/*
739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such
that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

TC : o(n)
SC : o(n)
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temp = new int[]{73,74,75,71,69,72,76,73};
        int[] res = new DailyTemperatures().dailyTemperatures(temp);
        Arrays.stream(res).forEach(e-> System.out.print(e+" "));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        res[n-1]=0;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = 0;
            } else{
                res[i] = st.peek()-i;
            }
            st.push(i);
        }
        return res;
    }
}
