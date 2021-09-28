package org.scratchpad.me.datastructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int n){
            this.value = n;
        }
    }

    static class Node {
        Character value;
        List<Node> neighbors = new ArrayList<>();
        boolean visited;
        Node(Character c){
            this.value = c;
        }
    }

    // time complexity: O(n)
    // space complexity: O(n) (heap size)
    public static void dfs_tree_recursive(TreeNode root, StringBuilder sb){
        if (root == null)
                return;
        // pre-order, in-order, post-order
        System.out.println("visiting node: " + root.value);
        sb.append(root.value).append(" ");
        dfs_tree_recursive(root.left, sb);
        dfs_tree_recursive(root.right, sb);
    }

    // this one not as common.
    public static void dfs_tree_iterative(TreeNode root, StringBuilder sb){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            System.out.println("visiting node: " + current.value);
            sb.append(current.value).append(" ");

            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void dfs_graph_recursive(Node root, StringBuilder sb){
        System.out.println("visiting node: " + root.value);
        sb.append(root.value).append(" ");
        root.visited = true;
        for(int i=0; i < root.neighbors.size();i++){
            Node anode = root.neighbors.get(i);
            if(anode != null && !anode.visited)
                dfs_graph_recursive(anode, sb);
        }

    }

    public static void dfs_graph_iterative(Node root, StringBuilder sb){
        // this algo is bfs w/ Stack instead of a Queue
        Stack<Node> mystack = new Stack<>();
        mystack.add(root);

        while(!mystack.isEmpty()){
            Node node = mystack.pop();
            if(!node.visited){
                System.out.println("visiting node: " + node.value);
                sb.append(node.value).append(" ");
                node.visited = true;
            }
            for (int i=node.neighbors.size()-1; i > -1; i--){
                Node anode = node.neighbors.get(i);
                if(!anode.visited)
                    mystack.add(anode);
            }
        }
    }
}
