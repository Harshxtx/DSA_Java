package Trees.BT_Views;

import java.util.*;

public class Vertical_Order_Sort {
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
    class Tuple{
        Node node;
        int row;
        int col;
        Tuple(Node node, int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Tuple> q=new LinkedList<>();
        Map<Integer, TreeMap<Integer,PriorityQueue<Integer>>> mp=new TreeMap<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple curr=q.poll();
            Node temp=curr.node;
            int r=curr.row;
            int c=curr.col;

            mp.putIfAbsent(c, new TreeMap<>());
            mp.get(c).putIfAbsent(r, new PriorityQueue<>());
            mp.get(c).get(r).add(temp.data);

            if(temp.left!=null){
                q.offer(new Tuple(temp.left,r+1,c-1));
            }
            if(temp.right!=null){
                q.offer(new Tuple(temp.right,r+1,c+1));
            }
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> row:mp.values()){
            List<Integer> lt=new ArrayList<>();
            for(PriorityQueue<Integer> pq: row.values()){
                while(!pq.isEmpty())
                    lt.add(pq.poll());
            }
            ans.add(lt);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Vertical_Order_Sort tree = new Vertical_Order_Sort();
        tree.createTree();
        List<List<Integer>> list=tree.verticalTraversal(tree.root);
        System.out.println("Vertical Order of Binary Tree: "+list);
    }
}
