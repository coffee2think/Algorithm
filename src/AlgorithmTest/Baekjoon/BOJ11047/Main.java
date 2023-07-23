package AlgorithmTest.Baekjoon.BOJ11047;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int idx = N;
        while (K > 0 && --idx >= 0) {
            if (K >= coins[idx]) {
                cnt += K / coins[idx];
                K %= coins[idx];
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
