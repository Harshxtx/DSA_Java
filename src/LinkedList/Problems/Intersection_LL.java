package LinkedList.Problems;

import java.util.*;

public class Intersection_LL {
    private Node head1;
    private Node head2;

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
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
    void createIntersection(int k){
        Node temp1=head1;
        while(temp1!=null && temp1.data!=k) {
            temp1=temp1.next;
        }
        Node temp2=head2;
        while(temp2.next!=null) {
            temp2=temp2.next;
        }
        temp2.next=temp1;
    }
    Node intersectionNode(Node head1,Node head2){
        Node l1=head1;
        Node l2=head2;
        while(l1!=l2){
            if(l1==null)
                l1=head2;
            else
                l1=l1.next;
            if(l2==null)
                l2=head1;
            else l2=l2.next;
        }
        return l1;
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
        Intersection_LL ob = new Intersection_LL();
        int arr1[]={5,6,1,8,4,5};
        int arr2[]={4,1,8,4,5};
        int k=8;
        ob.createlist1(arr1);
        ob.createlist2(arr2);
        ob.createIntersection(k);
        System.out.println("First List:");
        ob.display(ob.head1);
        System.out.println("Second List:");
        ob.display(ob.head2);
        Node intersectedNode=ob.intersectionNode(ob.head1,ob.head2);
        if(intersectedNode!=null)
            System.out.println("Intersection Node: "+intersectedNode.data);
        else
            System.out.println("No Intersection Found");
    }
}
