package src.baekjoon.BOJ2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-01
 * source: https://www.acmicpc.net/problem/2231
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int constructor = 0;
        for (int i = 1; i < N; i++) {
            int M = i;
            int sum = M;

            while(M != 0) {
                sum += M % 10;
                M /= 10;
            }

            if (sum == N) {
                constructor = i;
                break;
            }
        }

        System.out.println(constructor);
        br.close();
    }
}
