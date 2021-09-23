package org.scratchpad.me.datastructure.binarytree;

public class IsBalanced_On {

    public static void main(String[] args){
        IsBalanced_On2.TreeNode input = new IsBalanced_On2.TreeNode(5);
        if(checkHeight(input) == -1)
            System.out.println("Not balanced");
        else
            System.out.println("Balanced!");
    }

    //O(n) solution
    public static int checkHeight(IsBalanced_On2.TreeNode root){
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
