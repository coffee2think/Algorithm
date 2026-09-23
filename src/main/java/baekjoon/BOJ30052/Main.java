package baekjoon.BOJ30052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-04-26
 * source: https://www.acmicpc.net/problem/30052
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(br.readLine());

        // when
        int D0 = N / 2 + M / 2; // 한 모서리로부터 가장 먼 중심까지의 거리
        int coefficient = 1 * (N % 2 == 0 ? 2 : 1) * (M % 2 == 0 ? 2 : 1); // 대칭 계수

        int n, m;
        int partialSum = 0; // 부분의 크기를 저장할 변수
        if (N % 2 == 0 && M % 2 == 0) {
            n = Math.min((N + 1) / 2, D - D0);
            m = Math.max(D - D0 - (M + 1) / 2, 0);

            if (m == 0) {
                partialSum = n * (2 * (D - D0) - n + 1) / 2;
            } else {
                partialSum = m * ((M + 1) / 2) + (n - m) * (2 * (D - D0) - (m + n - 1)) / 2;
            }
        } else if (N % 2 == 0 || M % 2 == 0) {
            int even = N % 2 == 0 ? N : M;
            int odd = N % 2 == 0 ? M : N;

            n = Math.min(even / 2, D - D0);
            m = Math.max(D - D0 - (odd + 1) / 2, 0);

            if (m == 0) {
                partialSum = n * (2 * (D - D0) - n);
            } else {
                partialSum = m * odd + (n - m) * (2 * (D - D0) - (m + n));
            }
        } else {
            n = Math.min((N + 1) / 2, D - D0);
            m = Math.max(D - D0 - (M + 1) / 2, 0);

            partialSum = Math.min(2 * (D - D0) - 1, M);
            if (m == 0) {
                partialSum += 2 * ((n - 1) * (2 * (D - D0) - n - 1));
            } else {
                partialSum += 2 * ((m - 1) * M + (n - m) * (2 * (D- D0) - (n + m)));
            }
        }

        //then
        int total = coefficient * partialSum;
        System.out.println(total);
        br.close();
    }
}
