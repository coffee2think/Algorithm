package src.baekjoon.BOJ11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-05-21
 * source: https://www.acmicpc.net/problem/11049
 */

public class Main {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][2];
        dp = new int[N][N];
        for (int i = 0; i < matrix.length; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken()); // row
            matrix[i][1] = Integer.parseInt(st.nextToken()); // column
        }

        // print result
        int result = minMatrixProduct(matrix, 0, N - 1);
        System.out.println(result);
        br.close();
    }

    public static int minMatrixProduct(int[][] matrix, int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (dp[start][end] > 0) {
            return dp[start][end];
        }

        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            // start ~ i 까지의 최소 연산 횟수
            // + (i + 1) ~ end 까지의 최소 연산 횟수
            // + "start ~ i 곱한 행렬"과 "(i + 1) ~ end 곱한 행렬"을 곱할 때 필요한 연산 횟수
            int count = minMatrixProduct(matrix, start, i)
                    + minMatrixProduct(matrix, i + 1, end)
                    + matrix[start][0] * matrix[i][1] * matrix[end][1];
            min = Math.min(min, count);
        }

        dp[start][end] = min;
        return min;
    }
}
