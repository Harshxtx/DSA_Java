package Heap.Problems;

import java.util.*;

public class Merge_K_Sorted_Lists {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    Node createlist1(){
        Node head=new Node(1);
        head.next=new Node(4);
        head.next.next=new Node(5);
        return head;
    }
    Node createlist2(){
        Node head=new Node(1);
        head.next=new Node(3);
        head.next.next=new Node(4);
        return head;
    }
    Node createlist3(){
        Node head=new Node(2);
        head.next=new Node(6);
        head.next.next=new Node(7);
        return head;
    }
    Node mergeKLists(Node[] lists) {
        int i,l=lists.length;
        if(l==0)
            return null;
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b) -> Integer.compare(a.data, b.data));
        Node head=new Node(-1);
        Node temp=head;
        for(i=0;i<l;i++){
            if(lists[i]!=null)
                pq.offer(lists[i]);
        }
        while(!pq.isEmpty()){
            Node curr=pq.poll();
            temp.next=curr;
            temp=temp.next;
            if(curr.next!=null)
                pq.offer(curr.next);
        }
        return head.next;
    }
    void display(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Merge_K_Sorted_Lists ob = new Merge_K_Sorted_Lists();
        Node l1=ob.createlist1();
        Node l2=ob.createlist2();
        Node l3=ob.createlist3();
        Node lists[]={l1,l2,l3};
        Node head=ob.mergeKLists(lists);
        ob.display(head);
    }
}
