package src.baekjoon.BOJ30802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/30802
// date: 2025-11-04
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(br.readLine());

        int[] sizes = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // solution
        int tCount = 0;
        for (int size : sizes) {
            tCount += (size + T - 1) / T;
        }

        sb.append(tCount).append("\n")
                .append(N / P).append(" ").append(N % P);

        // print result
        System.out.println(sb);
        br.close();
    }
}
