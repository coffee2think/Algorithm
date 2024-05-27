package src.baekjoon.BOJ11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-27
 * source: https://www.acmicpc.net/problem/11726
 */

public class Main {
    public static final int DIVISOR = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }

        // when
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIVISOR;
        }

        // then
        System.out.println(dp[n]);
        br.close();
    }
}
