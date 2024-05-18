package src.baekjoon.BOJ13975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * date: 2024-05-18
 * source: https://www.acmicpc.net/problem/13975
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        while (T-- > 0) {
            // given
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            // when
            long sum = 0;
            while (pq.size() > 1) {
                long file1 = pq.poll();
                long file2 = pq.poll();
                sum += file1 + file2;
                pq.offer(file1 + file2);
            }

            // then
            sb.append(sum).append("\n");
        }

        // 최종 결과 출력
        System.out.println(sb.toString());
        br.close();
    }
}
