package com.graph.bfs;

import java.util.*;

/*
126. Word Ladder II

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a
sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest
transformation sequences from beginWord to endWord, or an empty list if no such sequence exists.
Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"

Logic
-----

The solution contains two steps
1 Use BFS to construct a graph.
2. Use DFS to construct the paths from end to start.Both solutions got AC within 1s.

The first step BFS is quite important. I summarized three tricks

Using a MAP to store the min ladder of each word, or use a SET to store the words visited in current ladder,
when the current ladder was completed, delete the visited words from unvisited.

Use Character iteration to find all possible paths.
Do not compare one word to all the other words and check if they only differ by one character.

One word is allowed to be inserted into the queue only ONCE.
 */
public class WordLadderII {

    List<List<String>> results;
    List<String> list;
    Map<String,List<String>> map;

    public static void main(String[] args) {
        //beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println(new WordLadderII().findLadders(beginWord,endWord,wordList));
    }
    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        results= new ArrayList<List<String>>();
        if (dict.size() == 0)
            return results;
        if(!dict.contains(end))
            return results;
        int curr=1,next=0;
        boolean found=false;
        list = new LinkedList<String>();
        map = new HashMap<String,List<String>>();

        Queue<String> queue= new ArrayDeque<>();
        Set<String> unvisited = new HashSet<>(dict);
        Set<String> visited = new HashSet<>();

        queue.add(start);
        unvisited.add(end);
        unvisited.remove(start);
        //BFS
        while (!queue.isEmpty()) {

            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++){
                StringBuilder builder = new StringBuilder(word);
                for (char ch='a';  ch <= 'z'; ch++){
                    builder.setCharAt(i,ch);
                    String new_word=builder.toString();
                    if (unvisited.contains(new_word)){
                        //Handle queue
                        if (visited.add(new_word)){//Key statement,Avoid Duplicate queue insertion
                            next++;
                            queue.add(new_word);
                        }

                        //Build Adjacent Graph
                        map.computeIfAbsent(new_word, value -> new LinkedList<String>()).add(word);
                        if (new_word.equals(end)&&!found) found=true;
                    }

                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
            if (curr==0){
                if (found) break;
                curr=next;
                next=0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }//End While

        backTrace(end,start);

        return results;
    }
    private void backTrace(String word,String start){
        if (word.equals(start)){
            list.add(0,start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if (map.get(word)!=null)
            for (String s:map.get(word))
                backTrace(s,start);
        list.remove(0);
    }
}

