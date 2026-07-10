package Trees.Problems;

import java.util.*;

public class Sum_of_Nodes {
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
    int sumNodes(Node root) {
        if(root==null)
            return 0;
        return root.data+sumNodes(root.left)+sumNodes(root.right);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sum_of_Nodes tree = new Sum_of_Nodes();
        tree.createTree();
        int sum=tree.sumNodes(tree.root);
        System.out.println("The sum of all nodes is "+sum);
    }
}
