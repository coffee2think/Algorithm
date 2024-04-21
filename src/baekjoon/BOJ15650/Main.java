package src.baekjoon.BOJ15650;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dfs(N, M);
        System.out.println(sb.toString());

        br.close();
    }

    public static void dfs(int n, int m) {
        int[] arr = new int[m];
        boolean[] visited = new boolean[n + 1];
        dfs(arr, visited, 1, 0);
    }

    private static void dfs(int[] arr, boolean[] visited, int start, int depth) {
        if (depth == arr.length) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(arr, visited, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
