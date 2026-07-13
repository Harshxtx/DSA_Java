package Trees;

import java.util.*;

public class Zig_Zag_Traversal {
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
        //     / \   \
        //    4   5   6
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);
    }
    List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        boolean lr=true;
        while(!q.isEmpty()){
            List<Integer> lt=new LinkedList<>();
            int l=q.size();
            for(int i=0;i<l;i++){
                Node curr=q.poll();
                if(lr)
                    lt.addLast(curr.data);
                else
                    lt.addFirst(curr.data);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            res.add(lt);
            lr=!lr;
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Zig_Zag_Traversal tree = new Zig_Zag_Traversal();
        tree.createTree();
        List<List<Integer>> list=tree.zigzagLevelOrder(tree.root);
        System.out.println("Zig Zag Traversal: "+list);
    }
}
