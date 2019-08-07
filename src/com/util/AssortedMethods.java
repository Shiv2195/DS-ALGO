package com.util;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class AssortedMethods {
    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static boolean randomBoolean() {
        return randomIntInRange(0, 1) == 0;
    }

    public static boolean randomBoolean(int percentTrue) {
        return randomIntInRange(1, 100) <= percentTrue;
    }

    public static boolean[][] randomBooleanMatrix(int M, int N, int percentTrue) {
        boolean[][] matrix = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomBoolean(percentTrue);
            }
        }
        return matrix;
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }


    public static int[] randomArray(int N, int min, int max) {
        int[] array = new int[N];
        for (int j = 0; j < N; j++) {
            array[j] = randomIntInRange(min, max);
        }
        return array;
    }

    public static LinkedListNode randomLinkedList(int N, int min, int max) {
        LinkedListNode root = new LinkedListNode(randomIntInRange(min, max),
                null, null);
        LinkedListNode prev = root;
        for (int i = 1; i < N; i++) {
            int data = randomIntInRange(min, max);
            LinkedListNode next = new LinkedListNode(data, null, null);
            prev.setNext(next);
            prev = next;
        }
        return root;
    }

    public static LinkedListNode linkedListWithValue(int N, int value) {
        LinkedListNode root = new LinkedListNode(value, null, null);
        LinkedListNode prev = root;
        for (int i = 1; i < N; i++) {
            LinkedListNode next = new LinkedListNode(value, null, null);
            prev.setNext(next);
            prev = next;
        }
        return root;
    }

    public static LinkedListNode createLinkedListFromArray(int[] vals) {
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        return head;
    }

    public static TreeNode createTreeFromArray(int[] array) {
        if (array.length > 0) {
            TreeNode root = new TreeNode(array[0]);
            java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
            queue.add(root);
            boolean done = false;
            int i = 1;
            while (!done) {
                TreeNode r = (TreeNode) queue.element();
                if (r.left == null) {
                    r.left = new TreeNode(array[i]);
                    i++;
                    queue.add(r.left);
                } else if (r.right == null) {
                    r.right = new TreeNode(array[i]);
                    i++;
                    queue.add(r.right);
                } else {
                    queue.remove();
                }
                if (i == array.length) {
                    done = true;
                }
            }
            return root;
        } else {
            return null;
        }
    }


    public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;
        for (LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while (i.hasNext()) {
                System.out.print(" " + ( i.next()).data);
            }
            System.out.println();
            depth++;
        }

    }
}
