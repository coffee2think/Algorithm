package baekjoon.BOJ11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-05-18
 * source: https://www.acmicpc.net/problem/11066
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        while (T-- > 0) {
            // given
            int K = Integer.parseInt(br.readLine());
            int[] psum = new int[K + 1]; // 누적합을 저장할 배열
            int[][] dp = new int[K][K]; // dp[i][j] = i번째부터 j번째까지 파일을 합치는데 필요한 최소 비용

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                int file = Integer.parseInt(st.nextToken());
                psum[i + 1] = psum[i] + file;
            }

            // when
            for (int i = 0; i < K; i++) {
                for (int j = i; j < K; j++) {
                    dp[i][j] = Integer.MAX_VALUE;

                }
            }

            // then
            sb.append(dp[0][K - 1]).append("\n");
        }

        // then
        System.out.println(sb.toString());
        br.close();
    }
}
