package com.greedy;
/*
670. Maximum Swap

You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.



Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

TC : o(n)
SC: o(n)
 */
public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(new MaximumSwap().maximumSwap(2736));
    }
    public int maximumSwap(int num) {
        String numStr = Integer.toString(num);

        int n = numStr.length();
        int[] lastSeen = new int[10]; // Store the last occurrence of each digit

        // Record the last occurrence of each digit
        for (int i = 0; i < n; ++i) {
            lastSeen[numStr.charAt(i) - '0'] = i;
        }

        // Traverse the string to find the first digit that can be swapped with a larger one
        for (int i = 0; i < n; ++i) {
            for (int d = 9; d > numStr.charAt(i) - '0'; --d) {
                if (lastSeen[d] > i) {
                    //Perform the swap
                    char[] arr = numStr.toCharArray();
                    char temp = arr[i];
                    arr[i] = arr[lastSeen[d]];
                    arr[lastSeen[d]] = temp;
                    numStr = new String(arr);
                    return Integer.parseInt(numStr); // Return the new number immediately after the swap
                }
            }
        }
        return num; // Return the original number if no swap can maximize it
    }
}
