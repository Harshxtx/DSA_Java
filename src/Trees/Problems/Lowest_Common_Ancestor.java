package Trees.Problems;

import java.util.*;

public class Lowest_Common_Ancestor {
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
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);
    }
    Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null || root==p || root==q)
            return root;
        Node left=lowestCommonAncestor(root.left,p,q);
        Node right=lowestCommonAncestor(root.right,p,q);
        if(left==null)
            return right;
        else if(right==null)
            return left;
        else
            return root;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Lowest_Common_Ancestor tree = new Lowest_Common_Ancestor();
        tree.createTree();
        Node lca=tree.lowestCommonAncestor(tree.root, tree.root.left, tree.root.right);
        System.out.print("Value of Lowest Common Ancestor : "+lca.data);
    }
}
