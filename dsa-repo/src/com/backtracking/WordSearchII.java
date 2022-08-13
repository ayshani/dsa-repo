package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
212. Word Search II

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:
Input: board = [
["o","a","a","n"],
["e","t","a","e"],
["i","h","k","r"],
["i","f","l","v"]],
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
 */
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        TrieNode root = buildTrieNode(words);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board, i,j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return;
        char currentBoardCharacter = board[i][j];
        if(currentBoardCharacter== '#' || root.next[currentBoardCharacter-'a']== null)
            return;

        root = root.next[currentBoardCharacter - 'a'];

        if(root.word !=null)
        {
            result.add(root.word);
            root.word =null;
        }

        board[i][j]='#';

        dfs(board,i-1,j,root,result);
        dfs(board,i+1,j,root,result);
        dfs(board,i,j-1, root,result);
        dfs(board, i, j+1, root,result);
        board[i][j] = currentBoardCharacter;
    }

    public TrieNode buildTrieNode(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode current = root;
            for(char currentCharacter : word.toCharArray()){
                int i= currentCharacter -'a';
                if(current.next[i] == null){
                    current.next[i] = new TrieNode();
                }
                current = current.next[i];
            }
            current.word = word;
        }
        return root;
    }
}
