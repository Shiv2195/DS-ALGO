package com.Ch04.TreesAndGraphs;

import com.util.TreeNode;

public class BalanceTree {
    public static void main(String[] args) {
        // Create balanced tree
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);


        System.out.println("Is balanced? " + isBalanced(root));

        root.insertInOrder(4); // Add 4 to make it unbalanced

        System.out.println("Is balanced? " + isBalanced(root));
    }

    private static boolean isBalanced(TreeNode root) {
        return checkHeight(root)!=Integer.MIN_VALUE;
    }

    private static int checkHeight(TreeNode root) {
        if (root==null) return  -1;

       int heightLeft = checkHeight(root.left);
       if(heightLeft==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightRight = checkHeight(root.right);
        if(heightRight==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int diffInHeight = heightLeft - heightRight;

        if(Math.abs(diffInHeight)> 1){
            return Integer.MIN_VALUE;
        }
        else{
            return Math.max(heightLeft,heightRight) + 1;
        }



    }

}
