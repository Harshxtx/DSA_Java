package Trees.Binary_Search_Tree;
// Search in a Binary Search Tree
//
// Pattern : BST Traversal
//
// Core Idea:
// Compare the target value with
// the current node.
//
// If equal, return the node.
//
// If target is smaller,
// move to the left subtree.
//
// Otherwise,
// move to the right subtree.
//
// Time Complexity : O(h)
// Space Complexity : O(h)  -> Recursive
//                    O(1)  -> Iterative

import java.util.*;

public class BST_Search {
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
    // 1st Method: Recursive Solution
    // Time Complexity : O(h)
    // Space Complexity : O(h)
//    Node searchBST(Node root, int val) {
//        if(root==null)
//            return null;
//        if(root.data==val)
//            return root;
//        if(root.data>val)
//            return searchBST(root.left,val);
//        else
//            return searchBST(root.right,val);
//    }

    // 2nd Method: Iterative Solution
    // Time Complexity : O(h)
    // Space Complexity : O(1)
    Node searchBST(Node root, int val) {
        while(root!=null){
            if(root.data==val){
                return root;
            }
            if(val<root.data)
                root=root.left;
            else
                root=root.right;
        }
        return null;
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
        BST_Search tree = new BST_Search();
        tree.createTree();
        int val=2;
        System.out.print("Original tree: ");
        tree.display(tree.root);
        tree.root=tree.searchBST(tree.root,val);
        System.out.print("\nSubtree of searched value is: ");
        tree.display(tree.root);
    }
}
