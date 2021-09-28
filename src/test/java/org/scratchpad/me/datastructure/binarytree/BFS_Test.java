package org.scratchpad.me.datastructure.binarytree;


import org.junit.BeforeClass;
import org.junit.Test;
import org.scratchpad.me.datastructure.binarytree.BFS.TreeNode;
import org.scratchpad.me.datastructure.binarytree.BFS.Node;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BFS_Test {
    static TreeNode one;
    static Node s;

    @BeforeClass
    public static void setUp(){
        // binary tree
        one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        // graph
        s = new Node('s');
        Node a = new Node('a');
        Node d = new Node('d');
        s.neighbors.addAll(Arrays.asList(d,a));
        Node e = new Node('e');
        Node g = new Node('g');
        d.neighbors.add(g);
        a.neighbors.add(e);
        Node b = new Node('b');
        Node h = new Node('h');
        g.neighbors.addAll(Arrays.asList(d, e, h));
        e.neighbors.addAll(Arrays.asList(a,g,h,b));
        Node c = new Node('c');
        Node f = new Node('f');
        h.neighbors.addAll(Arrays.asList(g,e));
        b.neighbors.addAll(Arrays.asList(e,c,f));
        c.neighbors.addAll(Arrays.asList(b,f));
        f.neighbors.addAll(Arrays.asList(b,c));
    }

    @Test
    public void bfs_tree_test(){
        StringBuilder sb = new StringBuilder();
        BFS.bfs_tree_iterative(one, sb);
        assertEquals(sb.toString(), "1 2 3 4 5 6 7 ");

    }

    @Test
    public void bfs_graph_iterative(){
        StringBuilder sb = new StringBuilder();
        BFS.bfs_graph_iterative(s, sb);
        assertEquals(sb.toString(), "s d a g e h b c f ");
        System.out.println(sb.toString());
    }
}
