package Trees.Problems;

import java.util.*;

public class Sum_Root_To_Leaf {
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
        //      9   0
        //     / \
        //    5   1
        root = new Node(4);

        root.left = new Node(9);
        root.right = new Node(0);

        root.left.left = new Node(5);
        root.left.right = new Node(1);
    }
    int helper(Node root,int sum){
        if(root==null){
            return 0;
        }
        sum=sum*10+root.data;
        if(root.left==null && root.right==null){
            return sum;
        }
        return helper(root.left,sum)+helper(root.right,sum);
    }
    public int sumNumbers(Node root) {
        return helper(root,0);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sum_Root_To_Leaf tree = new Sum_Root_To_Leaf();
        tree.createTree();
        int sum= tree.sumNumbers(tree.root);
        System.out.println("Sum of all root to leaf nodes are: "+sum);
    }
}
