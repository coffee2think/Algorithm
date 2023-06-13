package AlgorithmTest.Baekjoon.BOJ15652;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        backtrack(N, M);
        System.out.println(sb);

        br.close();
    }

    public static void backtrack(int n, int m) {
        int[] arr = new int[m];
        backtrack(arr, n, 1, 0);
    }

    private static void backtrack(int[] arr, int maxNum, int start, int depth) {
        if (depth == arr.length) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= maxNum; i++) {
            arr[depth] = i;
            backtrack(arr, maxNum, i, depth + 1);
        }
    }
}
