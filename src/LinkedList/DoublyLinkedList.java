package LinkedList;

import java.util.*;

public class DoublyLinkedList {
    private Node head;
    private int size;

    private static class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data=data;
            this.prev=null;
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
        if(isEmpty()){
            head=newnode;
            size++;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
        size++;
    }
    void InsertAtIndex(int idx,int val){
        if (idx < 0 || idx > size) {
            System.out.println("Invalid Index");
            return;
        }
        if (idx == 0) {
            InsertAtStart(val);
            return;
        }
        if (idx == size) {
            InsertAtEnd(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
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
        newnode.prev=temp;
        size++;
    }
    int DeleteAtStart(){
        if(isEmpty()){
            System.out.println("List isEmpty");
            return -1;
        }
        if(head.next == null){
            int ret= head.data;
            head = null;
            size--;
            return ret;
        }
        int ret=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return ret;
    }
    int DeleteAtIndex(int idx){
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid Index");
            return -1;
        }
        if (idx == 0) {
            return DeleteAtStart();
        }
        if (idx == size - 1) {
            return DeleteAtEnd();
        }
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        int ret = temp.data;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
        return ret;
    }
    int DeleteAtEnd(){
        if(isEmpty()){
            System.out.println("List isEmpty");
            return -1;
        }
        if(head.next==null){
            int ret=head.data;
            head=null;
            return ret;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        int ret= temp.data;
        temp.prev.next=null;
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
    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List Empty");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();// Insertions
        list.InsertAtStart(20);
        list.InsertAtStart(10);
        list.InsertAtEnd(40);
        list.InsertAtIndex(2, 30);

        System.out.println("Forward Display:");
        list.displayForward();

        System.out.println("\nBackward Display:");
        list.displayBackward();

        // Deletions
        System.out.println("\nDeleted Start: " + list.DeleteAtStart());
        System.out.println("Deleted End: " + list.DeleteAtEnd());
        System.out.println("Deleted Index 0: "+ list.DeleteAtIndex(0));

        System.out.println("\nUpdated List:");
        list.displayForward();

        // Search
        System.out.println("\nIs 20 Present? " + list.search(20));
        System.out.println("Is 100 Present? "+ list.search(100));

        // Size
        System.out.println("\nSize: "+ list.size());
        // Empty Check
        System.out.println("Is Empty: "+ list.isEmpty());
    }
}
