package Trees.Problems;

import Trees.Binary_Tree;
import Trees.Level_Order_Tree_Traversal;

import java.util.*;

public class Invert_Binary_Tree {
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
        //         4
        //       /   \
        //      2     7
        //     / \   / \
        //    1   3 9   6
        root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(7);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(9);
        root.right.right = new Node(6);
    }
    void invert(Node root){
        if(root==null)
            return;
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;

        invert(root.left);
        invert(root.right);
    }
    void display(Node root){
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Invert_Binary_Tree tree = new Invert_Binary_Tree();
        tree.createTree();
        System.out.print("Original tree: ");        //4 2 7 1 3 9 6
        tree.display(tree.root);
        tree.invert(tree.root);
        System.out.print("\nInverted tree: ");      //4 7 2 6 9 3 1
        tree.display(tree.root);
    }
}
