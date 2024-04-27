package src.baekjoon.BOJ11866;

import java.io.*;
import java.util.*;

/**
 * date: 2024-04-27
 * source: https://www.acmicpc.net/problem/11866
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // when
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add((i + K + N - 1) % N + 1);
        }

        sb.append("<").append(queue.poll());
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                queue.add(queue.poll());
            }
            sb.append(", ").append(queue.poll());
        }
        sb.append(">");

        // then
        System.out.println(sb);
        br.close();
    }
}
