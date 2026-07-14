package Trees.Problems;

import java.util.*;

public class Path_Sum_II {
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
        //  /  \       / \
        // 7    2     5   1
        root = new Node(5);

        root.left = new Node(4);
        root.right = new Node(8);

        root.left.left = new Node(11);

        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        root.right.left = new Node(13);
        root.right.right = new Node(4);

        root.right.right.left = new Node(5);
        root.right.right.right = new Node(1);
    }
    void dfs(Node root, int tar, List<Integer> ds,List<List<Integer>> ans){
        if(root==null)
            return;
        int rem=tar-root.data;
        ds.add(root.data);
        if(root.left==null && root.right==null){
            if(rem==0)
                ans.add(new ArrayList<>(ds));
        }
        else{
            dfs(root.left,rem,ds,ans);
            dfs(root.right,rem,ds,ans);
        }
        ds.remove(ds.size()-1);
    }
    public List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,targetSum,new ArrayList<>(),ans);
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Path_Sum_II tree = new Path_Sum_II();
        tree.createTree();
        int target=22;
        List<List<Integer>> ans=tree.pathSum(tree.root,target);
        System.out.println("Root to leaf Node containing the sum with target "+target+": "+ans);
    }
}
