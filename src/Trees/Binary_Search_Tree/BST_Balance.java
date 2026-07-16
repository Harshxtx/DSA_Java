package Trees.Binary_Search_Tree;

import java.util.*;

public class BST_Balance {
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
        //     1
        //      \
        //       2
        //        \
        //         3
        //          \
        //           4
        root = new Node(1);

        root.right = new Node(2);

        root.right.right = new Node(3);

        root.right.right.right = new Node(4);
    }
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    void inOrder(Node root, List<Node> lt){
        if(root==null)
            return;
        inOrder(root.left,lt);
        lt.add(root);
        inOrder(root.right,lt);
    }
    Node help(List<Node> lt,int st,int end){
        if(st>end)
            return null;
        int mid=st+(end-st)/2;
        Node root=lt.get(mid);
        root.left=help(lt,st,mid-1);
        root.right=help(lt,mid+1,end);
        return root;
    }
    public Node balanceBST(Node root) {
        if(root==null)
            return null;
        List<Node> lt=new ArrayList<>();
        inOrder(root,lt);
        return help(lt,0,lt.size()-1);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Balance tree = new BST_Balance();
        tree.createTree();
        System.out.print("Original Tree: ");
        tree.display(tree.root);
        tree.root=tree.balanceBST(tree.root);
        System.out.print("\nBalance Binary Search Tree: ");
        tree.display(tree.root);
    }
}
