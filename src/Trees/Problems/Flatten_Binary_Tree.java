package Trees.Problems;

import java.util.*;

public class Flatten_Binary_Tree {
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
        //        1
        //       / \
        //      2   5
        //     / \   \
        //    3   4   6
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.right = new Node(6);
    }
    // 1st Method: Recursive Preorder Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
//    void preOrder(Node root,Queue<Node> q) {
//        if(root==null)
//            return;
//        q.offer(root);
//        preOrder(root.left,q);
//        preOrder(root.right,q);
//    }
//    public void flatten(Node root) {
//        if(root==null)
//            return;
//        Queue<Node> q=new LinkedList<>();
//        preOrder(root,q);
//        q.poll();
//        Node curr=root;
//        while(!q.isEmpty()){
//            Node nextNode=q.poll();
//            nextNode.left=null;
//            curr.left=null;
//            curr.right=nextNode;
//            curr=curr.right;
//        }
//        curr.left=null;
//        curr.right=null;
//    }

    // 2nd Method:Stack Solution
    // Time Complexity: O(n)
    // Space Complexity: O(n)
//    public void flatten(Node root){
//        Stack<Node> stack=new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            Node curr=stack.pop();
//            if(curr.right!=null){
//                stack.push(curr.right);
//            }
//            if(curr.left!=null){
//                stack.push(curr.left);
//            }
//            if(!stack.isEmpty()){
//                curr.right=stack.peek();
//                curr.left=null;
//            }
//        }
//    }
    // 3rd Method: Morris PreOrder Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
//    public void flatten(Node root){
//        Node curr=root;
//        while(curr!=null){
//            if(curr.left!=null){
//                Node prev=curr.left;
//                while(prev.right!=null){
//                    prev=prev.right;
//                }
//                prev.right=curr.right;
//                curr.right=curr.left;
//                curr.left=null;
//            }
//            curr=curr.right;
//        }
//    }

    // 4th Method: Recursive Solution
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    Node nextRight=null;
    public void flatten(Node root){
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left=null;
        root.right=nextRight;
        nextRight=root;
    }
    void displayTree(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr!=null){
                    System.out.print(curr.data+" ");
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
                else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }
    void displayList(Node root){
        if(root==null){
            return;
        }
        Node curr=root;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.right;
        }
        System.out.print("null");
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Flatten_Binary_Tree tree = new Flatten_Binary_Tree();
        tree.createTree();
        System.out.println("Original Tree: ");
        tree.displayTree(tree.root);
        tree.flatten(tree.root);
        System.out.print("Flattened Tree: ");
        tree.displayList(tree.root);
    }
}
