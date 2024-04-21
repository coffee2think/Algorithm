package src.baekjoon.BOJ4948;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime(i))
                    cnt++;
            }
            sb.append(cnt + "\n");
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
        br.close();
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}