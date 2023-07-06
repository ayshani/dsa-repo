package com.gametheory;
/*
Lucky Number
Bob and Alice are playing a game with the following rules:

Initially, they have an integer sequence A1,A2,…,An; in addition, Bob has a lucky number a and Alice has a
lucky number b.

The players alternate turns. In each turn, the current player must remove a non-zero number of elements from
the sequence; each removed element should be a multiple of the lucky number of this player.

If it is impossible to remove any elements, the current player loses the game.

It is clear that one player wins the game after a finite number of turns. Find the winner of the game if Bob
plays first and both Bob and Alice play optimally.

Return "Bob" if the winner is Bob or "Alice" if Alice is the winner without quotes.

Constraints:

1<= n <= 10^5

1<= a,b <= 100

1<= Ai <= 10^9



Example:

Input

n = 5, a = 3, b = 2
A= [1, 2, 3, 4, 5]
Output

Alice
Explanation:

Bob removes 3 and the sequence becomes [1,2,4,5]. Then, Alice removes 2 and the sequence becomes [1,4,5].
Now, Bob is left with no moves, so Alice is the winner.

TC: o(n)
SC: o(1)
 */
public class LuckyNumber {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(new LuckyNumber().solve(5,3,2,A));
    }
    public String solve(int n,int a,int b, int[] A)
    {
        int bothCount =0, bobCount =0, aliceCount =0;
        for(int i=0;i<n;i++){
            if(A[i]%a==0 && A[i]%b==0)
                bothCount++;
            else if(A[i]%a==0)
                bobCount++;
            else if(A[i]%b==0)
                aliceCount++;
        }

        if(bothCount>0){
            bobCount++;
        }
        if(bobCount>aliceCount)
            return "Bob";
        else
            return "Alice";
    }
}
