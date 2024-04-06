package com.graph.topologicalsort;

import java.util.*;

/*
269. Alien Dictionary

There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are
sorted lexicographically
 by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order
by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"

Explanation
------------
Let N be the total number of strings in the input list.

Let C be the total length of all the words in the input list, added together.

Let U be the total number of unique letters in the alien alphabet. While this is limited to 26 in the question
description, we'll still look at how it would impact the complexity if it was not limited
(as this could potentially be a follow-up question).

Time complexity : O(C).

There were three parts to the algorithm; identifying all the relations, putting them into an adjacency list,
and then converting it into a valid alphabet ordering.
In the worst case, the first and second parts require checking every letter of every word
(if the difference between two words was always in the last letter). This is O(C).

For the third part, recall that a breadth-first search has a cost of O(V+E),
where V is the number of vertices and E is the number of edges.
Our algorithm has the same cost as BFS, as it too is visiting each edge and node once
(a node is visited once all of its edges are visited, unlike the traditional BFS where it is
visited once one edge is visited). Therefore, determining the cost of our algorithm requires
determining how many nodes and edges there are in the graph.

Nodes: We know that there is one vertex for each unique letter, i.e. O(U) vertices.

Edges: Each edge in the graph was generated from comparing two adjacent words in the input list.
There are N−1 pairs of adjacent words, and only one edge can be generated from each pair.
This might initially seem a bit surprising, so let's quickly look at an example. We'll use English words.

abacus
algorithm
The only conclusion we can draw is that b is before l. This is the reason abacus appears before algorithm
in an English dictionary. The characters afterward are irrelevant. It is the same for the "alien" alphabets
we're working with here. The only rule we can draw is the one based on the first difference between the two words.

Also, remember that we are only generating rules for adjacent words. We are not adding the "implied"
rules to the adjacency list. For example, assume we have the following word list.

rgh
xcd
tny
bcd
We are only generating the following 3 edges.

r -> x
x -> t
t -> b
We are not generating these implied rules (the graph structure shows them indirectly).

r -> t
r -> b
x -> b
So with this, we know that there are at most N - 1 edges.

There is an additional upper limit on the number of edges too—it is impossible for there to be more
than one edge between each pair of nodes. With U  nodes, this means there can't be more than U^2 edges.

It's not common in complexity analysis that we get two separate upper bounds like this.
Because the number of edges has to be lower than both N−1 and U^2 , we know it is at most the smallest of these
two values. Mathematically, we can say this is min(U^2, N - 1).
Going all the way back to the cost of breadth first search, we can now substiute in the number of
nodes and the number of edges: V=U and E = min(U^2, N - 1). This gives us:

O(V+E)=O(U + min(U^2, N - 1)) =O(U+min(U^2,N)).

Finally, we need to combine the two parts: O(C) for the first and second parts, and O(U + \min(U^2, N))
 for the third part. When we have two independent parts, we add the costs together, as we don't necessarily
 know which is larger. After we've done this, we should look at the final formula and see whether or not
 we can actually draw any conclusions about which is larger. Adding them together, we initially get the following:

O(C + U + \min(U^2, N)).
So, what do we know about the relative values of N, C, and U? Well, we know that N<C,
as each word contains at least one character (remember, C is total characters across the words, not unique characters).
Additionally, U<C because there can't be more unique characters than there are characters.

In summary, C is the biggest of the three, and N and U are smaller,
although we don't know which is smaller out of those two.

So for starters, we know that the U bit is insignificant compared to the C. Therefore, we can just remove it:

O(C+U+min(U2,N))→O(C+min(U2,N))
Now, to simplify the rest, consider two cases:

If U^2 is smaller than N, then min(U2,N)=U2. By definition, we've just said that U^2
 is smaller than N, which is in turn smaller than C, and so U^2
  is definitely less than C. This leaves us with O(C).

If U^2  is larger than N, then min(U^2, N) = N. Because C>N, we're left with O(C).

So in all cases, we know that C > min(U^2, N). This gives us a final time complexity of O(C).

Space complexity :
O(1) or O(U+min(U2,N))

The adjacency list uses the most auxiliary memory. This list uses O(V+E) memory, where V is the number of unique letters
, and E is the number of relations.

The number of vertices is simply U; the number of unique letters.

The number of edges in the worst case is min(U2,N), as explained in the time complexity analysis.

So in total the adjacency list takes O(U+min(U2,N))space.

So for the question we're given, where U is a constant fixed at a maximum of 26, the space complexity is simply O(1).
This is because U is fixed at 26, and the number of relations is fixed at 26^2 ,
so O(min(26^2, N)) = O(26^2) = O(1)

But when we consider an arbitrarily large number of possible letters, we use the size of the adjacency list;
O(U + min(U^2, N)).
 */
public class AlienDictionary {

    public static void main(String[] args) {
        String[] w = new String[]{"wrt","wrf","er","ett","rftt"};
        System.out.println(new AlienDictionary().alienOrder(w));
    }
    public String alienOrder(String[] words) {
        // create data structure for storing
        // 1. count of unique characters
        // 2. AdjList of character precedence AdjList

        Map<Character,Integer> count = new HashMap<>();
        Map<Character, List<Character>> adj = new HashMap<>();

        for(String w : words){
            for(char c: w.toCharArray()){
                count.put(c,0);
                adj.put(c, new ArrayList<>());
            }
        }

        // create the adjacency relation of characters
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            // Check that word2 is not a prefix of word1.
            if(word1.length()>word2.length() && word1.startsWith(word2))
            {
                return "";
            }
            for(int j=0;j<Math.min(word1.length(), word2.length());j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    count.put(word2.charAt(j),count.get(word2.charAt(j))+1);
                    break;
                }
            }
        }

        // Do a BFS for topological sorting
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // add all unique characters in queue which doesn't have any incoming edge
        // i.e. it behaves as a starting character
        for(Character c : count.keySet()){
            if(count.get(c)==0)
                q.offer(c);
        }

        // do a bfs
        while(!q.isEmpty()){
            Character current = q.poll();
            sb.append(current);
            for( char next: adj.get(current)){
                count.put(next,count.get(next)-1);
                // Incase the count becomes 0, add it to queue
                if(count.get(next)==0){
                    q.offer(next);
                }
            }
        }

        if(sb.length()<count.size())
            return "";

        return sb.toString();
    }
}
