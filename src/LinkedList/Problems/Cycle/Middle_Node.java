package LinkedList.Problems.Cycle;

import java.util.*;

public class Middle_Node {
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
    Node middlenode(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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
        Middle_Node ob = new Middle_Node();
        //int arr[]={1,2,3,4,5};
        int arr[]={1,2,3,4,5,6};
        ob.createlist(arr);
        System.out.println("Original List:");
        ob.display();
        Node middleNode=ob.middlenode(ob.head);
        System.out.println("Middle Node:"+middleNode.data);

    }
}
