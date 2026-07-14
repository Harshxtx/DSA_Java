package Trees;
// Morris Preorder Traversal
//
// Pattern : Morris Traversal (Threaded Binary Tree)
//
// Core Idea:
// Perform preorder traversal
// without using recursion or stack.
//
// If the current node has no left child:
// - Visit the node.
// - Move to the right child.
//
// Otherwise:
// - Find the inorder predecessor.
// - Create a temporary thread.
// - Visit the current node.
// - Move to the left child.
//
// When the thread is encountered again:
// - Remove the thread.
// - Move to the right child.
//
// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

public class Morris_Preorder {
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
    List<Integer> preorderTraversal(Node root) {
        List<Integer> res=new ArrayList<>();
        Node curr=root;
        while(curr!=null){
            if(curr.left==null) {
                res.add(curr.data);
                curr=curr.right;
            }
            else{
                Node prev=curr.left;
                while(prev.right!=null && prev.right!=curr) {
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    res.add(curr.data);
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    curr=curr.right;
                }
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Morris_Preorder tree = new Morris_Preorder();
        tree.createTree();
        List<Integer> ans=tree.preorderTraversal(tree.root);
        System.out.println("Morris PreOrder Traversal: "+ans);
    }
}
