package org.scratchpad.me.datastructure;

public class BalancedBinaryTreeTwo {

    public static void main(String[] args){
        BalancedBinaryTree.TreeNode input = new BalancedBinaryTree.TreeNode(5);
        if(checkHeight(input) == -1)
            System.out.println("Not balanced");
        else
            System.out.println("Balanced!");
    }

    //O(n) solution
    public static int checkHeight(BalancedBinaryTree.TreeNode root){
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
            return -1; // not balanced
        }
        else { // return height
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
