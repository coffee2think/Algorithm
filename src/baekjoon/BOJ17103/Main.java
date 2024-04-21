package src.baekjoon.BOJ17103;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        boolean[] primes = new boolean[1_000_001];
        primes[0] = primes[1] = true; // false : 소수, true : 소수 아님
        for (int i = 2; i <= Math.sqrt(1_000_000); ++i) {
            if (!primes[i]) {
                for (int j = i * i; j < primes.length; j += i) { // i*i부터 시작하는 이유 : i 이전의 수에 대해서는 이미 걸러져서 연산할 필요가 없음
                    primes[j] = true;
                }
            }
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int i = 2; i <= N / 2; ++i) {
                if (!primes[i] && !primes[N - i]) {
                    cnt++;
                }
            }

            sb.append(cnt + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}