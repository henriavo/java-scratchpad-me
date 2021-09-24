package org.scratchpad.me.datastructure.binarytree;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.scratchpad.me.datastructure.binarytree.IsBalanced_On.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IsBalanced_On_Test {

    @Before
    public void setUp(){
        System.out.println("setUp()");
    }

    @Test
    public void testIsBalanced() {
    //        1
    //      /  \
    //      2    3
    //     / \  / \
    //    4  5 6   7
    TreeNode one = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    one.left = two;
    one.right = three;

    assertTrue(IsBalanced_On.isBalanced(one));

    }

    @Test
    public void testIsBalanced2() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        three.left = new TreeNode(4);
        three.left.left = new TreeNode(5);

        assertTrue(IsBalanced_On.isBalanced(one));
    }

    @After
    public void tearDown(){
        System.out.println("tearDown()");
    }
}
