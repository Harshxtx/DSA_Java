package LinkedList.Problems;

import java.util.*;

public class Merge_two_LL {
    private Node head1;
    private Node head2;

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    void createlist1(int arr[]){
        Node tail=null;
        for(int n:arr){
            Node newnode=new Node(n);
            if(head1==null){
                head1=newnode;
                tail=newnode;
            }
            else{
                tail.next=newnode;
                tail=newnode;
            }
        }
    }
    void createlist2(int arr[]){
        Node tail=null;
        for(int n:arr){
            Node newnode=new Node(n);
            if(head2==null){
                head2=newnode;
                tail=newnode;
            }
            else{
                tail.next=newnode;
                tail=newnode;
            }
        }
    }
    Node merge(Node list1,Node list2){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(list1!=null && list2!=null) {
            if(list1.data<=list2.data) {
                temp.next = list1;
                list1 = list1.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1!=null) {
            temp.next=list1;
        }
        if(list2!=null) {
            temp.next=list2;
        }
        return dummy.next;
    }
    void display(Node head){
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
        Merge_two_LL ob = new Merge_two_LL();
        int arr1[]={1,3,5,7,9};
        int arr2[]={2,4,6,8,10};
        ob.createlist1(arr1);
        ob.createlist2(arr2);
        System.out.println("First List:");
        ob.display(ob.head1);
        System.out.println("Second List:");
        ob.display(ob.head2);
        Node list=ob.merge(ob.head1,ob.head2);
        System.out.println("Merged List:");
        ob.display(list);
    }
}
