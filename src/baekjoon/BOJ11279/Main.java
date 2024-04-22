package src.baekjoon.BOJ11279;

import java.io.*;
import java.util.PriorityQueue;

/**
 * Baekjoon Q11279 실버2
 * Problem name: 최대 힙
 * link: https://www.acmicpc.net/problem/11279
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); // 최대힙
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                sb.append(!pq.isEmpty() ? pq.poll() : 0).append("\n");
            } else {
                pq.offer(input);
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}
