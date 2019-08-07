package com.Ch04.TreesAndGraphs;

import com.util.TreeNode;

public class ValidateBST {
    public static Integer lastPrinted = null;



    public static void main(String[] args) {
        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 5;
        //node.left.right.data = 3;
        System.out.println(checkBST(node));

        test();
    }

    private static boolean checkBST(TreeNode node) {
        return checkBST(node.left,true);
    }

    private static boolean checkBST(TreeNode node, boolean isLeft) {
        if (node == null) return true;

        if (!checkBST(node.left, true)) return false;
        if (lastPrinted != null) {
            if (isLeft) {

                if (node.data < lastPrinted) {
                    return false;
                }
            } else {

                if (node.data <= lastPrinted) {
                    return false;
                }
            }
        }
        lastPrinted = node.data;

        if (!checkBST(node.right, false)) {
            return false;
        }
        return true;
    }

    public static void test() {
        TreeNode node;
        boolean condition;
        System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
        int[] array2 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array2);
        node.left.data = 2;
        node.print();
        lastPrinted = null;
        condition = checkBST(node);
        System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
        int[] array3 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array3);
        node.right.data = 2;
        node.print();
        lastPrinted = null;
        condition = checkBST(node);
        System.out.println("should be false: " + condition);
    }
}

