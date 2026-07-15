package Trees.Problems;

import java.util.*;

public class Child_Sum_Property {
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
        //        35
        //       /  \
        //     20    15
        //     / \   / \
        //   15   5 5   10
        root = new Node(35);

        root.left = new Node(20);
        root.right = new Node(15);

        root.left.left = new Node(15);
        root.left.right = new Node(5);

        root.right.left = new Node(5);
        root.right.right = new Node(10);
    }
    // 1st Method: Recursive Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
//    boolean isSumProperty(Node root) {
//        if(root==null || (root.left==null && root.right==null))
//            return true;
//        int sum=0;
//        if(root.left!=null){
//            sum+=root.left.data;
//        }
//        if(root.right!=null){
//            sum+=root.right.data;
//        }
//        return (sum==root.data && isSumProperty(root.left) && isSumProperty(root.right));
//    }

    // 2nd Method: Level Order Traversal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    boolean isSumProperty(Node root) {
        if(root==null)
            return true;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            int sum=0;
            if(curr.left==null && curr.right==null)
                continue;
            if(curr.left!=null){
                sum+=curr.left.data;
                q.offer(curr.left);
            }
            if(curr.right!=null){
                sum+=curr.right.data;
                q.offer(curr.right);
            }
            if(curr.data!=sum)
                return false;
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Child_Sum_Property tree = new Child_Sum_Property();
        tree.createTree();
        String check=tree.isSumProperty(tree.root)?"has":"has not";
        System.out.println("The given tree "+check+" child sum property");
    }
}
