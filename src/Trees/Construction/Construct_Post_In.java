package Trees.Construction;
// Construct Binary Tree from Inorder and Postorder Traversal
//
// Pattern : Divide and Conquer + Recursion
//
// Core Idea:
// Postorder always gives the root
// as the last element.
//
// Inorder divides the tree into:
// Left Subtree | Root | Right Subtree
//
// Find the root in inorder.
//
// Number of nodes in the left subtree
// determines how the postorder array
// should be divided.
//
// Recursively build
// left and right subtrees.
//
// HashMap is used to locate the
// root index in O(1).
//
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;

public class Construct_Post_In {
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
    Node build(int postOrder[],int postSt, int postEnd, int inOrder[], int inSt, int inEnd, HashMap<Integer, Integer> mp){
        if(postSt>postEnd || inSt>inEnd)
            return null;

        Node root= new Node(postOrder[postEnd]);
        int inRoot=mp.get(root.data);
        int numsLeft=inRoot-inSt;

        root.left=build(postOrder,postSt,postSt+numsLeft-1,inOrder,inSt,inRoot-1,mp);
        root.right=build(postOrder,postSt+numsLeft,postEnd-1,inOrder,inRoot+1,inEnd,mp);

        return root;
    }
    public Node buildTree(int[] postorder, int[] inorder) {
        HashMap<Integer, Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        Node root=build(postorder, 0 ,postorder.length-1, inorder, 0, inorder.length-1, inMap);
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
        Construct_Post_In tree = new Construct_Post_In();
        int postOrder[]={40,50,20,60,30,10};
        int inOrder[]={40,20,50,10,60,30};
        tree.root=tree.buildTree(postOrder,inOrder);
        System.out.print("Level Order: ");
        tree.display(tree.root);
    }
}
