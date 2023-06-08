package AlgorithmTest.Baekjoon.BOJ10870;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibo(n - 1) + fibo(n - 2);
        }
    }
}
