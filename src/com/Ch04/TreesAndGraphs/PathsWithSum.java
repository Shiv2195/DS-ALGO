package com.Ch04.TreesAndGraphs;

import com.util.TreeNode;

import java.util.HashMap;

public class PathsWithSum {

        public static int countPathsWithSum(TreeNode root, int targetSum) {
            return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
        }

        public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
            if (node == null) return 0;

            runningSum += node.data;

            int sum = runningSum - targetSum;
            int totalPaths = pathCount.getOrDefault(sum, 0);

            if (runningSum == targetSum) {
                totalPaths++;
            }


            incrementHashTable(pathCount, runningSum, 1);


            totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
            totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);

            incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
            return totalPaths;
        }

        public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
            int newCount = hashTable.getOrDefault(key, 0) + delta;
            if (newCount == 0) {
                hashTable.remove(key);
            } else {
                hashTable.put(key, newCount);
            }
        }

        public static void main(String [] args) {
		/*
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(0);
		System.out.println(countPathsWithSum(root, 0));
		*/

		/*TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, 0));*/

            TreeNode root = new TreeNode(0);
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            root.right.left = new TreeNode(0);
            root.right.left.right = new TreeNode(0);
            root.right.right = new TreeNode(0);
            System.out.println(countPathsWithSum(root, 0));
            System.out.println(countPathsWithSum(root, 4));
        }
    }
