package Trees.Problems;

import java.util.*;

public class Identical_Tree {
    private Node root1;
    private Node root2;

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
    void createTree1(){
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        root1 = new Node(1);

        root1.left = new Node(2);
        root1.right = new Node(3);

        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        root1.right.right = new Node(6);
    }
    void createTree2(){
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        root2 = new Node(1);

        root2.left = new Node(2);
        root2.right = new Node(3);

        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        root2.right.right = new Node(6);
    }
    boolean isSameTree(Node p, Node q) {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.data!=q.data)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Identical_Tree tree = new Identical_Tree();
        tree.createTree1();
        tree.createTree2();
        String st=tree.isSameTree(tree.root1,tree.root2)?"":" not";
        System.out.println("The given trees are"+st+" identical");
    }
}
