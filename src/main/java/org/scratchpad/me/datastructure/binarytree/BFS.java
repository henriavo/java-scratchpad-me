package org.scratchpad.me.datastructure.binarytree;

import java.util.*;

// all iterative
public class BFS {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int a){
            this.value = a;
        }
    }

    static class Node {
        Character value;
        List<Node> neighbors = new ArrayList<>();
        Node(Character x){
            this.value = x;
        }

    }

    // graphs can be represented as:
    // 1. edge list
    // 2. matrix
    // 3. adjacent list

    public static void bfs_tree_iterative(TreeNode root, StringBuilder sb){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();

            if(node == null)
                continue;

            System.out.println("visiting node: " + node.value);
            sb.append(node.value).append(" ");

            if(!(node.left == null)) queue.add(node.left);
            if(!(node.right == null)) queue.add(node.right);
        }
    }

    // this isn't using a graph representation
    public static void bfs_graph_iterative(Node root, StringBuilder sb){
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node == null || visited.contains(node)){
                continue;
            }

            System.out.println("visiting node: " + node.value);
            sb.append(node.value).append(" ");
            visited.add(node);

            for(int i =0; i < node.neighbors.size(); i++){
                Node anode = node.neighbors.get(i);
                queue.add(anode);
            }

        }
    }
}
