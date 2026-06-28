package LinkedList.Problems;

import java.util.*;

public class Remove_Duplicate {
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
    Node removeDuplicate(Node head){
        if(head==null || head.next==null)
            return head;
        Node temp=head;
        while(head!=null && head.next!=null){

            if(head.data==head.next.data)
                head.next=head.next.next;
            else
                head=head.next;
        }
        return temp;
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
        Remove_Duplicate ob = new Remove_Duplicate();
        int arr[]={1,2,2,5,6,7,8,8,8,12};
        ob.createlist(arr);
        System.out.println("Original List:");
        ob.display();
        ob.head=ob.removeDuplicate(ob.head);
        System.out.println("Linked List after removing duplicate elements:");
        ob.display();
    }
}
