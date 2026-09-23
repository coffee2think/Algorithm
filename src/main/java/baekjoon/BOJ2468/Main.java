package baekjoon.BOJ2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());
        int[][] elevationMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                elevationMap[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        // solution
        // bfs 너비 우선 탐색
        // dfs 깊이 우선 탐색
        // N을 초과하는 높이를 탐색

        // print result

        br.close();
    }
}
