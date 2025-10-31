package src.baekjoon.BOJ10845;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// link: https://www.acmicpc.net/problem/10845
// date: 2025-10-31
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(br.readLine());

        // when
        Deque<Integer> q = new ArrayDeque<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
                    break;
            }
        }

        // then
        System.out.println(sb);
        br.close();
    }
}
