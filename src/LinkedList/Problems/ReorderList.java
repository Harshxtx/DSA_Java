package LinkedList.Problems;

import java.util.*;

public class ReorderList {
    private Node head;

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
        Node(int data, Node next){
            this.data=data;
            this.next=next;
        }
    }
    void createlist(int arr[]){
        Node tail=null;
        for(int n:arr){
            Node newnode=new Node(n);
            if(head==null){
                head=newnode;
                tail=newnode;
            }
            else{
                tail.next=newnode;
                tail=newnode;
            }
        }
    }
    Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    void reorder(Node head){
        if(head==null || head.next==null){
            return;
        }
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node pri=head;
        Node sec=reverse(slow.next);
        slow.next=null;
        while(sec!=null){
            Node t1=pri.next;
            Node t2=sec.next;
            pri.next=sec;
            sec.next=t1;
            pri=t1;
            sec=t2;
        }
    }
    void display(){
        if(head==null){
            System.out.println("list is empty");
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
        ReorderList ob = new ReorderList();
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        ob.createlist(arr);
        System.out.println("Original List:");
        ob.display();
        ob.reorder(ob.head);
        System.out.println("List after reorder: ");
        ob.display();
    }
}
