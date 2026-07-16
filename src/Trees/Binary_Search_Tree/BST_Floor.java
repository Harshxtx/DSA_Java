package Trees.Binary_Search_Tree;

import java.util.*;

public class BST_Floor {
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
    int findMaxFork(Node root, int key) {
        int floor=-1;
        while(root!=null){
            if(root.data==key)
                return root.data;
            else if(key>root.data){
                floor=root.data;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return floor;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Floor tree = new BST_Floor();
        tree.createTree();
        int key=5;
        int ans=tree.findMaxFork(tree.root,key);
        System.out.println("Floor value: "+ans);
    }
}
