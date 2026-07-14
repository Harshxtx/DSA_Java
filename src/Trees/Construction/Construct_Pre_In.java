package Trees.Construction;
// Construct Binary Tree from Preorder and Inorder Traversal
//
// Pattern : Divide and Conquer + Recursion
//
// Core Idea:
// First node in preorder is always the root.
//
// Inorder divides the tree into:
// Left Subtree | Root | Right Subtree
//
// Find the root in inorder.
//
// Number of nodes on the left side determines
// how the preorder array should be divided.
//
// Recursively construct left and right subtrees.
//
// HashMap is used to find the root index in O(1).
//
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;

public class Construct_Pre_In {
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
    Node build(int preOrder[],int preSt, int preEnd, int inOrder[], int inSt, int inEnd, HashMap<Integer, Integer> mp){
        if(preSt>preEnd || inSt>inEnd)
            return null;

        Node root= new Node(preOrder[preSt]);
        int inRoot=mp.get(root.data);
        int numsLeft=inRoot-inSt;

        root.left=build(preOrder,preSt+1,preSt+numsLeft,inOrder,inSt,inRoot-1,mp);
        root.right=build(preOrder,preSt+numsLeft+1,preEnd,inOrder,inRoot+1,inEnd,mp);

        return root;
    }
    public Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        Node root=build(preorder, 0 ,preorder.length-1, inorder, 0, inorder.length-1, inMap);
        return root;
    }
    void display(Node root){
        if(root==null)
            return;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Construct_Pre_In tree = new Construct_Pre_In();
        int preOrder[]={10,20,40,50,30,60};
        int inOrder[]={40,20,50,10,60,30};
        tree.root=tree.buildTree(preOrder,inOrder);
        System.out.print("Level Order: ");
        tree.display(tree.root);
    }
}
