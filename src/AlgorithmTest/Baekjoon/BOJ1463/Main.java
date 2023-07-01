package AlgorithmTest.Baekjoon.BOJ1463;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = N - 1; i > 0; i--) {
            if (i * 3 <= N) {
                dp[i] = Math.min(Math.min(dp[3 * i], dp[2 * i]), dp[i + 1]) + 1;
            } else if (i * 2 <= N) {
                dp[i] = Math.min(dp[2 * i], dp[i + 1]) + 1;
            } else {
                dp[i] = dp[i + 1] + 1;
            }
        }

        System.out.println(dp[1]);
        br.close();
    }
}
