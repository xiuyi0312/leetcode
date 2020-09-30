package com.op.leetcode;

public class PrimeCount {
    public static void main(String[] args) {
        PrimeCount primeCount = new PrimeCount();
        System.out.println(primeCount.countPrimes(0));
        System.out.println(primeCount.countPrimes(1));
        System.out.println(primeCount.countPrimes(2));
        System.out.println(primeCount.countPrimes(10));
    }
    public int countPrimes(int n) {
        int count = 0;
        int startNumber = 0;
        while (startNumber < n) {
            if (isPrime2(startNumber)) {
                count++;
            }
            startNumber ++;
        }
        return count;
    }

    private boolean isPrime2(long number) {
        if (number < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                // find a num can divide this number, so it's not a prime
                return false;
            }
        }
        return true;
    }
}
