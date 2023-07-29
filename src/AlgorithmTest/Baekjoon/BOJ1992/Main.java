package AlgorithmTest.Baekjoon.BOJ1992;

import java.io.*;

public class Main {
    private static char[][] image;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        image = new char[N][N];
        for (int i = 0; i < N; i++) {
            image[i] = br.readLine().toCharArray();
        }

        solution(0, 0, N);

        System.out.println(sb);
        br.close();
    }

    public static void solution(int row, int col, int size) {
        if (isUniformed(row, col, size)) {
            sb.append(image[row][col]);
            return;
        }

        int newSize = size / 2;

        sb.append("(");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solution(row + newSize * i, col + newSize * j, newSize);
            }
        }
        sb.append(")");
    }

    public static boolean isUniformed(int row, int col, int size) {
        boolean result = true;
        char leadingColor = image[row][col];

        OUTER:
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (image[i][j] != leadingColor) {
                    result = false;
                    break OUTER;
                }
            }
        }

        return result;
    }
}
