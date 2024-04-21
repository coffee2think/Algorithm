package src.baekjoon.BOJ24416;

import java.io.*;

public class Main {
    static int cntRecursive = 0;
    static int cntDynamic = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        fib(N);
        fibonacci(N);

        System.out.println(cntRecursive + " " + cntDynamic);
        br.close();
    }

    public static long fib(int n) {
        if (n == 1 || n == 2) {
            cntRecursive++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static long fibonacci(int n) {
        long[] f = new long[n];
        f[0] = f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            cntDynamic++;
        }
        return f[n - 1];
    }
}
