package baekjoon.BOJ2742;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// source: https://www.acmicpc.net/problem/2742

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = N; i > 0; i--) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
