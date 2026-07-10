package Trees.Problems;

import java.util.*;

public class Max_Node {
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
        //      2   4
        //     / \   \
        //    8   5   7
        //   / \
        //  6   3
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(4);

        root.left.left = new Node(8);
        root.left.right = new Node(5);

        root.right.right = new Node(7);

        root.left.left.left = new Node(6);
        root.left.left.right = new Node(3);
    }
    int maxNode(Node root) {
        if(root==null)
            return 0;
        return Math.max(root.data,Math.max(maxNode(root.left),maxNode(root.right)));
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Max_Node tree = new Max_Node();
        tree.createTree();
        int max=tree.maxNode(tree.root);
        System.out.println("The maximum node is: "+max);
    }
}
