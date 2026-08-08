package LinkedList.Problems;

import java.util.*;

public class Sort_List {
    private Node head;

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
        Node(){
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
    Node merge(Node l1,Node l2){
        Node dumm=new Node();
        Node curr=dumm;
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                curr.next=l1;
                l1=l1.next;
            }
            else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        if(l1!=null){
            curr.next=l1;
        }
        if(l2!=null){
            curr.next=l2;
        }
        return dumm.next;
    }
    public Node sortList(Node head) {
        if(head==null || head.next==null)
            return head;
        Node prev=null;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        Node l1=sortList(head);
        Node l2=sortList(slow);
        return merge(l1,l2);
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
        Sort_List ob = new Sort_List();
        int arr[]={10,9,8,7,6,5,4,3,2,1};
        ob.createlist(arr);
        System.out.println("Original List:");
        ob.display();
        ob.head=ob.sortList(ob.head);
        System.out.println("After Sorting List:");
        ob.display();
    }
}
