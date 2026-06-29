package LinkedList.Problems;

import java.util.*;

public class Reverse_K_Groups {
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
    Node reverse(Node curr, Node end){
        Node prev=end;
        while(curr!=end){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    Node reverseKGroup(Node head, int k) {
        if(head==null || k==1)
            return head;
        Node dum=new Node(-1);
        dum.next=head;
        Node temp=dum;
        int i;
        while(true){
            Node tail=temp.next;
            for(i=1;i<=k;i++){
                if(tail==null)
                    return dum.next;
                tail=tail.next;
            }
            Node curr=temp.next;
            temp.next=reverse(curr,tail);
            temp=curr;
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
        Reverse_K_Groups ob = new Reverse_K_Groups();
        int arr[]={1,2,3,4,5};
        int k=2;
        ob.createlist(arr);
        System.out.println("Original List:");
        ob.display();
        ob.head=ob.reverseKGroup(ob.head,k);
        System.out.println("Reverse List:");
        ob.display();
    }
}
