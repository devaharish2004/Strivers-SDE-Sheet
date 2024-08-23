import java.util.*;
class Node {
    int key;
    int value;
    Node prev = null;
    Node next = null;
    Node(int _key, int _value){
        key = _key;
        value = _value;
    }
}

class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node>map = new HashMap<>();
    int capacity;
    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node keyNode = map.get(key);
            removeNode(keyNode);
            insertNode(keyNode);
            return keyNode.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }
        if(map.size() == capacity){
            removeNode(tail.prev);
        }
        insertNode(new Node(key, value));
    }

    private void insertNode(Node node){
        map.put(node.key, node);
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    private void removeNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

//Implemented using DLL and HashMap
//DLL for making insertions and deletions in less time
//Hashmap for accessing the node values in O(1) time

//TC : O(1) - average time complexity
//SC : O(N)

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */