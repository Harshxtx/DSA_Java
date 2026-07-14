package Trees.BT_Views;
// Diagonal Traversal of Binary Tree
//
// Pattern : BFS + Queue
//
// Core Idea:
// Right child remains on the same diagonal.
// Left child starts the next diagonal.
//
// Traverse along the right pointers.
//
// Whenever a left child is found,
// store it in a queue.
//
// After completing one diagonal,
// process the stored left children.
//
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;

public class Diagonal_Traversal {
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
        //     / \     \
        //    4   5     6
        //       / \    /
        //      7   8  9
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        root.right.right.left = new Node(9);
    }
    List<Integer> diagonal(Node root){
        List<Integer> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            while(curr!=null){
                ans.add(curr.data);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                curr=curr.right;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Diagonal_Traversal tree = new Diagonal_Traversal();
        tree.createTree();
        List<Integer> ans=tree.diagonal(tree.root);
        System.out.print("Diagonal traversal of Binary Tree: "+ans);
    }
}
