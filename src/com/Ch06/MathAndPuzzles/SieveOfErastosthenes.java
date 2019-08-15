package com.Ch06.MathAndPuzzles;

public class SieveOfErastosthenes {


    private static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];

        init(flags);

        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            crossOff(flags, prime);

            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    private static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (!flags[next] && next < flags.length) {
            next++;
        }
        return next;

    }

    private static void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }

    }

    private static void init(boolean[] flags) {
        flags[0] = false;
        flags[1] = false;
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }

    }

    public static void main(String[] args) {
        boolean[] primes = sieveOfEratosthenes(4);
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }


}
