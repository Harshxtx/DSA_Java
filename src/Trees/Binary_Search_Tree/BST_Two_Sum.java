package Trees.Binary_Search_Tree;

import java.util.*;

public class BST_Two_Sum {
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
        //        5
        //       / \
        //      3   6
        //     / \   \
        //    2   4   7
        root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(6);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.right = new Node(7);
    }
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    // 1st Method:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
//    void inorder(Node root, List<Integer> lt){
//        if(root==null)
//            return;
//        inorder(root.left,lt);
//        lt.add(root.data);
//        inorder(root.right,lt);
//    }
//    boolean findTarget(Node root, int k) {
//        List<Integer> num=new ArrayList<>();
//        inorder(root,num);
//        int l=0,r=num.size()-1;
//        while(l<r)
//        {
//            if(num.get(l)+num.get(r)>k)
//                r--;
//            else if(num.get(l)+num.get(r)<k)
//                l++;
//            else
//            {
//                return true;
//            }
//        }
//        return false;
//    }

    // 2nd Method:
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    class BSTIterator{
        Stack<Node> st=new Stack<>();
        boolean reverse=true;
        public BSTIterator(Node root,boolean isReverse) {
            reverse=isReverse;
            pushAll(root);
        }
        void pushAll(Node root){
            while(root!=null){
                st.push(root);
                if(!reverse)
                    root=root.left;
                else
                    root=root.right;
            }
        }
        public int next() {
            Node node=st.pop();
            if(!reverse)
                pushAll(node.right);
            else
                pushAll(node.left);
            return node.data;
        }
        public boolean hasNext() {
            return !st.isEmpty();
        }
    }
    public boolean findTarget(Node root, int k) {
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j)
        {
            if(i+j==k)
                return true;
            else if(i+j<k)
                i=l.next();
            else
                j=r.next();
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Two_Sum tree = new BST_Two_Sum();
        tree.createTree();
        int k=9;
        String st=tree.findTarget(tree.root,k)?"":"no ";
        System.out.println("There exist "+st+"two elements which sum upto the the target "+k);
    }
}
