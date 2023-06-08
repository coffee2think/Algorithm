package AlgorithmTest.Baekjoon.BOJ15649;

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
        boolean[] visited = new boolean[n + 1];
        backtrack(arr, visited, 0);
    }

    private static void backtrack(int[] arr, boolean[] visited, int depth) {
        if (depth == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = 1; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[depth] = i;
                    backtrack(arr, visited, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
