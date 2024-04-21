package src.baekjoon.BOJ25682;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] board = new String[N];
        int[][] psum_B = new int[N + 1][M + 1]; // 첫째칸이 Black일 경우의 누적합 배열
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                psum_B[i + 1][j + 1] = psum_B[i][j + 1] + psum_B[i + 1][j] - psum_B[i][j];
                if ((i + j) % 2 == 0 && board[i].charAt(j) == 'B') psum_B[i + 1][j + 1]++;
                else if ((i + j) % 2 == 1 && board[i].charAt(j) == 'W') psum_B[i + 1][j + 1]++;
            }
        }

        int max = 0;
        int correct_B, correct_W; // 첫째칸이 Black인 경우와 White인 경우 각각에서 K*K 배열에 올바르게 배치된 개수
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                correct_B = psum_B[i][j] - psum_B[i][j - K] - psum_B[i - K][j] + psum_B[i - K][j - K];
                correct_W = K * K - correct_B;
                max = Math.max(max, Math.max(correct_B, correct_W));
            }
        }

        System.out.println(K * K - max);
        br.close();
    }
}
