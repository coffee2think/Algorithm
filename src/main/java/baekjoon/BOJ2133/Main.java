package baekjoon.BOJ2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-03
 * source: https://www.acmicpc.net/problem/2133
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;
        dp[4] = dp[2] * dp[2] + 2;
        dp[5] = 0;
        dp[6] = dp[4] * dp[2];

        br.close();
    }
}
