package LinkedList.Problems;

import java.util.*;

public class Palindrome {
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
    boolean Palindrome(Node head){
        if(head==null || head.next==null){
            return true;
        }
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node pri=head;
        Node sec=reverse(slow);
        Node temp=sec;
        while(sec!=null){
            if(pri.data!=sec.data) {
                reverse(temp);
                return false;
            }
            pri=pri.next;
            sec=sec.next;
        }
        reverse(temp);
        return true;
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
        Palindrome ob = new Palindrome();
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        //int arr[]={1,2,3,4,5,5,4,3,2,1};
        //int arr[]={1,2,3,4,5,4,3,2,1};
        ob.createlist(arr);
        System.out.println("Original List:");
        ob.display();
        if(ob.Palindrome(ob.head)){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
        ob.display();
    }
}
