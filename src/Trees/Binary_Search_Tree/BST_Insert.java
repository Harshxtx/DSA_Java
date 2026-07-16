package Trees.Binary_Search_Tree;
// Insert into a Binary Search Tree
//
// Pattern : BST Recursion
//
// Core Idea:
// Compare the value with the current node.
//
// If value is smaller,
// insert into the left subtree.
//
// Otherwise,
// insert into the right subtree.
//
// When a null position is found,
// create and return the new node.
//
// Time Complexity : O(h)
// Space Complexity : O(h)

import java.util.*;

public class BST_Insert {
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
        //        4
        //       / \
        //      2   7
        //     / \
        //    1   3
        root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(7);

        root.left.left = new Node(1);
        root.left.right = new Node(3);
    }
    Node insertIntoBST(Node root, int val) {
        if(root==null)
            return new Node(val);
        if(root.data>val)
            root.left=insertIntoBST(root.left,val);
        else{
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Insert tree = new BST_Insert();
        tree.createTree();
        int val=5;
        System.out.print("Original Tree: ");
        tree.display(tree.root);
        tree.root=tree.insertIntoBST(tree.root,val);
        System.out.print("\nTree after insertion: ");
        tree.display(tree.root);
    }
}
