package Trees.Problems;
// Maximum Width of Binary Tree
//
// Core Idea:
// Treat the tree like a Complete Binary Tree.
//
// Assign indices:
// Root = 0
// Left Child = 2*i + 1
// Right Child = 2*i + 2
//
// Width of each level =lastIndex - firstIndex + 1
//
// Normalize indices at every level
// to prevent integer overflow.
//
// Time Complexity : O(n)
// Space Complexity : O(n)
import java.util.*;

public class Width_Tree {
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
        //     /     \
        //    4       6
        //   /       /
        //  7       9
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.right.right = new Node(6);

        root.left.left.left = new Node(7);
        root.right.right.left = new Node(9);
    }
    class Pair{
        Node node;
        int num;
        Pair(Node node, int num){
            this.node=node;
            this.num=num;
        }
    }
    public int widthOfBinaryTree(Node root) {
        if(root==null)
            return 0;
        int maxWidth=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int lvlsize=q.size();
            int minIdx=q.peek().num;              //to handle the Integer Overflow for large levels
            int first=0,last=0;
            for(int i=0;i<lvlsize;i++){
                int currIdx=q.peek().num-minIdx;
                Node node=q.peek().node;
                q.poll();
                if(i==0)
                    first=currIdx;
                if(i==lvlsize-1)
                    last=currIdx;
                if(node.left!=null)
                    q.offer(new Pair(node.left,currIdx*2+1));
                if(node.right!=null)
                    q.offer(new Pair(node.right,currIdx*2+2));
            }
            maxWidth=Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Width_Tree tree = new Width_Tree();
        tree.createTree();
        int width=tree.widthOfBinaryTree(tree.root);
        System.out.println("The maximum width of the tree is: "+width);
    }
}
