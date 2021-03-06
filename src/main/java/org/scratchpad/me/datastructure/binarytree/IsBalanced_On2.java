package org.scratchpad.me.datastructure.binarytree;


public class IsBalanced_On2 {

    // O(n^2) solution
    // NOTE: it's a recursive method calling on a recursive method.
    // hence On^2
    public static boolean isBalanced(TreeNode root) {
        //base case
        if (root==null) return true;

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        // definition of balanced is:
        //  height of each subtree differs by no more than 1.
        if(Math.abs(heightDiff) > 1){
            return false;
        }
        else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    // recursive method to find tree height
    // CLASSIC ALGORITHM
    private static int getHeight(TreeNode root){
        //base case
        if(root == null)
            return 0;
        return Math.max(getHeight(root.left) , getHeight(root.right)) +1;
    }
    static class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int n){
            this.value = n;
        }
    }
}
