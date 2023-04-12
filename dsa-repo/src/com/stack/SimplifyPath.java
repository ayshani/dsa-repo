package com.stack;

import java.util.Stack;

/*
71. Simplify Path

Given a string path, which is an absolute path (starting with a slash '/')
to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory,
a double period '..' refers to the directory up a level,
and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory
    (i.e., no period '.' or double period '..')
Return the simplified canonical path.



Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

TC: o(n)
SC: o(n)

Explanation:
Input: path = "/a/./b/../../c/"
Output: "/c"

Let's understand what this mean's, so basically this seems like you a path of your folder,
so generically we use this kind of command's in terminal. I hope u know a bit about that. Anyway's let's move further on.

okay, so the first command /a/ means get into the folder /a/

The next command is /./ means stay over there

The next command is /b/ means get into the folder /b/

The next command is /../ means come out from the folder /b/

The next command is /../ means come out from the folder /a/

Now we are kind of in home directory

The next command is /c/ means get into the folder /c/

And in the output we return what command we left with.

So, basically what are we doing:-
Pushing and Popping directory names based on rules

And what are the rules :-

/.. come out from the directory
/nameOfDirectory going into directory
We'll solve this problem using Stack.
So, what we can do is by looking at the rules,
    split the directory by the slash/ given and that will give us in the form of array.
But remember when returning we have to go in the form of reverse order.
Because Stack use LIFO order and the highest one will comes out. But we need the lowest once first.
So, we need to append in the careful manner.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));
    }
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] s = path.split("/");
        for(int i=0;i<s.length;i++){
            if(!st.isEmpty() && "..".equals(s[i]))
                st.pop();
            else if(!"".equals(s[i]) && !".".equals(s[i]) && !"..".equals(s[i])){
                st.push(s[i]);
            }
        }

        if(st.isEmpty())
            return "/";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop()).insert(0,"/");
        }
        return sb.toString();
    }
}
