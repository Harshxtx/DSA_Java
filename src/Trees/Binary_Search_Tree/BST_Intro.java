package Trees.Binary_Search_Tree;
// Binary Search Tree (BST)
//
// A Binary Search Tree is a binary tree
// that satisfies the BST property:
//
// Left Subtree < Root < Right Subtree
//
// For every node:
//
// All values in the left subtree
// are smaller than the current node.
//
// All values in the right subtree
// are greater than the current node.
//
// Inorder traversal of a BST
// always gives the elements in sorted order.
//
// Time Complexity (Balanced BST):
// Search  : O(log n)
// Insert  : O(log n)
// Delete  : O(log n)
//
// Worst Case (Skewed BST):
// Search/Insert/Delete : O(n)

import java.util.*;

public class BST_Intro {
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
    void inOrder(Node root){            //In BST it always give the output in sorted manner
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Intro tree = new BST_Intro();
        tree.createTree();
        System.out.print("Inorder Traversal (Sorted): ");
        tree.inOrder(tree.root);
    }
}
