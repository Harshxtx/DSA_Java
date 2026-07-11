package Trees.Problems;

import java.util.*;

public class Search_In_Tree {
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
        //        18
        //       / \
        //      22  13
        //     / \   \
        //    14  25  16
        //   / \
        //  9   15
        root = new Node(18);

        root.left = new Node(22);
        root.right = new Node(13);

        root.left.left = new Node(14);
        root.left.right = new Node(25);

        root.right.right = new Node(16);

        root.left.left.left = new Node(9);
        root.left.left.right = new Node(15);
    }
    boolean searchNode(Node root,int target) {
        if(root==null)
            return false;
        if(root.data==target)
            return true;
        return searchNode(root.left,target) || searchNode(root.right,target);

    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Search_In_Tree tree = new Search_In_Tree();
        int target=25;
        tree.createTree();
        String st=tree.searchNode(tree.root,target)?"present":"not present";
        System.out.println("The target "+target+" is "+st);
    }
}
