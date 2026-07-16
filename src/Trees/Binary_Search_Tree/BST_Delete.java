package Trees.Binary_Search_Tree;
// Delete Node in a BST
//
// Pattern : BST Recursion
//
// Cases:
// 1. Leaf node
// 2. One child
// 3. Two children
//
// For two children,
// replace with inorder predecessor
// (maximum in left subtree)
// and delete that node.
//
// Time Complexity : O(h)
// Space Complexity : O(h)

import java.util.*;

public class BST_Delete {
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
        //           50
        //         /     \
        //        /       \
        //       25        75
        //      /  \      /  \
        //    12    37   62   89
        //   /  \   / \
        //  10  20 30  40

        root = new Node(50);

        root.left = new Node(25);
        root.right = new Node(75);

        root.left.left = new Node(12);
        root.left.right = new Node(37);

        root.right.left = new Node(62);
        root.right.right = new Node(89);

        root.left.left.left = new Node(10);
        root.left.left.right = new Node(20);

        root.left.right.left = new Node(30);
        root.left.right.right = new Node(40);
    }
    Node findmax(Node root){
        if(root.right==null)
            return root;
        return findmax(root.right);
    }
    public Node deleteNode(Node root, int key) {
        if(root==null)
            return null;
        if(root.data==key){                             // key found
            if(root.left==null && root.right==null)     // No child
                return null;

            else if(root.left==null)                    // one child(right)
                return root.right;

            else if(root.right==null)                   // No child(left)
                return root.left;

            else{                                       // both child
                Node leftmax=findmax(root.left);
                root.data=leftmax.data;
                root.left=deleteNode(root.left,leftmax.data);
            }
            return root;
        }
        if(root.data>key)
            root.left=deleteNode(root.left,key);
        else{
            root.right=deleteNode(root.right,key);
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
        BST_Delete tree = new BST_Delete();
        tree.createTree();
        int key=25;
        System.out.print("Original Tree: ");
        tree.display(tree.root);
        tree.root=tree.deleteNode(tree.root,key);
        System.out.print("\nTree after deletion: ");
        tree.display(tree.root);
    }
}
