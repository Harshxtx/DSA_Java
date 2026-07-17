package Trees.Binary_Search_Tree;
// Construct BST from Preorder Traversal
//
// Pattern : Recursion + Upper Bound
//
// Core Idea:
// The first element in preorder
// is always the root.
//
// Maintain an index to the current
// preorder element.
//
// Use an upper bound to determine
// whether the current value belongs
// to the current subtree.
//
// Left subtree:
// values < root.data
//
// Right subtree:
// values < current bound
//
// Every node is processed exactly once.
//
// Time Complexity : O(n)
// Space Complexity : O(h)

import java.util.*;

public class BST_Construct_Preorder {
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
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    Node help(int preorder[],int bound, int t[]){
        if(t[0]==preorder.length || preorder[t[0]]> bound)
            return null;
        Node root=new Node(preorder[t[0]++]);
        root.left=help(preorder,root.data,t);
        root.right=help(preorder,bound,t);
        return root;
    }
    Node bstFromPreorder(int[] preorder) {
        return help(preorder, Integer.MAX_VALUE,new int[]{0});      // Pass an array reference new int[]{0} because Java passes primitives by value
    }                                                              //and can be helpful to track all the current index across all the recursive calls
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Construct_Preorder tree = new BST_Construct_Preorder();
        int arr[]={8,5,1,7,10,12};
        tree.root=tree.bstFromPreorder(arr);
        tree.display(tree.root);
    }
}
