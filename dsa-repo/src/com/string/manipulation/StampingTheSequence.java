package com.string.manipulation;

import java.util.*;

/*
936. Stamping The Sequence

You are given two strings stamp and target. Initially, there is a string s of length target.length
with all s[i] == '?'.

In one turn, you can place stamp over s and replace every letter in the s with the corresponding letter from stamp.

For example, if stamp = "abc" and target = "abcba", then s is "?????" initially. In one turn you can:
place stamp at index 0 of s to obtain "abc??",
place stamp at index 1 of s to obtain "?abc?", or
place stamp at index 2 of s to obtain "??abc".
Note that stamp must be fully contained in the boundaries of s in order to stamp (i.e.,
you cannot place stamp at index 3 of s).
We want to convert s to target using at most 10 * target.length turns.

Return an array of the index of the left-most letter being stamped at each turn.
If we cannot obtain target from s within 10 * target.length turns, return an empty array.

Example 1:

Input: stamp = "abc", target = "ababc"
Output: [0,2]
Explanation: Initially s = "?????".
- Place stamp at index 0 to get "abc??".
- Place stamp at index 2 to get "ababc".
[1,0,2] would also be accepted as an answer, as well as some other answers.

Approach 1: Work Backwards
Intuition

Imagine we stamped the sequence with moves m1m2....
Now, from the final position target, we will make those moves in reverse order.

Let's call the ith window, a subarray of target of length stamp.length that starts at i.
Each move at position i is possible if the ith window matches the stamp. After, every character in
the window becomes a wildcard that can match any character in the stamp.

For example, say we have stamp = "abca" and target = "aabcaca". Working backwards,
we will reverse stamp at window 1 to get "a????ca", then reverse stamp at window 3 to get "a??????",
and finally reverse stamp at position 0 to get "???????".

Algorithm

Let's keep track of every window. We want to know how many cells initially match the stamp (our "made" list),
and which ones don't (our "todo" list). Any windows that are ready (ie. have no todo list), get enqueued.

Specifically, we enqueue the positions of each character. (To save time, we enqueue by character, not by window.)
This represents that the character is ready to turn into a "?" in our working target string.

Now, how to process characters in our queue? For each character, let's look at all the windows that intersect it,
and update their todo lists.
If any todo lists become empty in this manner (window.todo is empty),
then we enqueue the characters in window.made that we haven't processed yet.
 */
public class StampingTheSequence {

    public static void main(String[] args) {
        int[] res = new StampingTheSequence().movesToStamp("abc","ababc");

        Arrays.stream(res).forEach( e -> System.out.print(e + " "));
    }
    public int[] movesToStamp(String stamp, String target) {


        int m = stamp.length(), n = target.length();
        List<Node> A = new ArrayList<>();
        Stack<Integer> ans = new Stack<>();
        boolean[] done = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<= n-m;i++){

            // For each window [i, i+M), A[i] will contain
            // info on what needs to change before we can
            // reverse stamp at this window.
            Set<Integer> made = new HashSet<>();
            Set<Integer> todo = new HashSet<>();
            for(int j=0;j<m;j++){
                if(target.charAt(i+j) == stamp.charAt(j)){
                    made.add(i+j);
                } else
                    todo.add(i+j);
            }
            A.add(new Node(made, todo));

            // If we can reverse stamp at i immediately,
            // enqueue letters from this window.
            if(todo.isEmpty()){
                ans.push(i);
                for(int j=i;j<i+m;j++){
                    if(!done[j]){
                        done[j]= true;
                        q.add(j);
                    }
                }
            }

        }

        // For each enqueued letter (position),
        while(!q.isEmpty()){
            int i = q.poll();

            // For each window that is potentially affected,
            // j: start of window
            for(int j = Math.max(0, i-m+1); j<= Math.min(n-m,i);j++){
                if(A.get(j).todo.contains(i)){
                    // This window is affected
                    A.get(j).todo.remove(i);

                    if(A.get(j).todo.isEmpty()){
                        ans.push(j);
                        for(int mad : A.get(j).made){
                            if(!done[mad]){
                                q.add(mad);
                                done[mad]= true;
                            }
                        }
                    }
                }
            }
        }

        for(boolean b : done){
            if(!b)
                return new int[0];
        }

        int[] res = new int[ans.size()];
        int index =0;
        while(!ans.isEmpty()){
            res[index++] = ans.pop();
        }

        return res;
    }

    class Node{
        Set<Integer> made,todo;
        Node(Set<Integer> made, Set<Integer> todo){
            this.made = made;
            this.todo = todo;
        }
    }

}
