package Trees.Problems;

import java.util.*;

public class Binary_Tree_tilt {
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
        //        4
        //       / \
        //      2   9
        //     / \   \
        //    3   5   7
        root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(9);

        root.left.left = new Node(3);
        root.left.right = new Node(5);

        root.right.right = new Node(7);
    }
    int tilt=0;
    int find(Node root){
        if(root==null)
            return 0;
        int l=find(root.left);
        int r=find(root.right);
        int tn=Math.abs(l-r);
        tilt+=tn;
        return l+r+root.data;
    }
    public int findTilt(Node root) {
        tilt=0;
        find(root);
        return tilt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Binary_Tree_tilt tree = new Binary_Tree_tilt();
        tree.createTree();
        int res=tree.findTilt(tree.root);
        System.out.println("The tilt is "+res);
    }
}
