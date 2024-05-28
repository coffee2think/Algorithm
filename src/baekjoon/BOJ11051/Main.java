package src.baekjoon.BOJ11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-05-28
 * source: https://www.acmicpc.net/submit/11051
 */

public class Main {
    public static final int DIVISOR = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (K > N - K) {
            K = N - K; // (n k) = (n n-k)
        }

        // process
        int[][] comb = new int[N + 1][K + 1];
        comb[1][0] = 1;
        if (K > 0) comb[1][1] = 1;

        for (int n = 2; n <= N; n++) {
            for (int k = 0; k <= K; k++) {
                comb[n][k] = (k < 1 ? 0 : comb[n - 1][k - 1]) + comb[n - 1][k];
                comb[n][k] %= DIVISOR;
            }
        }

        // result
        System.out.println(comb[N][K]);
        br.close();
    }
}
