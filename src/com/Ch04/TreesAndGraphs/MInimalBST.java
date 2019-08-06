package com.Ch04.TreesAndGraphs;

import com.util.TreeNode;

public class MInimalBST {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Created BST? " + root.isBST());
//        System.out.println("Height: " + root.height());
    }

}
