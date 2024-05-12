package src.baekjoon.BOJ11444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-12
 * source: https://www.acmicpc.net/problem/11444
 */

public class Main {
    public static final int p = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        // F_{n}   = F_{n-1} + F_{n-2}
        // F_{n-1} = F_{n-1} + 0
        long[][] base = {
                {1, 1},
                {1, 0}
        };

        long[][] result = multiplyMatrices(powerOfMatrix(base, n - 1), new long[][]{{1L}, {0L}});
        System.out.println(result[0][0]);
        br.close();
    }

    public static long[][] powerOfMatrix(long[][] matrix, long B) {
        if (B == 1) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] %= p;
                }
            }
            return matrix;
        } else if (B == 0) {
            long[][] unitMatrix = new long[matrix.length][matrix.length];
            for (int i = 0; i < unitMatrix.length; i++) {
                unitMatrix[i][i] = 1;
            }
            return unitMatrix;
        }

        long[][] half = powerOfMatrix(matrix, B / 2);
        return (B % 2 == 0) ? multiplyMatrices(half, half) : multiplyMatrices(multiplyMatrices(half, half), matrix);
    }

    public static long[][] multiplyMatrices(long[][] matrix1, long[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new UnsupportedOperationException("행렬 곱셈을 실행할 수 없음");
        }

        long[][] result = new long[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    result[i][j] %= p;
                }
            }
        }

        return result;
    }
}
