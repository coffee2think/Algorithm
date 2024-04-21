package src.baekjoon.BOJ1966;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int targetIdx = M; // 목표 문서의 현재 인덱스
            int cnt = 0; // 출력된 순서를 저장할 변수

            st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            while (!queue.isEmpty()) {
                if (isTop(queue)) { // 최고 우선순위인 경우
                    cnt++;
                    if (targetIdx == 0){
                        break;
                    } else {
                        queue.poll();
                        targetIdx--;
                    }
                } else { // 최고 우선순위가 아닌경우
                    queue.add(queue.poll());
                    targetIdx = (targetIdx == 0) ? queue.size() - 1 : targetIdx - 1;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static boolean isTop(Queue<Integer> queue) {
        int front = queue.peek();

        for (int i = 9; i > front; i--) {
            if(queue.contains(i))
                return false;
        }
        return true;
    }
}
