package Trees;

import java.util.*;

public class Binary_Tree {
    private Node root;
    private int size;

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
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);
    }
    //display Tree(Preorder)
    void display(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        display(root.left);
        display(root.right);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Binary_Tree tree = new Binary_Tree();
        tree.createTree();
        tree.display(tree.root);
    }
}
