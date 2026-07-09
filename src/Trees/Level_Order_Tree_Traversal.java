package Trees;
// Level Order Traversal (Breadth First Search)
//
// Core Idea:
// 1. Insert root into Queue.
// 2. Remove front node.
// 3. Visit current node.
// 4. Insert left child.
// 5. Insert right child.
// 6. Repeat until Queue becomes empty.
//
// Time Complexity : O(n)
// Space Complexity : O(n)
import java.util.*;

public class Level_Order_Tree_Traversal {
    private Node root;
    private int size;

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
    //display Tree(Preorder)
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
        Level_Order_Tree_Traversal tree = new Level_Order_Tree_Traversal();
        tree.createTree();
        System.out.print("Level Order Traversal: ");
        tree.display(tree.root);
    }
}
