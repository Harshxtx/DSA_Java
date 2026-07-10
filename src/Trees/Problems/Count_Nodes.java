package Trees.Problems;

import java.util.*;

public class Count_Nodes {
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

        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
    }
    int countNodes(Node root) {
        if(root==null)
            return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Count_Nodes tree = new Count_Nodes();
        tree.createTree();
        int count=tree.countNodes(tree.root);
        System.out.println("The number of nodes in the tree is: "+count);
    }
}
