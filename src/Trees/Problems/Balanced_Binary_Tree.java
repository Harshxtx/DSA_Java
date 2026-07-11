package Trees.Problems;
// Balanced Binary Tree
//
// Core Idea:
// DFS returns height of current node.
//
// If any subtree is unbalanced,
// return -1 immediately.
//
// Otherwise,
// return current height.
//
// A tree is balanced if
// |leftHeight - rightHeight| <= 1
// for every node.
//
// Time Complexity : O(n)
// Space Complexity : O(h)
// where h = height of the tree
import java.util.*;

public class Balanced_Binary_Tree {
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
    int height(Node root){
        if(root==null)
            return 0;
        int l=height(root.left);
        int r=height(root.right);
        if(l==-1 || r==-1 || Math.abs(l-r)>1)
            return -1;
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(Node root) {
        return height(root)==-1?false:true;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Balanced_Binary_Tree tree = new Balanced_Binary_Tree();
        tree.createTree();
        String bal= tree.isBalanced(tree.root)?"is a":"is not a ";
        System.out.print("The given tree "+bal+" Balanced Binary Tree");
    }
}
