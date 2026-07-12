package Trees.Problems;

// All Nodes Distance K in Binary Tree
//
// Core Idea:
// A tree allows only downward traversal.
// Store the parent of every node,
// convert the tree into an undirected graph, allowing upward traversal.
//
// Then perform BFS from the target node.
//
// At every step, visit:
// 1. Left child
// 2. Right child
// 3. Parent
//
// Stop after k levels.
//
// Remaining nodes in the queue
// are exactly k distance away.
//
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;

public class Node_K_Distance {
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
        //          3
        //        /   \
        //       /     \
        //      5       1
        //     / \     / \
        //    6   2   0   8
        //       / \
        //      7   4
        root = new Node(3);

        root.left = new Node(5);
        root.right = new Node(1);

        root.left.left = new Node(6);
        root.left.right = new Node(2);

        root.right.left = new Node(0);
        root.right.right = new Node(8);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
    }
    void markParents(Node root,Map<Node, Node> pt){
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
    public List<Integer> distanceK(Node root, Node target, int k) {
        List<Integer> ans=new ArrayList<>();
        Map<Node, Node> parentMap=new HashMap<>();     //sotes the parent of each Node
        markParents(root,parentMap);                   //mark the parent of each Node
        Queue<Node> q=new LinkedList<>();
        Map<Node,Boolean> vis=new HashMap<>();      //visited map to mark the visited elements
        q.offer(target);
        vis.put(target,true);
        int currlvl=0;                              //count distance
        while(!q.isEmpty()){
            int len=q.size();
            if(currlvl==k)
                break;
            currlvl++;
            for(int i=0;i<len;i++){
                Node curr=q.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && vis.get(curr.right)==null){
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
                if(parentMap.get(curr)!=null && vis.get(parentMap.get(curr))==null){
                    q.offer(parentMap.get(curr));
                    vis.put(parentMap.get(curr),true);
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll().data);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Node_K_Distance tree = new Node_K_Distance();
        tree.createTree();
        int k=2;
        List<Integer> ans=tree.distanceK(tree.root, tree.root.left, k);
        System.out.println("Node at a distance "+k+" are: "+ans);
    }
}
