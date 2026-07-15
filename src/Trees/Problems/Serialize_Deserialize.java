package Trees.Problems;
// Serialize and Deserialize Binary Tree
//
// Pattern : Level Order Traversal (BFS)
//
// Core Idea:
// Serialize:
// Traverse the tree level by level.
// Store node values.
// Store "null" for missing children
// to preserve the exact tree structure.
//
// Deserialize:
// Read the serialized values level by level.
// Reconstruct the tree using a queue.
//
// Time Complexity : O(n)
// Space Complexity : O(n)

import java.util.*;

public class Serialize_Deserialize {
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

    // Encodes a tree to a single string.
    public String serialize(Node root){
        if(root==null)
            return "";
        StringBuilder st=new StringBuilder();
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr!=null){
                st.append(curr.data).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
            else {
                st.append("null,");
            }
        }
        return st.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data){
        if(data.isEmpty())
            return null;
        String st[]=data.split(",");
        Node node=new Node(Integer.parseInt(st[0]));
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        int i;
        for(i=1;i<st.length;){
            Node curr=q.poll();
            if(!st[i].equals("null")){
                Node left=new Node(Integer.parseInt(st[i]));
                curr.left=left;
                q.add(left);
            }
            i++;
            if(i<st.length && !st[i].equals("null")){
                Node right=new Node(Integer.parseInt(st[i]));
                curr.right=right;
                q.add(right);
            }
            i++;
        }
        return node;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Serialize_Deserialize ser = new Serialize_Deserialize();
        Serialize_Deserialize deser = new Serialize_Deserialize();
        ser.createTree();
        String data=ser.serialize(ser.root);
        System.out.println("Serialized data is: "+data);
        Node rootNode = deser.deserialize(ser.serialize(ser.root));
        String ver=deser.serialize(rootNode);
        if(ver.equals(data))
            System.out.println("Serialized data is correct");
        else
            System.out.println("Serialized data is not correct");
    }
}
