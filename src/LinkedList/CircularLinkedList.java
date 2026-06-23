package LinkedList;

import java.util.*;

public class CircularLinkedList {
    Node head;
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
        if (isEmpty()) {
            head = newnode;
            newnode.next = head;
            size++;
            return;
        }
        Node temp=head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newnode.next = head;
        temp.next = newnode;
        head = newnode;
        size++;
    }
    void InsertAtIndex(int idx,int val){
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
            newnode.next=head;
            size++;
            return;
        }
        Node temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=head;
        size++;
    }
    int DeleteAtStart(){
        if(isEmpty()){
            System.out.println("List isEmpty");
            return -1;
        }
        if(head.next==head){
            int ret=head.data;
            head=null;
            size--;
            return ret;
        }
        Node temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        int ret= head.data;
        head=head.next;
        temp.next=head;
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
        if (isEmpty()) {
            System.out.println("List Empty");
            return -1;
        }
        if(head.next==head){
            int ret=head.data;
            head=null;
            return ret;
        }
        Node temp=head;
        while(temp.next.next!=head){
            temp=temp.next;
        }
        int ret= temp.next.data;
        temp.next=head;
        size--;
        return ret;
    }
    boolean search(int key){
        Node temp=head;
        do {
            if(temp.data==key) {
                return true;
            }
            temp=temp.next;
        }
        while(temp != head);
        return false;
    }
    void display(){
        if(isEmpty()){
            System.out.println("List Empty");
            return;
        }
        Node temp=head;
        System.out.print("head->");
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while(temp!=head);
        System.out.println("head");
        }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        // Insertions
        list.InsertAtStart(20);
        list.InsertAtStart(10);
        list.InsertAtEnd(40);
        list.InsertAtIndex(2, 30);

        System.out.println("Circular Linked List:");
        list.display();

        // Deletions
        System.out.println("\nDeleted Start: "+ list.DeleteAtStart());
        System.out.println("Deleted End: "+ list.DeleteAtEnd());
        System.out.println("Deleted Index 0: "+ list.DeleteAtIndex(0));

        System.out.println("\nUpdated List:");
        list.display();

        // Search
        System.out.println("\nIs 20 Present? "+ list.search(20));
        System.out.println("Is 30 Present? "+ list.search(30));

        // Size
        System.out.println("\nSize: "+ list.size());

        // Empty Check
        System.out.println("Is Empty: "+ list.isEmpty());

    }
}
