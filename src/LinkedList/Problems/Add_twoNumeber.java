package LinkedList.Problems;

import java.util.*;

public class Add_twoNumeber {
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
    Node add(Node list1,Node list2){
        Node dummy=new Node(-1);
        Node curr=dummy;
        int carry=0;
        while(list1!=null || list2!=null || carry!=0) {
            int x=(list1!=null)?list1.data:0;
            int y=(list2!=null)?list2.data:0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new Node(sum%10);
            curr=curr.next;
            if(list1!=null)
                list1=list1.next;
            if(list2!=null)
                list2=list2.next;
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
        Add_twoNumeber ob = new Add_twoNumeber();
        int arr1[]={2,4,3};
        int arr2[]={5,6,4};
//        int arr1[]={9,9,9};
//        int arr2[]={9,9,9};
        ob.createlist1(arr1);
        ob.createlist2(arr2);
        System.out.println("First List:");
        ob.display(ob.head1);
        System.out.println("Second List:");
        ob.display(ob.head2);
        Node list=ob.add(ob.head1,ob.head2);
        System.out.println("Sum of two numbers:");
        ob.display(list);
    }
}
