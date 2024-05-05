package src.baekjoon.BOJ2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * date: 2024-05-05
 * source: https://www.acmicpc.net/problem/2012
 */

// 우선순위큐를 이용한 풀이
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        long gap = 0;
        for (int i = 0; i < N; i++) {
            gap += Math.abs(pq.poll() - (i + 1));
        }

        System.out.println(gap);
        br.close();
    }
}
