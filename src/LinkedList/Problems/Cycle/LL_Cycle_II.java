package LinkedList.Problems.Cycle;

import java.util.*;

public class LL_Cycle_II {
    private Node head;

    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
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
        Node tail=head;
        Node cycleNode=null;
        int index=0;
        while(tail.next!=null) {
            if (index == pos) {
                cycleNode = tail;
            }
            tail = tail.next;
            index++;
        }
        tail.next=cycleNode;
    }
    int[] detectcycle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }
        int i=0;
        if(slow==fast){
            slow=head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
                i++;
            }
            return new int[]{i,slow.data};
        }
        return new int[]{-1,-1};
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
        LL_Cycle_II ob = new LL_Cycle_II();
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int pos=2;
        ob.createlist(arr);
        System.out.println("Original List:");
        ob.display();
        ob.createCycle(pos);
        int res[]=ob.detectcycle(ob.head);
        if(res[0]!=-1) {
            System.out.println("Node is intersecting at index(0-based index): "+res[0]+" and value is: "+res[1]);
        }
        else
            System.out.println("There is no intersecting node");
    }
}
