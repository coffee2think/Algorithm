package src.baekjoon.BOJ2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-26
 * source: https://www.acmicpc.net/problem/2193
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        // when
        long[] count = new long[N + 1];
        long[] psum = new long[N + 1];
        count[1] = 1;
        psum[1] = count[1];

        if (N > 1) {
            count[2] = 1;
            psum[2] = psum[1] + count[2];
        }

        for (int i = 3; i <= N; i++) {
            count[i] = psum[i - 2] + 1;
            psum[i] = psum[i - 1] + count[i];
        }

        // then
        System.out.println(count[N]);
        br.close();
    }
}
