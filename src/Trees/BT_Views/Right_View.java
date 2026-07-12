package Trees.BT_Views;

import java.util.*;

public class Right_View {
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
        //     /
        //    4
        //   /
        //  5
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.left.left.left = new Node(5);
    }
    List<Integer> rightSideView(Node root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int lvlSize=q.size();
            for(int i=0;i<lvlSize;i++){
                Node curr=q.poll();
                if(i==lvlSize-1)                            //select only the rightmost element of the level
                    res.add(curr.data);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Right_View tree = new Right_View();
        tree.createTree();
        List<Integer> list=tree.rightSideView(tree.root);
        System.out.println("Right View of Binary Tree"+list);
    }
}
