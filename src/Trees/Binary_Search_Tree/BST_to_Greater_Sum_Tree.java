package Trees.Binary_Search_Tree;

import java.util.*;

public class BST_to_Greater_Sum_Tree {
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
    int sum=0;
    void help(Node root){
        if(root==null)
            return;
        help(root.right);
        sum+=root.data;
        root.data=sum;
        help(root.left);
    }
    public Node bstToGst(Node root) {
        help(root);
        return root;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_to_Greater_Sum_Tree tree = new BST_to_Greater_Sum_Tree();
        tree.createTree();
        System.out.print("Original Tree: ");
        tree.display(tree.root);
        tree.root=tree.bstToGst(tree.root);
        System.out.print("\nGreater Sum Tree: ");
        tree.display(tree.root);
    }
}
