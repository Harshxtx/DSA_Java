package Trees.Binary_Search_Tree;

import java.util.*;

public class BST_Recover {
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
        //        8
        //       / \
        //     10   3
        //     / \   \
        //    1   6   17
        root = new Node(8);

        root.left = new Node(10);
        root.right = new Node(3);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.right.right = new Node(17);
    }
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }

    // 1st Method:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
//    int i=0;
//    List<Integer> lt= new ArrayList<>();
//    void inorder(Node root){
//        if(root==null)
//            return;
//        inorder(root.left);
//        lt.add(root.data);
//        inorder(root.right);
//    }
//    void correct(Node root){
//        if(root==null)
//            return;
//        correct(root.left);
//        if(root.data!=lt.get(i++)){
//            root.data=lt.get(i-1);
//        }
//        correct(root.right);
//    }
//    void recoverTree(Node root) {
//        inorder(root);
//        Collections.sort(lt);
//        correct(root);
//    }

    // 2nd Method:
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    Node prev=null;
    Node first=null;
    Node sec=null;
    void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        if(prev!=null && prev.data>root.data){
            if(first==null)
                first=prev;
            sec=root;
        }
        prev=root;
        inorder(root.right);
    }
    void recoverTree(Node root) {
        inorder(root);
        if(first!=null && sec!=null) {
            int temp = first.data;
            first.data = sec.data;
            sec.data = temp;
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Recover tree = new BST_Recover();
        tree.createTree();
        System.out.print("Original Tree: ");
        tree.display(tree.root);
        tree.recoverTree(tree.root);
        System.out.print("\nTree after recovering: ");
        tree.display(tree.root);
    }
}
