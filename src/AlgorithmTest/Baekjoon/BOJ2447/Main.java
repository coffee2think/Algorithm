package AlgorithmTest.Baekjoon.BOJ2447;

import java.io.*;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        fractal(arr);

        for (int i = 0; i < arr.length; i++) {
            sb.append(String.valueOf(arr[i])).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void fractal(char[][] arr) {
        fractal(0, 0, arr.length, false);
    }

    private static void fractal(int x, int y, int size, boolean isBlank) {
        if (isBlank) {
            for (int j = y; j < y + size; j++) {
                for (int i = x; i < x + size; i++) {
                    arr[j][i] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            arr[y][x] = '*';
            return;
        }

        int lowerSize = size / 3;
        int cnt = 0;
        for (int j = y; j < y + size; j += lowerSize) {
            for (int i = x; i < x + size; i += lowerSize) {
                if (++cnt == 5) {
                    fractal(i, j, lowerSize, true);
                } else {
                    fractal(i, j, lowerSize, false);
                }
            }
        }
    }
}
