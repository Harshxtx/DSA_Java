package Trees.BT_Views;
// Boundary Traversal of Binary Tree
//
// Pattern : DFS
//
// Core Idea:
// Boundary consists of:
// 1. Root
// 2. Left Boundary (excluding leaves)
// 3. All Leaf Nodes
// 4. Right Boundary (excluding leaves) in reverse order.
//
// Traverse each part separately
// And combine the result.
//
// Time Complexity : O(n)
// Space Complexity : O(h)

import java.util.*;

public class Boundary_Traversal {
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
        //      2     3
        //     / \   / \
        //    4   5 6   7
        //       / \
        //      8   9
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
    }
    boolean isLeaf(Node node){
        return (node.left==null && node.right==null);
    }
    void addLeft(Node root,ArrayList<Integer> ans){
        Node curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr))
                ans.add(curr.data);
            if(curr.left!=null)
                curr=curr.left;
            else
                curr=curr.right;
        }
    }
    void addLeaf(Node root,ArrayList<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
        }
        if(root.left!=null)
            addLeaf(root.left,ans);
        if(root.right!=null)
            addLeaf(root.right,ans);
    }
    void addRight(Node root,ArrayList<Integer> ans){
        Node curr=root.right;
        LinkedList<Integer> lt=new LinkedList<>();
        while(curr!=null){
            if(!isLeaf(curr))
                lt.addFirst(curr.data);
            if(curr.right!=null)
                curr=curr.right;
            else
                curr=curr.left;
        }
        for(Integer num : lt){
            ans.add(num);
        }
    }
    List<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;

        if(!isLeaf(root))
            ans.add(root.data);

        addLeft(root,ans);
        addLeaf(root,ans);
        addRight(root,ans);

        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Boundary_Traversal tree = new Boundary_Traversal();
        tree.createTree();
        List<Integer> ans=tree.boundaryTraversal(tree.root);
        System.out.println("Boundary traversal of Binary Tree is: "+ans);
    }
}
