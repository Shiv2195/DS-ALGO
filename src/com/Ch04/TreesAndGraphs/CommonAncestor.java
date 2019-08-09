package com.Ch04.TreesAndGraphs;

import com.util.TreeNode;

public class CommonAncestor {

     static class Result {
        public TreeNode node;
        public boolean isAncestor;

        public Result(TreeNode node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }

   static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if(r.isAncestor){
            return r.node;
        }
        return null;
    }

    private static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new Result(null, false);

        if (root == p && root == q) {
            return new Result(root, true);
        }
        Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) {
            return rx;
        }
        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) {
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(10);
        TreeNode n7 = root.find(6);
        TreeNode ancestor = commonAncestor(root, n3, n7);
        if (ancestor != null) {
            System.out.println(ancestor.data);
        } else {
            System.out.println("null");
        }
    }

}
