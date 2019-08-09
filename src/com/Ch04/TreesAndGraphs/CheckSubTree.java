package com.Ch04.TreesAndGraphs;

import com.util.AssortedMethods;
import com.util.TreeNode;

public class CheckSubTree {



   static boolean containsTree(TreeNode t1, TreeNode t2){
        if(t2 == null) return true;
        return subTree(t1,t2);
    }

   static private boolean subTree(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return false;
        } else if(t1.data==t2.data && matchTree(t1,t2)){
            return true;
        }
        return subTree(t1.left,t2) ||  subTree(t1.right,t2);
    }

   static private boolean matchTree(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null){
            return true;
        }
        else if(t1==null || t2 ==null){
            return false;
        } else if (t1.data != t2.data){
            return false;
        } else {
            return matchTree(t1.left,t2.left) && matchTree(t1.right,t2.right);
        }

    }
    public static void main(String[] args) {
        // t2 is a subtree of t1
        int[] array1 = {1, 2, 1, 3, 1, 1, 5};
        int[] array2 = {2, 3, 1};

        TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

        if (containsTree(t1, t2)) {
            System.out.println("t2 is a subtree of t1");
        } else {
            System.out.println("t2 is not a subtree of t1");
        }

        // t4 is not a subtree of t3
        int[] array3 = {1, 2, 3};
        TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

        if (containsTree(t3, t4)) {
            System.out.println("t4 is a subtree of t3");
        } else {
            System.out.println("t4 is not a subtree of t3");
        }
    }

}
