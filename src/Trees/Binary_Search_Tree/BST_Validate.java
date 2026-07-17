package Trees.Binary_Search_Tree;
// Validate Binary Search Tree
//
// Pattern : DFS + Range Validation
//
// Core Idea:
// Every node must lie within a valid range.
//
// Initially,
// the valid range is (-∞, +∞).
//
// For the left subtree,
// update the upper bound to the current node.
//
// For the right subtree,
// update the lower bound to the current node.
//
// If any node violates the range,
// the tree is not a BST.
//
// Time Complexity : O(n)
// Space Complexity : O(h)

import java.util.*;

public class BST_Validate {
    private Node root;

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
    void createTree(){
        //        8
        //       / \
        //      3   10
        //     / \   \
        //    1   6   17
        root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.right.right = new Node(17);
    }
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    boolean help(Node node, long min, long max){
        if(node==null)
            return true;
        if(node.data<=min || node.data>=max)
            return false;
        return help(node.left,min,node.data) && help(node.right,node.data,max);

    }
    public boolean isValidBST(Node root) {
        return help(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Validate tree = new BST_Validate();
        tree.createTree();
        String str=tree.isValidBST(tree.root)?"a":"not a";
        System.out.print("The given Binary Tree is "+str+" Binary Search Tree");
    }
}
