package com.graph.bfs;

import java.util.*;

/*
433. Minimum Genetic Mutation

A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is
defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a
valid gene string.

Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed
to mutate from start to end. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example 1:

Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1

Algorithm
------------
Perform a BFS starting from node start. Keep track of the number of steps taken so far and return that number
of steps when we find end. Only traverse to nodes that are in bank. Neighbors can be found by iterating over
each node and replacing one of the characters with a character from "ACGT".

To check if a node is in bank, we would normally first convert bank to a set to have O(1)O(1) checking.
However, the problem's constraints state that 0 <= bank.length <= 10. With such a small constraint,
it may actually be slower to use a set due to the overhead associated with hashing.
Therefore, we will keep bank as an array.

Initialize a queue queue and a set seen. The queue will be used for BFS and the set will be used to
prevent visiting a node more than once. Initially, the queue and set should hold start.

Perform a BFS. At each node, if node == end, return the number of steps so far. Otherwise, iterate over
all the neighbors. For each neighbor, if neighbor is not in seen and neighbor is in bank, add it to queue and seen.

If we finish the BFS and did not find end, then the task is impossible. Return -1.

Complexity Analysis
---------------------
Time complexity: O(B), where B = bank.length.

As stated before, this is because we are not converting bank to a set due to the low size.
If we did convert bank to a set however, it would still cost O(B) to do so.
Checking if a neighbor is in the bank costs O(B) with an array.

Technically, the BFS runs in constant time because the problem limits the length of the gene
strings to 8 and the strings can only have 4 characters.
However, let's say the gene strings could have length n and could have m kind of characters.
In this problem, we have n=8 and m=4. Then, how many possible nodes are there? There would be m^n possible nodes,
because for each of the n characters, there are m options.

If we are to analyze the complexity like this, let's assume that we are converting bank to a set prior to the BFS.
In that case, the time complexity would be O(nB + m^n . n^2 .m) Converting bank costs O(nB),
then there are n^m states that we could visit. At each state, we perform a nested for loop which
iterates n⋅m times, and also perform string operations which cost O(n).

Space complexity: O(1)

Same logic as before, because the problem limits the input explicitly, we technically use constant space.

However, with the same scenario as above, the space complexity would be O(nB + m^n)
 Converting bank to a set would create a set that takes up O(nB) space, and then the seen set could grow to n^m
 size if all states are visited.
 */
public class MinimumGeneticMutation {

    public static void main(String[] args) {
        String start = "AACCGGTT", end = "AAACGGTA", bank[] = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(new MinimumGeneticMutation().minMutation(start,end,bank));
    }
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int nodesInQueue = queue.size();
            for (int j = 0; j < nodesInQueue; j++) {
                String node = queue.remove();
                if (node.equals(end)) {
                    return steps;
                }
                for (char c: new char[] {'A', 'C', 'G', 'T'}) {
                    for (int i = 0; i < node.length(); i++) {
                        String neighbor = node.substring(0, i) + c + node.substring(i + 1);
                        if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;

    }
}
