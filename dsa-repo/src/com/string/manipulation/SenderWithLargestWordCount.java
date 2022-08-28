package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
2284. Sender With Largest Word Count

You have a chat log of n messages. You are given two string arrays messages and senders
where messages[i] is a message sent by senders[i].

A message is list of words that are separated by a single space with no leading or trailing spaces.
The word count of a sender is the total number of words sent by the sender. Note that a sender may send more than one message.

Return the sender with the largest word count. If there is more than one sender with the largest word count,
return the one with the lexicographically largest name.

Note:

Uppercase letters come before lowercase letters in lexicographical order.
"Alice" and "alice" are distinct.


Example 1:

Input: messages = ["Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"],
senders = ["Alice","userTwo","userThree","Alice"]
Output: "Alice"
Explanation: Alice sends a total of 2 + 3 = 5 words.
userTwo sends a total of 2 words.
userThree sends a total of 3 words.
Since Alice has the largest word count, we return "Alice".

Time Complexity - O(messages.length*messages[i].length)
Space Compexity - O(senders.length);
 */
public class SenderWithLargestWordCount {

    public static void main(String[] args) {
        String[] mes = new String[]{
                "Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"
        };

        String[] senders = new String[]{"Alice","userTwo","userThree","Alice"};

        System.out.println(new SenderWithLargestWordCount().largestWordCount(mes,senders));
    }
    public String largestWordCount(String[] messages, String[] sender) {
        Map<String,Integer> wordCountMap= new HashMap<>();

        int maxCount =0;
        String senderName = "";
        for(int i=0;i<messages.length;i++){
            String[] wordsPerMessage = messages[i].split(" ");

            wordCountMap.put(sender[i],wordCountMap.getOrDefault(sender[i],0)+wordsPerMessage.length);
            if(wordCountMap.get(sender[i])>maxCount){
                maxCount =wordCountMap.get(sender[i]);
                senderName = sender[i];
            } else if(wordCountMap.get(sender[i])==maxCount && senderName.compareTo(sender[i])<0){
                senderName = sender[i];
            }
        }

        return senderName;
    }
}
