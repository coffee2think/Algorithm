package src.baekjoon.BOJ1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * date: 2024-05-17
 * source: https://www.acmicpc.net/problem/1715
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        // when
        int sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            sum += a + b;
            pq.offer(a + b);
        }

        // then
        System.out.println(sum);
        br.close();
    }
}
