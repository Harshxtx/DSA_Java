package Trees.Problems;

import java.util.*;

public class Root_To_Leaf_Path {
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
        //      2   3
        //     / \
        //    4   5
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
    }
    void helper(Node root,ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans){
        if(root==null)
            return;
        ds.add(root.data);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(ds));
        }
        else{
            if(root.left!=null)
                helper(root.left,ds,ans);
            if(root.right!=null)
                helper(root.right,ds,ans);
        }
        ds.remove(ds.size()-1);

    }
    public List<ArrayList<Integer>> paths(Node root) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        helper(root,new ArrayList<>(),ans);
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Root_To_Leaf_Path tree = new Root_To_Leaf_Path();
        tree.createTree();
        List<ArrayList<Integer>> list=tree.paths(tree.root);
        System.out.println("The path from root to leaf are: "+list);
    }
}
