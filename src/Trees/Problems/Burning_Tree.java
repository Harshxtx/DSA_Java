package Trees.Problems;
// Burning Tree (Minimum Time to Burn a Tree)
//
// Pattern : BFS + Parent Mapping + Graph Traversal
//
// Core Idea:
// Store the parent of every node to convert
// the tree into an undirected graph,
// allowing upward traversal as well.
//
// Find the target node.
//
// Perform BFS starting from the target node.
//
// At each second, fire spreads to:
// 1. Left child
// 2. Right child
// 3. Parent
//
// BFS proceeds level by level.
// Each level represents one second.
// The total number of levels required
// to burn all nodes is the answer.
//
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;

public class Burning_Tree {
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
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        //   /
        //  8
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
    }
    Node findtarget(Node root,int tar){
        if(root==null)
            return null;
        if(root.data==tar)
            return root;
        Node left=findtarget(root.left,tar);
        if (left!=null) {
            return left;
        }
        return findtarget(root.right,tar);

    }
    void markParents(Node root, Map<Node, Node> pt){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.left!=null ){
                pt.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null ){
                pt.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    int minTime(Node target, Map<Node, Node> parenMap){
        Queue<Node> q=new LinkedList<>();
        Map<Node,Boolean> vis=new HashMap<>();
        q.offer(target);
        vis.put(target,true);
        int currlvl=0;
        while(!q.isEmpty()){
            int len=q.size();
            boolean spread=false;
            for(int i=0;i<len;i++){
                Node curr=q.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                    spread=true;
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && vis.get(curr.right)==null){
                    spread=true;
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
                if(parenMap.get(curr)!=null && vis.get(parenMap.get(curr))==null){
                    spread=true;
                    q.offer(parenMap.get(curr));
                    vis.put(parenMap.get(curr),true);
                }
            }
            if(spread)
                currlvl++;
        }
        return currlvl;
    }
    public int burnTree(Node root, int tar) {
        // code here
        Node target=findtarget(root,tar);
        Map<Node, Node> parentMap=new HashMap<>();
        markParents(root,parentMap);
        int burnTime=minTime(target,parentMap);
        return burnTime;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Burning_Tree tree = new Burning_Tree();
        tree.createTree();
        int min=tree.burnTree(tree.root,3);
        System.out.println("Minimum time to burn the tree is: "+min);
    }
}
