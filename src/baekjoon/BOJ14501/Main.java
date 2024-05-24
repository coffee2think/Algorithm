package src.baekjoon.BOJ14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-05-24
 * source: https://www.acmicpc.net/problem/14501
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int N = Integer.parseInt(br.readLine()); // 남은 출근일
        int[] times = new int[N]; // 상담 기간
        int[] profits = new int[N]; // 상담비
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int[] dp = new int[N + 1]; // N번째 날짜까지의 최대수익
        for (int i = 0; i < N; i++) {
            int endDate = i + times[i]; // 상담 종료일

            // 상담 종료일이 퇴사일 전이면
            // 종료일에 기록된 최대수익 vs 어제까지의 최대수익 + 오늘 상담비
            if (endDate <= N) {
                dp[endDate] = Math.max(dp[endDate], dp[i] + profits[i]);
            }

            // 어제와 오늘 중 최댓값으로 dp 갱신
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        // then
        System.out.println(dp[N]);
        br.close();
    }
}
