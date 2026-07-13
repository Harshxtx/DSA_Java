package Trees.BT_Views;
// Vertical Order Traversal
//
// Pattern : BFS + Horizontal Distance (HD)
//
// Core Idea:
// Assign each node a horizontal distance.
//
// Root = 0
// Left Child = HD - 1
// Right Child = HD + 1
//
// Perform level order traversal.
//
// Store every node according to
// its horizontal distance.
//
// Finally, print columns from
// leftmost to rightmost.
//
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;

public class Vertical_Order {
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
        //    4   6 5   7
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(6);

        root.right.left= new Node(5);
        root.right.right = new Node(7);
    }
    class Pair{
        Node node;
        int hd;
        Pair(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Pair> q=new LinkedList<>();
        Map<Integer, List<Integer>> mp=new HashMap<>();
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int hd=curr.hd;

            min=Math.min(min,hd);
            max=Math.max(max,hd);

            Node temp=curr.node;

            mp.putIfAbsent(hd, new ArrayList<>());
            mp.get(hd).add(temp.data);

            if(temp.left!=null){
                q.offer(new Pair(temp.left,hd-1));
            }
            if(temp.right!=null){
                q.offer(new Pair(temp.right,hd+1));
            }
        }
        for(int i=min;i<=max;i++){
            if(mp.containsKey(i))
                ans.add(new ArrayList<>(mp.get(i)));
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Vertical_Order tree = new Vertical_Order();
        tree.createTree();
        List<List<Integer>> res=tree.verticalOrder(tree.root);
        System.out.println("Vertical Order of Binary Tree: "+res);
    }
}
