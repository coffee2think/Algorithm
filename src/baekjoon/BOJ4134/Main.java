package src.baekjoon.BOJ4134;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine());
            sb.append(findPrime(n) + "\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static long findPrime(long n) {
        if (n < 2)
            return 2;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return findPrime(n + 1);
        }
        return n;
    }
}