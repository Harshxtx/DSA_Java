package Trees.Binary_Search_Tree;

import java.util.*;

public class BST_Ceil {
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
        //      3   10
        //     / \   \
        //    1   6   17
        root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

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
    int findCeil(Node root, int key) {
        int ceil=-1;
        while(root!=null){
            if(root.data==key)
                return root.data;
            else if(key>root.data)
                root=root.right;
            else{
                ceil=root.data;
                root=root.left;
            }
        }
        return ceil;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Ceil tree = new BST_Ceil();
        tree.createTree();
        int key=5;
        int ans=tree.findCeil(tree.root,key);
        System.out.println("Ceil Value: "+ans);
    }
}
