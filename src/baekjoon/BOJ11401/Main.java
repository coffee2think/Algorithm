package src.baekjoon.BOJ11401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-05-11
 * source: https://www.acmicpc.net/problem/11401
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int p = 1_000_000_007;

        // when
        long[] factorial = new long[N + 1];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= N; i++) {
            factorial[i] = (factorial[i - 1] * i) % p;
        }

        long A = factorial[N];
        long B = (factorial[K] * factorial[N - K]) % p;
        long result = (A * pow(B, p - 2, p)) % p;

        // then
        System.out.println(result);
        br.close();
    }

    public static long pow(long base, long exp, long divisor) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % divisor;
            }

            base = (base * base) % divisor;
            exp /= 2;
        }

        return result;
    }
}
