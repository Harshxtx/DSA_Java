package Trees.Binary_Search_Tree;
// Lowest Common Ancestor of a BST
//
// Pattern : BST Traversal
//
// Core Idea:
// Use the BST property to move
// toward the Lowest Common Ancestor.
//
// If both nodes are smaller than
// the current node,
// move to the left subtree.
//
// If both nodes are greater than
// the current node,
// move to the right subtree.
//
// Otherwise,
// the current node is the
// Lowest Common Ancestor.
//
// Time Complexity : O(h)
// Space Complexity : O(1)

import java.util.*;

public class BST_LCA {
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
        //         6
        //       /   \
        //      2     8
        //     / \   / \
        //    0   4 7   9
        root = new Node(6);

        root.left = new Node(2);
        root.right = new Node(8);

        root.left.left = new Node(0);
        root.left.right = new Node(4);

        root.right.left = new Node(7);
        root.right.right = new Node(9);
    }
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    // 1st Method: Recursive Solution
    //Time Complexity: O(h)
    //Space Complexity: O(h)
//    Node lowestCommonAncestor(Node root, Node p, Node q) {
//        if(root==null)
//            return null;
//        int curr=root.data;
//        if(curr<p.data && curr<q.data)
//            return lowestCommonAncestor(root.right,p,q);
//        else if(curr>p.data && curr>q.data)
//            return lowestCommonAncestor(root.left,p,q);
//        else
//            return root;
//    }

    // 2nd Method: Iterative Solution
    // Time Complexity: O(h)
    // Space Complexity: O(1)
    Node lowestCommonAncestor(Node root, Node p, Node q) {
        while(root!=null){
            if(root.data>p.data && root.data>q.data)
                root=root.left;
            else if(root.data<p.data && root.data<q.data)
                root=root.right;
            else
                return root;
        }
        return null;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_LCA tree = new BST_LCA();
        tree.createTree();
        Node node=tree.lowestCommonAncestor(tree.root, tree.root.left, tree.root.right);
        System.out.print("Lowest Common Ancestor: "+node.data);
    }
}
