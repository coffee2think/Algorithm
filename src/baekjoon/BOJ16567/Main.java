package src.baekjoon.BOJ16567;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/16567
// date: 2025-10-21
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // given
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] road = new boolean[N];

        st = new StringTokenizer(br.readLine());
        road[0] = Integer.parseInt(st.nextToken()) == 1;
        int flipCount = road[0] ? 1 : 0;
        for (int i = 1; i < N; i++) {
            road[i] = Integer.parseInt(st.nextToken()) == 1; // false: 깨끗, true: 오염
            if (!road[i - 1] && road[i]) {
                flipCount++;
            }
        }

        // when
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                sb.append(flipCount).append("\n");
                continue;
            }

            int target = Integer.parseInt(st.nextToken()) - 1;

            // 이미 오염된 땅이면 변화 없음
            if (road[target]) {
                continue;
            }

            road[target] = true;

            // 타겟이 양 끝이라면,
            // 이웃하는 땅의 상태가 오염되었다면 유지, 아니라면 증가
            // (리팩토링하여 아래 코드와 합칠 수 있을듯)
            if (target == 0 || target == N - 1) {
                boolean neighbor = road[Math.abs(target - 1)];
                flipCount = flipCount + (neighbor ? 0 : 1);
                continue;
            }

            // 000 → 010 : flipCount 1개 증가
            // 101 → 111 : flipCount 1개 감소
            // 100 → 110, 001 → 011 : 변화 없음
            if (!road[target - 1] && !road[target + 1]) {
                flipCount++;
            } else if (road[target - 1] && road[target + 1]) {
                flipCount--;
            }
        }

        // then
        System.out.println(sb);
        br.close();
    }
}
