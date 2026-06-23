package LinkedList;

import java.util.*;

public class SinglyLinkedList {
    private Node head;
    private int size;

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    boolean isEmpty(){
        return head==null;
    }
    int size(){
        return size;
    }
    void InsertAtStart(int val){
        Node newnode=new Node(val);
        newnode.next=head;
        head=newnode;
        size++;
    }
    void InsertAtIndex(int val,int idx){
        if(idx<0 || idx>size){
            System.out.println("Invalid");
            return;
        }
        if(idx==0){
            InsertAtStart(val);
            return;
        }
        Node newnode=new Node(val);
        Node temp=head;
        for(int i=0;i<idx-1;i++) {
            temp = temp.next;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        size++;
    }
    void InsertAtEnd(int val){
        Node newnode=new Node(val);
        if(isEmpty()){
            head=newnode;
            size++;
            return ;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        size++;
    }
    int DeleteAtStart(){
        if(isEmpty()){
            System.out.println("List isEmpty");
            return -1;
        }
        int ret=head.data;
        head=head.next;
        size--;
        return ret;
    }
    int DeleteAtIndex(int idx){
        if(idx<0 || idx>size){
            System.out.println("Invalid");
            return -1;
        }
        if(idx==0){
            return DeleteAtStart();
        }
        Node temp=head;
        for(int i=0;i<idx-1;i++){
            temp=temp.next;
        }
        int ret= temp.next.data;
        temp.next=temp.next.next;
        size--;
        return ret;
    }
    int DeleteAtEnd(){
        if(head.next==null){
            int ret=head.data;
            head=null;
            return ret;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        int ret= temp.next.data;
        temp.next=null;
        size--;
        return ret;
    }
    boolean search(int key){
        Node temp=head;
        while(temp!=null){
            if(temp.data==key)
                return true;
            temp=temp.next;
        }
        return false;
    }
    void display(){
        if(isEmpty()){
            System.out.println("List Empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        // Insertions
        list.InsertAtStart(20);
        list.InsertAtStart(10);
        list.InsertAtEnd(30);
        list.InsertAtEnd(40);
        list.InsertAtIndex(25, 2);
        System.out.println("Linked List:");
        list.display();

        // Deletions
        System.out.println("\nRemoved First: " + list.DeleteAtStart());
        System.out.println("Removed Last: "+ list.DeleteAtEnd());
        System.out.println("Removed Index 1: "+ list.DeleteAtIndex(1));

        System.out.println("\nUpdated List:");
        list.display();

        // Search
        System.out.println("\nIs 20 Present? "+ list.search(20));
        System.out.println("Is 100 Present? "+list.search(100));
        // Size
        System.out.println("\nSize: "+list.size());
        // Empty Check
        System.out.println("Is Empty: "+list.isEmpty());
    }
}
