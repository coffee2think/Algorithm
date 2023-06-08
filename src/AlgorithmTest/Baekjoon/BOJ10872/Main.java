package AlgorithmTest.Baekjoon.BOJ10872;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        // 방법1
//        System.out.println(factorial(N));

        // 방법2
        int fact = 1;
        for (int i = 1; i <= N; ++i) {
            fact *= i;
        }
        System.out.println(fact);
    }

    public static int factorial(int n) {
        if (n < 2)
            return 1;
        else
            return n * factorial(n - 1);
    }
}