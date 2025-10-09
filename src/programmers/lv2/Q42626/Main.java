package src.programmers.lv2.Q42626;

// link: https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=java
// date: 2025-10-09

import java.util.Objects;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // given
        int[][] scoville = {
                {1, 2, 3, 9, 10, 12}
        };
        int[] K = {
                7
        };
        int[] answer = {
                2
        };

        // when
        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (Objects.deepEquals(solution(scoville[i], K[i]), answer[i])) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        // then
        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, cases, ((double) answerCount / cases * 100));
    }

    // solved date: 2025-10-09
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }

        int count = 0;
        while (!pq.isEmpty() && pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + second * 2;
            pq.add(newScoville);
            count++;
        }

        if (!pq.isEmpty() && pq.peek() < K) {
            count = -1;
        }

        return count;
    }
}
