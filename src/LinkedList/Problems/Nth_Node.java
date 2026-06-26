package LinkedList.Problems;

import java.util.*;

public class Nth_Node {
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
    Node nth_node(Node head,int idx){
        Node dummy=new Node(-1);
        dummy.next=head;
        Node slow=dummy;
        Node fast=dummy;
        for(int i=1;i<=idx;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
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
        Nth_Node ob = new Nth_Node();
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int idx=3;
        ob.createlist(arr);
        System.out.println("Original List:");
        ob.display();
        ob.head=ob.nth_node(ob.head,idx);
        System.out.println("After removing Nth Node:");
        ob.display();
    }
}
