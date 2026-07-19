package Trees.Binary_Search_Tree;
// Method: Divide and Conquer
//
// Idea:
// Since the array is already sorted,
// choose the middle element as the root.
//
// Left half forms the left subtree.
//
// Right half forms the right subtree.
//
// Repeating this recursively creates
// a height-balanced BST.
//
// Time Complexity : O(n)
// Space Complexity : O(log n)

import java.util.*;

public class BST_Sorted_Array_to_BST {
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
    Node build(int arr[],int left,int right){
        if(left>right)
            return null;
        int m=left+(right-left)/2;
        Node root=new Node(arr[m]);
        root.left=build(arr,left,m-1);
        root.right=build(arr,m+1,right);
        return root;
    }
    public Node sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Sorted_Array_to_BST tree = new BST_Sorted_Array_to_BST();
        int arr[]={-10,-3,0,5,9};
        tree.root=tree.sortedArrayToBST(arr);
        tree.display(tree.root);
    }
}
