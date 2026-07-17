package Trees.Binary_Search_Tree;


import java.util.*;

public class BST_Kth_Smallest {
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

    //Method 1: Inorder + Array
    // Time Complexity : O(n)
    // Space Complexity : O(n)
//    void help(Node root, List<Integer> lt){
//        if(root==null)
//            return;
//        help(root.left,lt);
//        lt.add(root.data);
//        help(root.right,lt);
//    }
//    public int kthSmallest(Node root, int k) {
//        List<Integer> lt=new ArrayList<>();
//        help(root,lt);
//        return lt.get(k-1);                   //lt.get(lt.size()-1-k)     //for kth largest element
//    }

    //Method 2: Inorder + Counter               //count no. of nodes(N)
    // Time Complexity : O(n)                   //then return the (N-k)th node //for kth largest element
    // Space Complexity : O(h)
//    int count=0;
//    int res=0;
//    void help(Node root,int tar){
//        if(root==null || count>=tar)
//            return;
//        help(root.left,tar);
//        count++;
//        if(count==tar){
//            res=root.data;
//            return;
//        }
//
//        help(root.right,tar);
//    }
//
//    public int kthSmallest(Node root, int k) {
//        help(root,k);
//        return res;
//    }

    //Method 3: Morris Inorder Traversal                //count no. of nodes(N)
    // Time Complexity : O(n)                           //then return the (N-k)th node //for kth largest element
    // Space Complexity : O(1)
    public int kthSmallest(Node root, int k){
        int count=0;
        int res=-1;
        Node curr=root;
        while(curr!=null){
            if(curr.left==null) {
                count++;
                if(count==k) {
                    res=curr.data;
                }
                curr=curr.right;
            }
            else{
                Node prev=curr.left;
                while(prev.right!=null && prev.right!=curr) {
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    count++;
                    if(count==k) {
                        res=curr.data;
                    }
                    curr=curr.right;
                }
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Kth_Smallest tree = new BST_Kth_Smallest();
        tree.createTree();
        int k=2;
        int sm=tree.kthSmallest(tree.root,k);
        System.out.println("Kth smallest number is: "+sm);
    }
}
