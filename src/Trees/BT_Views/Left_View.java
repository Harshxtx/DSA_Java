package Trees.BT_Views;
// Left View of Binary Tree
//
// Pattern : BFS (Level Order)
//
// Core Idea:
// Perform level order traversal.
//
// At every level,
// the first node visited is the
// leftmost visible node.
//
// Add the first node of every level
// to the answer.
//
// Time Complexity : O(n)
// Space Complexity : O(n)
import java.util.*;

public class Left_View {
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
        //         /
        //        4
        //         \
        //          5
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.left.right = new Node(5);
    }
    List<Integer> leftView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int lvlSize = q.size();
            for (int i = 0; i < lvlSize; i++) {
                Node curr = q.poll();
                if (i == 0)                     //select only the leftmost element of the level
                    res.add(curr.data);

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Left_View tree = new Left_View();
        tree.createTree();
        List<Integer> list=tree.leftView(tree.root);
        System.out.print("Left View of Binary Tree: "+list);
    }
}
