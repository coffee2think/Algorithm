package src.baekjoon.BOJ2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Baekjoon Q2346 실버3
 * Problem name: 풍선 터뜨리기
 * link: https://www.acmicpc.net/problem/2346
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] move = new int[N];
        for (int i = 0; i < N; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        // when
        // 사용할 덱 초기화
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(i + 1);
        }

        // 첫 번째 풍선을 꺼내서 기록함
        int balloon = deque.pollFirst();
        sb.append(balloon);

        while (!deque.isEmpty()) {
            // 양수이면 앞에서 꺼내서 뒤로 넣고
            // 음수이면 뒤에서 꺼내서 앞으로 넣음. 0인 경우는 주어지지 않으므로 else 처리
            // 한바퀴 도는 경우를 방지하기 위해 나머지 연산
            if (move[balloon - 1] > 0) {
                for (int i = 0; i < (move[balloon - 1] - 1) % deque.size(); i++) {
                    deque.addLast(deque.pollFirst());
                }
                balloon = deque.pollFirst();
            } else {
                for (int i = 0; i < (Math.abs(move[balloon - 1]) - 1) % deque.size(); i++) {
                    deque.addFirst(deque.pollLast());
                }
                balloon = deque.pollLast();
            }

            // 꺼낸 풍선을 기록함
            sb.append(" ").append(balloon);
        }

        // then
        System.out.println(sb.toString());
        br.close();
    }
}
