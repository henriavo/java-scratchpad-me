package org.scratchpad.me.datastructure.binarytree;

public class IsBalanced_On {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int n){
            this.value = n;
        }
    }

    public static Boolean isBalanced(TreeNode root){
        if(checkHeight(root) == -1) {
            System.out.println("not balanced!");
            return false;
        }
        else{
            System.out.println("yes balanced!");
            return true;
        }
    }

    //O(n) solution
    private static int checkHeight(TreeNode root){
        // base case
        if(root == null)
            return 0;

        // check if left is balanced
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1){
            return -1; //not balanced
        }

        // chec if right is balanced
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1)
            return -1; //not balanced

        // check if current node is balanced
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1){
            System.out.println("height diff is: " + heightDiff);
            return -1; // not balanced
        }
        else { // return height
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
