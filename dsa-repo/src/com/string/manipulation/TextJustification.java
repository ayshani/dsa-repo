package com.string.manipulation;

import java.util.ArrayList;
import java.util.List;

/*
68. Text Justification

Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth
characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not
divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.


Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

TC : o(n*k)
SC: o(m)
 */
public class TextJustification {

    public static void main(String[] args) {
        String[] words = new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
        };
        System.out.println(new TextJustification().fullJustify(words,16));
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<words.length){
            List<String> currentLine = getWords(i, words, maxWidth);
            i += currentLine.size();
            ans.add(createLine(currentLine, i,words,maxWidth));
        }
        return ans;
    }

    private List<String> getWords(int i, String[] words, int maxWidth){
        List<String> currentLine =  new ArrayList<>();
        int curLength =0;
        while(i<words.length && curLength+words[i].length() <= maxWidth){
            currentLine.add(words[i]);
            curLength += words[i].length() + 1;
            i++;
        }
        return currentLine;
    }

    private String createLine(List<String> line, int i, String[] words,int maxWidth){
        int baseLength = -1;
        for(String word : line){
            baseLength += word.length() +1;
        }

        int extraSpace = maxWidth - baseLength;

        if(line.size()==1 || i == words.length){
            return String.join(" ", line) + " ".repeat(extraSpace);
        }

        int wordCountExcludingLast = line.size() -1;
        int spacePerWord = extraSpace / wordCountExcludingLast;
        int needExtraSpace = extraSpace % wordCountExcludingLast;
        for(int j=0;j<needExtraSpace ;j++){
            line.set(j, line.get(j) + " ");
        }

        for(int j=0;j<wordCountExcludingLast ;j++){
            line.set(j, line.get(j) + " ".repeat(spacePerWord));
        }
        return String.join(" ", line);
    }
}
