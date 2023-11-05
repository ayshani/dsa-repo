package com.queue;

import java.util.LinkedList;
import java.util.Queue;

/*

1535. Find the Winner of an Array Game


Given an integer array arr of distinct integers and an integer k.

A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at position 0, and the smaller integer moves to the end of the array. The game ends when an integer wins k consecutive rounds.

Return the integer which will win the game.

It is guaranteed that there will be a winner of the game.



Example 1:

Input: arr = [2,1,3,5,4,6,7], k = 2
Output: 5
Explanation: Let's see the rounds of the game:
Round |       arr       | winner | win_count
  1   | [2,1,3,5,4,6,7] | 2      | 1
  2   | [2,3,5,4,6,7,1] | 3      | 1
  3   | [3,5,4,6,7,1,2] | 5      | 1
  4   | [5,4,6,7,1,2,3] | 5      | 2
So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.

TC : o(n)
SC : o(n)
 */
public class FindTheWinnerOfAnArrayGame {

    public static void main(String[] args) {
        System.out.println(new FindTheWinnerOfAnArrayGame().getWinner(new int[]{2,1,3,5,4,6,7}, 2));
    }
    public int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            queue.offer(arr[i]);
        }

        int curr = arr[0];
        int winstreak = 0;

        while (!queue.isEmpty()) {
            int opponent = queue.poll();

            if (curr > opponent) {
                queue.offer(opponent);
                winstreak++;
            } else {
                queue.offer(curr);
                curr = opponent;
                winstreak = 1;
            }

            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }

        return -1;
    }
}
