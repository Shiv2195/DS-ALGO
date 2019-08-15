package com.Ch08.RecursionAndDP;

public class TripeStep {


    public static int countways(int n) {
        int memo[] = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(countways(4));

    }
}
