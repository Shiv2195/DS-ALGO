package com.util;





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

}
