package Trees.Binary_Search_Tree;

import java.util.*;

public class BST_Iterator {
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
        //        7
        //       / \
        //      3   15
        //         /  \
        //        9    20
        root = new Node(7);

        root.left = new Node(3);
        root.right = new Node(15);

        root.right.left = new Node(9);
        root.right.right = new Node(20);
    }
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    BST_Iterator(){}

    // 1st Method:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
//    int i=0;
//    List<Integer> lt=new ArrayList<>();
//    void inorder(Node root){
//        if(root==null)
//            return;
//        inorder(root.left);
//        lt.add(root.data);
//        inorder(root.right);
//    }
////    BST_Iterator(Node root) {
////       inorder(root);
////   }
//
//    public int next() {
//        return lt.get(i++);
//    }
//
//    public boolean hasNext() {
//        return i<lt.size();
//    }

    // 2nd Method:
    // Time Complexity: O(1) amortized time
    // Space Complexity: O(h)
    Stack<Node> st=new Stack<>();
    void pushAll(Node root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }

    BST_Iterator(Node root) {
        pushAll(root);
    }

    public int next() {
        Node node=st.pop();
        pushAll(node.right);
        return node.data;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Iterator ob = new BST_Iterator();
        ob.createTree();
        BST_Iterator tree=new BST_Iterator(ob.root);
        System.out.print(tree.next()+" ");    // return 3
        System.out.print(tree.next()+" ");    // return 7
        System.out.print(tree.hasNext()+" "); // return True
        System.out.print(tree.next()+" ");    // return 9
        System.out.print(tree.hasNext()+" "); // return True
        System.out.print(tree.next()+" ");    // return 15
        System.out.print(tree.hasNext()+" "); // return True
        System.out.print(tree.next()+" ");    // return 20
        System.out.print(tree.hasNext()+" "); // return False

    }
}
