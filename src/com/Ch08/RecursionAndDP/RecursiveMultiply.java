package com.Ch08.RecursionAndDP;

public class RecursiveMultiply {

    public static int counter = 0;

    private static int minProduct(int a, int b) {
        int bigger = a > b ? a : b;
        int smaller = b > a ? a : b;
        return minProductHelper(smaller, bigger);
    }

    private static int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;

        int s = smaller >> 1;
        int halfProduct = minProductHelper(s, bigger);

        if (smaller % 2 == 0) {
            counter++;
            return halfProduct + halfProduct;
        } else {
            counter += 2;
            return halfProduct + halfProduct + bigger;
        }

    }

    public static void main(String[] args) {
        int a = 13494;
        int b = 22323;
        int product = a * b;
        int minProduct = minProduct(a, b);
        if (product == minProduct) {
            System.out.println("Success: " + a + " * " + b + " = " + product);
        } else {
            System.out.println("Failure: " + a + " * " + b + " = " + product + " instead of " + minProduct);
        }
        System.out.println("Adds: " + counter);
    }


}
