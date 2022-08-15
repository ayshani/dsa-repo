package com.graph.bfs;

import java.util.*;

/*
127. Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList
is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words
in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog",
which is 5 words long.

Time Complexity :- BigO(M^2 * N),
where M is size of dequeued word & N is size of our word list

Space Complexity :- BigO(M * N)
where M is no. of character that we had in our string & N is the size of our wordList.
 */
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println(new WordLadder().ladderLength(beginWord,endWord,wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        int change =1;
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();

        visited.add(beginWord);

        while(!q.isEmpty()){
            int size= q.size();

            for(int i=0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord))
                    return change;
                for(int j=0;j<word.length();j++){

                    for(int k = 'a';k<='z';k++ ){
                        char[] c = word.toCharArray();
                        c[j]=(char) k;
                        String s = new String(c);
                        if(dict.contains(s) && !visited.contains(s)){
                            q.offer(s);
                            visited.add(s);
                        }
                    }
                }
            }
            ++change;
        }

        return 0;
    }

}
