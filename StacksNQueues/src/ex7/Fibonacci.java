package ex7;

import java.util.Scanner;

public class Fibonacci {
    static long[] memory;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];

        long a = System.currentTimeMillis();
        System.out.println(calcFibo(n));
        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }

    private static long calcFibo(int n) {

        if (n < 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        return memory[n] = calcFibo(n - 1) + calcFibo(n - 2);
    }
}
