package Trees.Problems;

import java.util.*;

public class Path_Sum {
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
        //         5
        //       /   \
        //      4     8
        //     /     / \
        //   11     13  4
        //  /  \
        // 7    2
        root = new Node(5);

        root.left = new Node(4);
        root.right = new Node(8);

        root.left.left = new Node(11);

        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        root.right.left = new Node(13);
        root.right.right = new Node(4);
    }
    boolean hasPathSum(Node root, int target) {
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return root.data==target;
        int rem=target-root.data;
        return hasPathSum(root.left,rem) || hasPathSum(root.right,rem);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Path_Sum tree = new Path_Sum();
        tree.createTree();
        int target=22;
        boolean containsum=tree.hasPathSum(tree.root, target);
        System.out.println("Contains Sum: "+(containsum?"Yes":"No"));
    }
}
