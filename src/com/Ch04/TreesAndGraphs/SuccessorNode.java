package com.Ch04.TreesAndGraphs;

import com.util.TreeNode;

public class SuccessorNode {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = inorderSucc(node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }

    private static TreeNode inorderSucc(TreeNode node) {
        if(node.right!=null){
            return leftMostChild(node.right);
        }
        else{
            TreeNode q = node;
            TreeNode x = q.parent;
            while(x!=null && x.left!=q){
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private static TreeNode leftMostChild(TreeNode n) {
        if(n==null) return  null;
        while(n.left!=null){
            n= n.left;
        }
        return n;
    }
}
