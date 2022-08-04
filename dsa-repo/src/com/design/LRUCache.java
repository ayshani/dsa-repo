package com.design;

import java.util.HashMap;
import java.util.Map;

/*
146. LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.

int get(int key) Return the value of the key if the key exists, otherwise return -1.

void put(int key, int value) Update the value of the key if the key exists. Otherwise,
add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.



Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

Logic
-----
1.The key to solve this problem is using a double linked list which enables us to quickly move nodes.
2.The LRU cache is a hash table of keys and double linked nodes. The hash table makes the time of get() to be O(1).
The list of double linked nodes make the nodes adding/removal operations O(1).

TC : o(1)
SC : o(capacity)
 */
public class LRUCache {
    Map<Integer,Node> map;
    int capacity, count =0;
    Node head, tail;

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count=0;
    }

    public int get(int key) {
        if(map.get(key)!=null){
            Node node = map.get(key);
            int result = node.value;
            removeNode(node);
            addToHead(node);
            return result;
        } else
            return -1;

    }

    public void put(int key, int value) {
        if(map.get(key)!=null){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else{
            Node node = new Node(key,value);
            map.put(key,node);
            if(count<capacity){
                count++;
                addToHead(node);
            } else{
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                addToHead(node);
            }
        }
    }

    void removeNode( Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;

    }
}

class Node{
    int key,value;
    Node prev, next;

    Node(int key,int val){
        this.key = key;
        this.value = val;
    }
}
