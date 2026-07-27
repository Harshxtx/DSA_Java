package LinkedList.Problems;

import java.util.*;

public class LRU_Cache {
    Node head;
    Node tail;
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(){}
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    LinkedList<Node> ll=new LinkedList<>();
    Map<Integer, Node> mp=new HashMap<>();
    int capacity;
    LRU_Cache(int capacity) {
        this.capacity=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    void movetoHead(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    public int get(int key) {
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            movetoHead(node);
            return node.value;
        }
        else
            return -1;
    }
    void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    void addNode(Node node){
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;;
    }
    public void put(int key, int value) {
        if(!mp.containsKey(key)){
            if(capacity==mp.size()){
                Node rem=tail.prev;
                removeNode(rem);
                mp.remove(rem.key);
            }
            Node node=new Node(key,value);
            addNode(node);
            mp.put(key,node);
        }
        else{
            Node node=mp.get(key);
            node.value=value;
            mp.put(key,node);
            movetoHead(node);
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        LRU_Cache ob = new LRU_Cache(2);
        ob.put(1, 1);                       // cache is {1=1}
        ob.put(2, 2);                       // cache is {1=1, 2=2}
        System.out.println(ob.get(1));      // return 1
        ob.put(3, 3);                       // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(ob.get(2));      // returns -1 (not found)
        ob.put(4, 4);                       // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(ob.get(1));      // return -1 (not found)
        System.out.println(ob.get(3));      // return 3
        System.out.println(ob.get(4));      // return 4
    }
}
