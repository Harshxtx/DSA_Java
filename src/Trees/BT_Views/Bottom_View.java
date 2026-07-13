package Trees.BT_Views;
// Bottom View of Binary Tree
//
// Pattern : BFS + Horizontal Distance (HD)
//
// Core Idea:
// Assign every node a horizontal distance.
//
// Root = 0
// Left Child = HD - 1
// Right Child = HD + 1
//
// Perform level order traversal.
//
// For every horizontal distance,
// keep replacing the node value.
//
// The last node encountered at each
// horizontal distance forms the
// bottom view.
//
// Time Complexity :
// Method 1 (TreeMap) : O(n log n)
// Method 2 (HashMap) : O(n)
//
// Space Complexity : O(n)

import java.util.*;

public class Bottom_View {
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
        //          1
        //        /   \
        //       /     \
        //      2       3
        //     / \     / \
        //    4   5   6   7
        //       / \     /
        //      8   9   10
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        root.right.right.left = new Node(10);
    }

    class Pair{
        Node node;
        int hd;
        Pair(Node head,int hd){
            this.node=head;
            this.hd=hd;
        }
    }
    // 1st Method: Using TreeMap to sort the map by keys automatically
    //Time Complexity: O(n log n)
//    List<Integer> bottomView(Node root) {
//        ArrayList<Integer> ans=new ArrayList<>();
//        if(root==null)
//            return ans;
//        Queue<Pair> q=new LinkedList<>();
//        Map<Integer, Integer> mp=new TreeMap<>();
//        q.offer(new Pair(root,0));
//        while(!q.isEmpty()){
//            Pair curr=q.poll();
//            int hd=curr.hd;
//            Node temp=curr.head;

//            mp.put(hd,temp.data);

//            if(temp.left!=null){
//                q.offer(new Pair(temp.left,hd-1));
//            }
//            if(temp.right!=null){
//                q.offer(new Pair(temp.right,hd+1));
//            }
//        }
//        for(Map.Entry<Integer, Integer> entry:mp.entrySet()){
//            ans.add(entry.getValue());
//        }
//        return ans;
//    }

    //2nd Method: Using HashMap and max,min to track the minimum and maximum horizontal distances
    //Time Complexity: O(n)
    List<Integer> bottomView(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Pair> q=new LinkedList<>();
        Map<Integer, Integer> mp=new HashMap<>();
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int hd=curr.hd;
            Node temp=curr.node;

            min=Math.min(min,hd);
            max=Math.max(max,hd);

            mp.put(hd,temp.data);

            if(temp.left!=null){
                q.offer(new Pair(temp.left,hd-1));
            }
            if(temp.right!=null){
                q.offer(new Pair(temp.right,hd+1));
            }
        }
        for(int i=min;i<=max;i++){
            if(mp.containsKey(i))
                ans.add(mp.get(i));
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Bottom_View tree = new Bottom_View();
        tree.createTree();
        List<Integer> res=tree.bottomView(tree.root);
        System.out.println("Bottom View of Binary Tree: "+res);
    }
}
