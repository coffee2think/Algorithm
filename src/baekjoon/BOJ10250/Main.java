package src.baekjoon.BOJ10250;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/10250
// date: 2025-11-04
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int X = N / H + 1;
            int Y = N % H;

            if (Y == 0) {
                Y = H;
                X--;
            }

            sb.append(Y * 100 + X).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
