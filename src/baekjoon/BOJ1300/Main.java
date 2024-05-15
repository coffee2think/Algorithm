package src.baekjoon.BOJ1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-15
 * source: https://www.acmicpc.net/problem/1300
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // when
        int answer = 0;
        int left = 1;
        int right = K;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count < K) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        // then
        System.out.println(answer);
        br.close();
    }
}
