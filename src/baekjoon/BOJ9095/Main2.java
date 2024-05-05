package src.baekjoon.BOJ9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-05
 * source: https://www.acmicpc.net/problem/9095
 */

// dp를 이용한 풀이
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // init dp array
        int[] dp = new int[11];
        dp[0] = 1;
        int count = 0;

        for (int i = 1; i < dp.length; i++) {
            count++;
            dp[i] += dp[i - 1];
            if (i >= 2) dp[i] += dp[i - 2];
            if (i >= 3) dp[i] += dp[i - 3];
        }

        System.out.println("반복문 실행 횟수: " + count);

        // input
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        // result
        System.out.println(sb);
        br.close();
    }
}
