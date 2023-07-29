package AlgorithmTest.Baekjoon.BOJ2630;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int whitePaper, bluePaper;
    private static int[][] paper;
    private static int[][] psum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        psum = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                psum[i + 1][j + 1] = psum[i][j + 1] + psum[i + 1][j] - psum[i][j] + paper[i][j];
            }
        }

        colorCheck(0, 0, N);

        System.out.println(whitePaper + "\n" + bluePaper);
        br.close();
    }

    public static void colorCheck(int row, int col, int size) {
        if (size == 1) {
            if (paper[row][col] == 0) whitePaper++;
            else bluePaper++;
            return;
        }

        int innerSum = psum[row + size][col + size] - psum[row + size][col] - psum[row][col + size] + psum[row][col];
        if (innerSum == 0) {
            whitePaper++;
        } else if (innerSum == size * size) {
            bluePaper++;
        } else {
            int newSize = size / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    colorCheck(row + newSize * i, col + newSize * j, newSize);
                }
            }
        }
    }
}
