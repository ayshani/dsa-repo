package com.stack;

import java.util.Stack;

/*
1598. Crawler Log Folder

The Leetcode file system keeps a log each time some user performs a change folder operation.

The operations are described below:

"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the
same folder).
"./" : Remain in the same folder.
"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

The file system starts in the main folder, then the operations in logs are performed.

Return the minimum number of operations needed to go back to the main folder after the change folder operations.



Example 1:
Input: logs = ["d1/","d2/","../","d21/","./"]
Output: 2
Explanation: Use this change folder operation "../" 2 times and go back to the main folder.

TC : o(n)
SC: o(n)
 */
public class CrawlerLogFolder {

    public static void main(String[] args) {
        System.out.println(new CrawlerLogFolder().minOperations(
                new String[]{"d1/","d2/","../","d21/","./"}
        ));
    }
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();

        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("../")){
                if(!st.isEmpty())
                    st.pop();
            } else if(!logs[i].equals("./")){
                st.push(logs[i]);
            }
        }
        return st.size();
    }
}
