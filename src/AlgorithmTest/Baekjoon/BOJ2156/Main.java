package Baekjoon.BOJ2156;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[wine.length];
        dp[1] = wine[1];
        if (n > 1) dp[2] = dp[1] + wine[2];
        for (int i = 3; i < wine.length; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + wine[i - 1]) + wine[i], dp[i - 1]);
            /* 선택할 수 있는 3가지 경우
             * i-3에서 점프하여 i-1을 포함하고, i를 포함하는 경우
             * i-2에서 점프하고 i를 포함하는 경우
             * i-1까지의 최댓값에 i를 포함하지 않는 경우
             */
        }

        System.out.println(dp[n]);
        br.close();
    }
}
