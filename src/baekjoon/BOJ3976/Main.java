package src.baekjoon.BOJ3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon Q3976 실버2
 * Problem name: 역습
 * link: https://www.acmicpc.net/problem/3976
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());

        while (c --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] difficulty = new int[n - 1][4];

            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            int[] striker1 = new int[n];
            int[] striker2 = new int[n];

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n - 1; i++) {
                    difficulty[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            striker1[0] = l1; // 스트라이커1이 롱패스 받음
            striker2[0] = l2; // 스트라이커2가 롱패스 받음

            for (int i = 1; i < n; i++) {
                striker1[i] = Math.min(striker1[i - 1] + difficulty[i - 1][1], striker2[i - 1] + difficulty[i - 1][2]);
                striker2[i] = Math.min(striker1[i - 1] + difficulty[i - 1][0], striker2[i - 1] + difficulty[i - 1][3]);
            }

            striker1[n - 1] += s1; // 스트라이커1이 슛을 함
            striker2[n - 1] += s2; // 스트라이커2가 슛을 함

            sb.append(Math.min(striker1[n - 1], striker2[n - 1])).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
