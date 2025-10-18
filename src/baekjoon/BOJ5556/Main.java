package src.baekjoon.BOJ5556;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/5556
// date: 2025-10-18
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            x = Math.min(x, N - x + 1);
            y = Math.min(y, N - y + 1);

            int color = Math.min(x, y) % 3;
            if (color == 0) color = 3;

            sb.append(color).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
