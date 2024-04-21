package src.baekjoon.BOJ1904;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(N));

        br.close();
    }

    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 15746;
        }

        return f[n];
    }
}
