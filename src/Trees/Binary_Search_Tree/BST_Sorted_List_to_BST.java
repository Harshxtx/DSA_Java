package Trees.Binary_Search_Tree;
// Method: Slow & Fast Pointer
//
// Idea:
// Find the middle node of the linked list.
//
// The middle node becomes the root.
//
// Split the list into:
//
// Left Half
// Middle
// Right Half
//
// Recursively construct
// left and right subtrees.
//
// Time Complexity : O(n log n)
// Space Complexity : O(log n)

import java.util.*;

public class BST_Sorted_List_to_BST {
    private Node root;
    private ListNode head;
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    private static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    void createList(){
        //        8

        head=new ListNode(-10);
        head.next=new ListNode(-3);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(5);
        head.next.next.next.next=new ListNode(9);
    }
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    ListNode findMid(ListNode head){
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null)
            prev.next=null;
        return slow;
    }
    Node build(ListNode head){
        if(head==null)
            return null;
        if(head.next==null)
            return new Node(head.val);
        ListNode mid=findMid(head);
        Node root=new Node(mid.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        return root;
    }
    public Node sortedListToBST(ListNode head) {
        return build(head);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Sorted_List_to_BST tree = new BST_Sorted_List_to_BST();
        tree.createList();
        tree.root=tree.sortedListToBST(tree.head);
        tree.display(tree.root);
    }
}
