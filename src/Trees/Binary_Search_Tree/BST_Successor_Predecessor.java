package Trees.Binary_Search_Tree;

import java.util.*;

public class BST_Successor_Predecessor {
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
    List<Integer> findPreSuc(Node root, int key) {
        List<Integer> ans=new ArrayList<>();
        Node predecessor=null;
        Node successor=null;
        Node curr=root;

        while(curr!=null){
            if(curr.data>=key){
                curr=curr.left;
            }
            else{
                predecessor=curr;
                curr=curr.right;
            }
        }
        curr=root;
        while(curr!=null){
            if(curr.data>key){
                successor=curr;
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }

        ans.add(predecessor.data);
        ans.add(successor.data);
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Successor_Predecessor tree = new BST_Successor_Predecessor();
        tree.createTree();
        int key=8;
        List<Integer> list=tree.findPreSuc(tree.root,key);
        System.out.print("Predecessor and Successor of value "+key+" is: "+list);
    }
}
