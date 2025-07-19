package com.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
1233. Remove Sub-Folders from the Filesystem

Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return
the answer in any order.

If a folder[i] is located within another folder[j], it is called a sub-folder of it. A sub-folder of folder[j] must
start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder
of "/a/b/c".

The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English
letters.

For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.


Example 1:

Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
Output: ["/a","/c/d","/c/f"]
Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.

TC : o(n)
SC: o(n)
 */
public class RemoveSubFoldersFromTheFilesystem {

    public static void main(String[] args) {
        RemoveSubFoldersFromTheFilesystem obj = new RemoveSubFoldersFromTheFilesystem();
        ///root  = new TrieNode();
        System.out.println(new RemoveSubFoldersFromTheFilesystem().removeSubfolders(new String[]{
                "/a","/a/b","/c/d","/c/d/e","/c/f"
        }));
    }
    static class TrieNode {

        boolean isEndOfFolder;
        HashMap<String, TrieNode> children;

        TrieNode() {
            this.isEndOfFolder = false;
            this.children = new HashMap<>();
        }
    }

    public TrieNode root;


    public List<String> removeSubfolders(String[] folder) {
        root = new TrieNode();
        // Build Trie from folder paths
        for (String path : folder) {
            TrieNode currentNode = root;
            String[] folderNames = path.split("/");

            for (String folderName : folderNames) {
                // Skip empty folder names
                if (folderName.equals("")) continue;
                // Create new node if it doesn't exist
                if (!currentNode.children.containsKey(folderName)) {
                    currentNode.children.put(folderName, new TrieNode());
                }
                currentNode = currentNode.children.get(folderName);
            }

            // Mark the end of the folder path
            currentNode.isEndOfFolder = true;
        }

        // Check each path for subfolders
        List<String> result = new ArrayList<>();
        for (String path : folder) {
            TrieNode currentNode = root;
            String[] folderNames = path.split("/");
            boolean isSubfolder = false;

            for (int i = 0; i < folderNames.length; i++) {
                // Skip empty folder names
                if (folderNames[i].equals("")) continue;

                TrieNode nextNode = currentNode.children.get(folderNames[i]);
                // Check if the current folder path is a subfolder of an
                // existing folder
                if (nextNode.isEndOfFolder && i != folderNames.length - 1) {
                    isSubfolder = true;
                    break; // Found a sub-folder
                }
                currentNode = nextNode;
            }
            // If not a sub-folder, add to the result
            if (!isSubfolder) result.add(path);
        }

        return result;
    }
}
