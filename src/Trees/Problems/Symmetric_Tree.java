package Trees.Problems;

import java.util.*;

public class Symmetric_Tree {
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
        //         1
        //       /   \
        //      2     2
        //     / \   / \
        //    4   5 5   4
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(5);
        root.right.right = new Node(4);
    }
    boolean helper(Node p,Node q){
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.data!=q.data)
            return false;
        return helper(p.left,q.right) && helper(p.right,q.left);
    }
    public boolean isSymmetric(Node root) {
        if(root==null)
            return true;
        return helper(root.left,root.right);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Symmetric_Tree tree = new Symmetric_Tree();
        tree.createTree();
        String str=tree.isSymmetric(tree.root)?"":" not";
        System.out.println("The tree is"+str+" symmetric");
    }
}
