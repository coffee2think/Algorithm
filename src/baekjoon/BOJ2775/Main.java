package src.baekjoon.BOJ2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// source: https://www.acmicpc.net/problem/2775

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // given
        int T = Integer.parseInt(br.readLine());

        // solution
        int[][] inhabitants = new int[15][15];

        // 0층 거주민 초기화
        for (int i = 0; i < inhabitants[0].length; i++) {
            inhabitants[0][i] = i;
        }

        // (k, n) = sigma_{i=1}^{n} {(k-1, i)}
        //        = sigma_{i=1}^{n-1} {(k-1, i)} + (k-1, n)
        //        = (k, n-1) + (k-1, n)
        for (int y = 1; y < 15; y++) {
            for (int x = 1; x < 15; x++) {
                inhabitants[y][x] = inhabitants[y][x - 1] + inhabitants[y - 1][x];
            }
        }

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(inhabitants[k][n]).append("\n");
        }

        // output
        System.out.println(sb);
        br.close();
    }
}
