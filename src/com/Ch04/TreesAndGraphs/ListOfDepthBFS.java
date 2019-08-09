package com.Ch04.TreesAndGraphs;

import com.util.AssortedMethods;
import com.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepthBFS {

    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        AssortedMethods.printResult(list);
    }

    private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) current.add(root);

        while(current.size() > 0){
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for(TreeNode parent: parents){
                if(parent.left!=null){
                    current.add(parent.left);
                }
                if(parent.right!=null){
                    current.add(parent.right);
                }
            }
        }

        return result;
    }


}
