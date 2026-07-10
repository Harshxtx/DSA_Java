package Trees.Problems;

import java.util.*;

public class Height_Of_Tree {
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
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        //   / \
        //  7   8
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.left.left = new Node(4);
        root.left.left.right = new Node(5);
    }
    int height(Node root) {
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height((root.right)));
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Height_Of_Tree tree = new Height_Of_Tree();
        tree.createTree();
        int height=tree.height(tree.root);
        System.out.println("The maximum depth of the Binary Tree is: "+height);
    }
}
