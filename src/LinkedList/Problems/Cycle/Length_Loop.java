package LinkedList.Problems.Cycle;

import java.util.*;

public class Length_Loop {
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
    void createCycle(int pos) {
        if (pos < 0) {
            return;
        }
        Node tail = head;
        Node cycleNode = null;
        int index = 0;
        while (tail.next != null) {
            if (index == pos) {
                cycleNode = tail;
            }
            tail = tail.next;
            index++;
        }
        tail.next=cycleNode;
    }
    int lengthCycle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }
        if(slow==fast) {
            int i=1;
            Node curr = slow;
            while (curr.next != slow) {
                i++;
                curr = curr.next;
            }
            return i;
        }
        return 0;
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
        Length_Loop ob = new Length_Loop();
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int pos=3;
        ob.createlist(arr);
        System.out.println("Original List:");
        ob.display();
        ob.createCycle(pos);
        int len=ob.lengthCycle(ob.head);
        if(len!=0)
            System.out.println("Length of the loop: "+len);
        else
            System.out.println("No loop detected");
    }
}
