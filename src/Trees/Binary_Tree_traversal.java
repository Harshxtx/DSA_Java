package Trees;
// Binary Tree Traversals (Depth First Search)
//
// 1. Preorder  : Root -> Left -> Right
// 2. Inorder   : Left -> Root -> Right
// 3. Postorder : Left -> Right -> Root
//
// Time Complexity : O(n)
// Space Complexity : O(h)
import java.util.*;

public class Binary_Tree_traversal {
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
    void preOrder(Node root) {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //display Tree(Inorder)
    void inOrder(Node root) {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }

    //display Tree(Postorder)
    void postOrder(Node root) {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Binary_Tree_traversal tree = new Binary_Tree_traversal();
        tree.createTree();
        System.out.print("Post Order Traversal: ");
        tree.preOrder(tree.root);
        System.out.print("\nIn Order Traversal: ");
        tree.inOrder(tree.root);
        System.out.print("\nPost Order Traversal: ");
        tree.postOrder(tree.root);
    }
}
