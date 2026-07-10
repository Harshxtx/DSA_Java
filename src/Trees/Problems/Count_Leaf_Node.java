package Trees.Problems;

import java.util.*;

public class Count_Leaf_Node {
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
        //   /
        //  7
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.left.left = new Node(7);
    }
    int countLeafNode(Node root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return countLeafNode(root.left)+countLeafNode(root.right);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Count_Leaf_Node tree = new Count_Leaf_Node();
        tree.createTree();
        int count=tree.countLeafNode(tree.root);
        System.out.println("The number of leaf nodes in the tree is: "+count);
    }
}
