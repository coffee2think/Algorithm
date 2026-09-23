package baekjoon.BOJ11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 2024-05-28
 * source: https://www.acmicpc.net/problem/11055
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine()); // 0 <= N <= 1000
        int[] seq = new int[N + 1]; // 1 <= seq[i] <= 1000
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < seq.length; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int[][] dp = new int[N + 1][N + 1]; // dp[i][j] : i ~ j 까지 부분 수열의 최대 합
        int[][] max = new int[N + 1][N + 1]; // max[i][j] : i ~ j 까지 최대 합인 부분 수열의 최대항
        for (int i = 1; i< seq.length; i++) {
            dp[i][i] = seq[i];
            max[i][i] = seq[i];
        }

        for (int i = seq.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < seq.length; j++) {
                if (seq[j] >= max[i][j - 1]) {
                    // 현재 항이 이전 부분 수열의 최대항 이상이면(증가하면)
                    // 부분 수열에 현재 항을 추가하여 기록하고, 최대항 갱신
                    dp[i][j] = dp[i][j - 1] + seq[j];
                    max[i][j] = seq[j];

                    // 현재 부분 수열과 다음 부분 수열 중 큰 것으로 갱신
                    if (dp[i][j] <= dp[i + 1][j]) {
                        dp[i][j] = dp[i + 1][j];
                        max[i][j] = max[i + 1][j];
                    }
                } else {
                    // 현재 항이 이전 부분 수열의 최대항 미만이면
                    // 현재 부분 수열은 이전 부분 수열로 기록하고, 최대항도 이전 최대항으로 기록
                    dp[i][j] = dp[i][j - 1];
                    max[i][j] = max[i][j - 1];

                    // 현재 부분 수열과 다음 부분 수열 중 큰 것으로 갱신
                    if (dp[i][j] <= dp[i + 1][j]) {
                        dp[i][j] = dp[i + 1][j];
                        max[i][j] = max[i + 1][j];
                    }
                }
            }
        }

        System.out.println("dp------------");
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        // then
        System.out.println(dp[0][N]);
        br.close();
    }
}
